package Gameboard;

import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.Player;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Headless tests for {@link GameboardMouseListener}.
 *
 * <p>These tests deliberately create only lightweight AWT event objects; they
 * do not display a window, create a Robot, or access a screen device.</p>
 */
class GameboardMouseListenerTest {

    static {
        // Set during class loading, before setup can construct any AWT component.
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
        for (int column = 0; column < squares.length; column++) {
            for (int row = 0; row < squares[column].length; row++) {
                squares[column][row] = new BoardSquare(null, false, null);
            }
        }
        setBoardData(board, squares);

        Game game = new Game();
        game.setUserColor("Red");
        game.setUserPlayer(new Player());
        listener = new GameboardMouseListener(board, game);
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
    void mouseCallbacksDoNotRequireADisplay() {
        Game emptyGame = new Game();
        emptyGame.setUserColor("Red");
        emptyGame.setUserPlayer(new Player());
        listener.setCheckersGame(emptyGame);

        assertDoesNotThrow(() -> listener.mouseClicked(mouseEvent(MouseEvent.MOUSE_CLICKED)));
        assertDoesNotThrow(() -> listener.mousePressed(mouseEvent(MouseEvent.MOUSE_PRESSED)));
        assertDoesNotThrow(() -> listener.mouseReleased(mouseEvent(MouseEvent.MOUSE_RELEASED)));
        assertDoesNotThrow(() -> listener.mouseExited(mouseEvent(MouseEvent.MOUSE_EXITED)));
        assertDoesNotThrow(() -> listener.mouseDragged(mouseEvent(MouseEvent.MOUSE_DRAGGED)));
        assertDoesNotThrow(() -> listener.mouseMoved(mouseEvent(MouseEvent.MOUSE_MOVED)));
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
}
