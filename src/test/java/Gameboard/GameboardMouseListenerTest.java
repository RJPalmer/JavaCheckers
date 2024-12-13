/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Gameboard;

import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.Player;
import java.awt.event.MouseEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author robertpalmer
 */
public class GameboardMouseListenerTest {
    public static GameBoard board;
    public static Piece gamePiece;
    public static Piece moveCopy;
    public static int squareX;
    public static int squareY;
    public static int mouseX;
    public static int mouseY;
    public static GameboardMouseListener instance;
    public static BoardSquare[][] dataBoard;
    public static Game gameObject;
    
    public GameboardMouseListenerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        GameBoard.setBOARD_COLUMNS(10);
        GameBoard.setBOARD_ROWS(10);
        board = new GameBoard();
        dataBoard = new BoardSquare[10][10];
        gameObject = new Game();
        gameObject.setUserColor("Red");
        gameObject.setUserPlayer(new Player());
        instance = new GameboardMouseListener(board, gameObject);
        gamePiece = new Piece();
        moveCopy = new Piece();
        board.setGameBoard(dataBoard);
        board.setSquareWidth(10);
        board.setBoardSquare(4, 4, new BoardSquare(null, false, null));
        board.getBoardSquare(4, 4).setCurrentPiece(gamePiece);
        board.getBoardSquare(4, 4).setHasPiece(true);
        board.setGameBoard(dataBoard);
        instance.setBoard(board);
        
        

        
        
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getSquareX method, of class GameboardMouseListener.
     */
    @Test
    public void testGetSquareX() {
        System.out.println("getSquareX");
        
        int expResult = 0;
        int result = instance.getSquareX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSquareX method, of class GameboardMouseListener.
     */
    @Test
    public void testSetSquareX() {
        System.out.println("setSquareX");
        int squareX = 0;
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.setSquareX(squareX);
        assertEquals(squareX, instance.getSquareX());
        // TODO review the generated test code and remove the default call to fail.
        //` fail("The test case is a prototype.");
    }

    /**
     * Test of getSquareY method, of class GameboardMouseListener.
     */
    @Test
    public void testGetSquareY() {
        System.out.println("getSquareY");
        //GameboardMouseListener instance = new GameboardMouseListener();
        int expResult = 0;
        int result = instance.getSquareY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSquareY method, of class GameboardMouseListener.
     */
    @Test
    public void testSetSquareY() {
        System.out.println("setSquareY");
        int squareY = 0;
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.setSquareY(squareY);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mouseClicked method, of class GameboardMouseListener.
     */
    @Test
    public void testMouseClicked() {
        System.out.println("mouseClicked");
        MouseEvent e = new MouseEvent(board, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 45, 45,1,false);
        //MouseEvent e = null;
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.setCheckersGame(new Game());
        instance.mouseClicked(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mousePressed method, of class GameboardMouseListener.
     */
    @Test
    public void testMousePressed() {
        System.out.println("mousePressed");
        MouseEvent e = new MouseEvent(board, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 45, 45,1,false);
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.setCheckersGame(new Game());
        instance.mousePressed(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mouseReleased method, of class GameboardMouseListener.
     */
    @Test
    public void testMouseReleased() {
        System.out.println("mouseReleased");
        MouseEvent e = new MouseEvent(board, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 0, 45, 45,1,false);
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.mouseReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of mouseEntered method, of class GameboardMouseListener.
//     */
//    @Test
//    public void testMouseEntered() {
//        System.out.println("mouseEntered");
//        MouseEvent e = null;
//        GameboardMouseListener instance = new GameboardMouseListener();
//        instance.mouseEntered(e);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of mouseExited method, of class GameboardMouseListener.
     */
    @Test
    public void testMouseExited() {
        System.out.println("mouseExited");
        MouseEvent e = new MouseEvent(board, MouseEvent.MOUSE_EXITED, System.currentTimeMillis(), 0, 45, 45,1,false);
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.mouseExited(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mouseDragged method, of class GameboardMouseListener.
     */
    @Test
    public void testMouseDragged() {
        System.out.println("mouseDragged");
        MouseEvent e = new MouseEvent(board, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, 45, 45,1,false);        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.mouseDragged(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of mouseMoved method, of class GameboardMouseListener.
     */
    @Test
    public void testMouseMoved() {
        System.out.println("mouseMoved");
        MouseEvent e = new MouseEvent(board, MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 0, 45, 45,1,false);
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.mouseMoved(e);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBoard method, of class GameboardMouseListener.
     */
    @Test
    public void testSetBoard() {
        System.out.println("setBoard");
        //GameBoard board = null;
        //GameboardMouseListener instance = new GameboardMouseListener();
        instance.setBoard(board);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
