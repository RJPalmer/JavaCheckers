package Gameboard;

import com.mycompany.javacheckers.Game;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.lang.reflect.Field;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameboardMouseListenerTest {

    static {
        System.setProperty("java.awt.headless", "true");
    }

    private static GameBoard board;
    private static GameboardMouseListener listener;

    @BeforeAll
    static void setUpClass() {
        GameBoard.setBOARD_COLUMNS(8);
        GameBoard.setBOARD_ROWS(8);

        board = new GameBoard();
        board.setSquareWidth(10);

        BoardSquare[][] squares = new BoardSquare[8][8];
        for (int column = 0; column < 8; column++) {
            for (int row = 0; row < 8; row++) {
                squares[column][row] = new BoardSquare(null, false, null);
            }
        }

        setBoardData(board, squares);

        // Game extends JFrame and cannot be created headlessly.
        listener = new GameboardMouseListener(board, null);
    }

    @AfterAll
    static void tearDownClass() {
        listener = null;
        board = null;
    }

    @Test
    void squareCoordinatesCanBeReadAndWritten() {
        listener.setSquareX(3);
        listener.setSquareY(5);

        assertEquals(3, listener.getSquareX());
        assertEquals(5, listener.getSquareY());
    }

    @Test
    void boardCanBeReplaced() {
        assertDoesNotThrow(() -> listener.setBoard(board));
    }

    @Test
    void nonInteractiveMouseCallbacksDoNotRequireADisplay() {
        assertDoesNotThrow(() -> listener.mouseReleased(mouseEvent(MouseEvent.MOUSE_RELEASED)));
        assertDoesNotThrow(() -> listener.mouseExited(mouseEvent(MouseEvent.MOUSE_EXITED)));
        assertDoesNotThrow(() -> listener.mouseDragged(mouseEvent(MouseEvent.MOUSE_DRAGGED)));
        assertDoesNotThrow(() -> listener.mouseMoved(mouseEvent(MouseEvent.MOUSE_MOVED)));
    }

    @Test
    void clickAndPressRequireAGraphicalGameWindow() {
        Assumptions.assumeFalse(
                GraphicsEnvironment.isHeadless(),
                "Game extends JFrame and cannot be constructed headlessly");

        Game game = new Game();
        listener.setCheckersGame(game);

        assertDoesNotThrow(() -> listener.mouseClicked(mouseEvent(MouseEvent.MOUSE_CLICKED)));
        assertDoesNotThrow(() -> listener.mousePressed(mouseEvent(MouseEvent.MOUSE_PRESSED)));
    }

    private static MouseEvent mouseEvent(int eventType) {
        return new MouseEvent(
                board,
                eventType,
                System.currentTimeMillis(),
                0,
                45,
                45,
                1,
                false);
    }

    private static void setBoardData(GameBoard target, BoardSquare[][] squares) {
        try {
            Field gameDataBoard = GameBoard.class.getDeclaredField("gameDataBoard");
            gameDataBoard.setAccessible(true);
            gameDataBoard.set(target, squares);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Unable to initialize the test board", exception);
        }
    }
}
