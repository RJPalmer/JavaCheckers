  package Gameboard;
  
import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.Player;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
  
        listener = new GameboardMouseListener(board, newHeadlessGame());
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
  
    /**
     * {@code setGameBoard} creates display resources, so it cannot be used by
     * a headless unit test.  Populate the listener's required data model only.
     */
    private static void setBoardData(GameBoard target, BoardSquare[][] squares) {
        try {
            Field gameDataBoard = GameBoard.class.getDeclaredField("gameDataBoard");
            gameDataBoard.setAccessible(true);
            gameDataBoard.set(target, squares);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Unable to initialize the test board", exception);
        }
    }

    /**
     * Game inherits from JFrame.  Allocate it without invoking JFrame's
     * display-dependent constructor, then initialize the state the listener
     * reads in its own constructor.
     */
    private static Game newHeadlessGame() {
        try {
            Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
            Field unsafeField = unsafeClass.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            Object unsafe = unsafeField.get(null);
            Method allocateInstance = unsafeClass.getMethod("allocateInstance", Class.class);
            Game game = (Game) allocateInstance.invoke(unsafe, Game.class);
            game.setUserColor("Red");
            game.setUserPlayer(new Player());
            return game;
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Unable to create a headless Game test double", exception);
        }
    }
}
