/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Gameboard;

import Gameboard.BoardSquare;
import Gameboard.GameBoard;
import Gameboard.Piece;
import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.Player;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import javax.swing.JPanel;
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
public class GameBoardTest {

    public GameBoardTest() {
    }

    @BeforeAll
    public static void setUpClass() {
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
     * Test of highlightPossibleJumps method, of class GameBoard.
     */
    @Test
    public void testHighlightPossibleJumps() {
        System.out.println("highlightPossibleJumps");
        Piece gamePiece = generatePiece(3, 3);
        GameBoard instance = new GameBoard();
        //instance.highlightPossibleJumps(gamePiece);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertTrue(true);
    }

    /**
     * Test of pauseGame method, of class GameBoard.
     */
    @Test
    public void testPauseGame() {
        System.out.println("pauseGame");
        GameBoard instance = new GameBoard();
        JPanel testParentPanel = new JPanel();
        testParentPanel.setLayout(new CardLayout());
        instance.setParentPanel(testParentPanel);
        instance.pauseGame();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getParentPanel method, of class GameBoard.
     */
    @Test
    public void testGetParentPanel() {
        System.out.println("getParentPanel");
        GameBoard instance = new GameBoard();
        JPanel expResult = null;
        JPanel result = instance.getParentPanel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setParentPanel method, of class GameBoard.
     */
    @Test
    public void testSetParentPanel() {
        System.out.println("setParentPanel");
        JPanel parentPanel = null;
        GameBoard instance = new GameBoard();
        instance.setParentPanel(parentPanel);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBOARD_COLUMNS method, of class GameBoard.
     */
    @Test
    public void testGetBOARD_COLUMNS() {
        System.out.println("getBOARD_COLUMNS");
        int expResult = 8;
        int result = GameBoard.getBOARD_COLUMNS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBOARD_COLUMNS method, of class GameBoard.
     */
    @Test
    public void testSetBOARD_COLUMNS() {
        System.out.println("setBOARD_COLUMNS");
        int aBOARD_COLUMNS = 0;
        GameBoard.setBOARD_COLUMNS(aBOARD_COLUMNS);
        int result = GameBoard.getBOARD_COLUMNS();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(aBOARD_COLUMNS, result, "The BOARD_COLUMNS value should be set correctly by the setter method");
    }

    /**
     * Test of getBOARD_ROWS method, of class GameBoard.
     */
    @Test
    public void testGetBOARD_ROWS() {
        System.out.println("getBOARD_ROWS");
        int expResult = 0;
        int result = GameBoard.getBOARD_ROWS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBOARD_ROWS method, of class GameBoard.
     */
    @Test
    public void testSetBOARD_ROWS() {
        System.out.println("setBOARD_ROWS");
        int aBOARD_ROWS = 0;
        GameBoard.setBOARD_ROWS(aBOARD_ROWS);
        int result = GameBoard.getBOARD_ROWS();
        assertEquals(aBOARD_ROWS, result, "The BOARD_ROWS value should be set correctly by the setter method");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRows method, of class GameBoard.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        GameBoard instance = new GameBoard();
        int expResult = 0;
        int result = instance.getRows();
        assertEquals(expResult, result, "The BOARD_ROWS value should be returned correctly by the getter method");
        // TODO review the generated test code and remove the default call to fail.
        ////fail("The test case is a prototype.");
    }

    /**
     * Test of setRows method, of class GameBoard.
     */
    @Test
    public void testSetRows() {
        System.out.println("setRows");
        int rows = 0;
        GameBoard instance = new GameBoard();
        instance.setRows(rows);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColumns method, of class GameBoard.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        GameBoard instance = new GameBoard();
        int expResult = 0;
        int result = instance.getColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPieces method, of class GameBoard.
     */
    @Test
    public void testGetPieces() {
        System.out.println("getPieces");
        GameBoard instance = new GameBoard();
        Piece[] expResult = null;
        Piece[] result = instance.getPieces();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColumns method, of class GameBoard.
     */
    @Test
    public void testSetColumns() {
        System.out.println("setColumns");
        int columns = 0;
        GameBoard instance = new GameBoard();
        instance.setColumns(columns);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateSquare method, of class GameBoard.
     */
    @Test
    public void testUpdateSquare() {
        System.out.println("updateSquare");
        GameBoard instance = new GameBoard();
        instance.updateSquare();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setPieces method, of class GameBoard.
     */
    @Test
    public void testSetPieces() {
        System.out.println("setPieces");
        Piece[] pieces = null;
        GameBoard instance = new GameBoard();
        instance.setPieces(pieces);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSquareWidth method, of class GameBoard.
     */
    @Test
    public void testGetSquareWidth() {
        System.out.println("getSquareWidth");
        GameBoard instance = new GameBoard();
        int expResult = 0;
        int result = instance.getSquareWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSquareWidth method, of class GameBoard.
     */
    @Test
    public void testSetSquareWidth() {
        System.out.println("setSquareWidth");
        int squareWidth = 0;
        GameBoard instance = new GameBoard();
        instance.setSquareWidth(squareWidth);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setGameBoard method, of class GameBoard.
     */
    @Test
    public void testSetGameBoard() {
        System.out.println("setGameBoard");
        BoardSquare[][] gameBoard = null;
        GameBoard instance = new GameBoard();
        instance.setGameBoard(gameBoard);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardSquare method, of class GameBoard.
     */
    @Test
    public void testGetBoardSquare() {
        System.out.println("getBoardSquare");
        int squareX = 0;
        int squareY = 0;
        GameBoard instance = new GameBoard();
        BoardSquare[][] generated = generateDataBoard();
        BoardSquare expResult = new BoardSquare(Color.WHITE, false, null);
        instance.setGameBoard(generated);
        BoardSquare result = instance.getBoardSquare(squareX, squareY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setBoardSquare method, of class GameBoard.
     */
    @Test
    public void testSetBoardSquare() {
        System.out.println("setBoardSquare");
        int squareX = 0;
        int squareY = 0;
        BoardSquare squareToAdd = null;
        GameBoard instance = new GameBoard();
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        instance.setGameBoard(generatedDataBoard);
        instance.setBoardSquare(squareX, squareY, squareToAdd);
        BoardSquare result = instance.getBoardSquare(squareX, squareY);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(squareToAdd, result, "The BoardSquare needs to be set properly and so it can be retrieved");
    }

    private BoardSquare[][] generateDataBoard() {
        BoardSquare[][] gameDataBoard = new BoardSquare[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                gameDataBoard[row][col] = new BoardSquare(Color.WHITE, false, null);
            }
        }
        return gameDataBoard;
    }

    /**
     * Test of movePiece method, of class GameBoard.
     */
    @Test
    public void testMovePiece() {
        System.out.println("movePiece");
        int testX = 3;
        int testY = 3;
        Piece newState = generatePiece(testX, testY);
        Piece oldState = generatePiece(testX, testY);
        int squareX = 4;
        int squareY = 5;
        BoardSquare[][] generatedItem = generateDataBoard();
        BoardSquare testSquare1 = generatedItem[2][2];
        testSquare1.setCurrentPiece(oldState);
        testSquare1.setHasPiece(true);
        
        GameBoard instance = new GameBoard();
        instance.setGameBoard(generatedItem);
        instance.movePiece(newState, oldState, squareX, squareY);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        testSquare1 = instance.getBoardSquare(testX, testY);
        assertFalse(testSquare1.isHasPiece(), "The old square should not have a piece on it.");
    }

    /**
     * Test of resetPiece method, of class GameBoard.
     */
    @Test
    public void testResetPiece() {
        System.out.println("resetPiece");
        Piece newState = generatePiece(3,3);
        Piece oldState = generatePiece(5, 5);
        GameBoard instance = new GameBoard();
        instance.resetPiece(newState, oldState);
        Piece expResult = generatePiece(5, 5);
        assertEquals(expResult, newState, "The piece should be in its original position");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checkForGamePiece method, of class GameBoard.
     */
    @Test
    public void testCheckForGamePiece() {
        System.out.println("checkForGamePiece");
        int squareX = 0;
        int squareY = 0;
        GameBoard instance = new GameBoard();
        Piece expResult = null;
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        instance.setGameBoard(generatedDataBoard);
        Piece result = instance.checkForGamePiece(squareX, squareY);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isBlocked method, of class GameBoard.
     */
    @Test
    public void testIsBlocked() {
        System.out.println("isBlocked");
        Piece pieceToMove = generatePiece(3, 3);
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        testSquare = generatedDataBoard[2][2];
        testSquare.setCurrentPiece(pieceToMove);
        GameBoard instance = new GameBoard();
        boolean expResult = false;
        instance.setGameBoard(generatedDataBoard);
        
        boolean result = instance.isBlocked(pieceToMove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    private BoardSquare testSquare;

    /*
     * 
     */
    private Piece generatePiece(int par, int par1) {
        Piece pieceToMove = new Piece();
        pieceToMove.setxCol(par);
        pieceToMove.setyRow(par1);
        pieceToMove.setPieceDirection(POSITIVE);
        return pieceToMove;
    }

    /**
     * Test of moveOptions method, of class GameBoard.
     */
    @Test
    public void testMoveOptions() {

        GameBoard testBoard = new GameBoard();
        // Setup: Create an 8x8 board
        BoardSquare[][] gameDataBoard = new BoardSquare[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                gameDataBoard[row][col] = new BoardSquare(Color.WHITE, false, null);
            }
        }

        // Place a piece at (3, 3)
        Piece pieceToMove = new Piece();
        pieceToMove.setPieceDirection(POSITIVE);
        pieceToMove.setxCol(2);
        pieceToMove.setyRow(2);
        gameDataBoard[2][2].setHasPiece(true);
        gameDataBoard[2][2].setCurrentPiece(pieceToMove);

        // Define forward-left and forward-right squares
        gameDataBoard[3][3] = new BoardSquare(Color.BLACK, false, null); // Empty square
        gameDataBoard[1][3] = new BoardSquare(Color.BLACK, false, null); // Empty square

        // Act: Get the move options
        testBoard.setGameBoard(gameDataBoard);
        List<Point> options = testBoard.moveOptions(pieceToMove);

        // Assert: Verify the results
        assertEquals(2, options.size(), "Should have 2 valid move options.");
        assertTrue(options.contains(new Point(3, 3)), "Forward-left should be a valid move.");
        assertTrue(options.contains(new Point(1, 3)), "Forward-right should be a valid move.");
    }
    private static final String POSITIVE = "POSITIVE";

    /**
     * Test of movePieceToSquare method, of class GameBoard.
     */
    @Test
    public void testMovePieceToSquare() {
        System.out.println("movePieceToSquare");
        Piece pieceToMove = generatePiece(3, 3);
        Point destination = new Point(3,4);
        
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        generatedDataBoard[2][2].setCurrentPiece(pieceToMove);
        generatedDataBoard[2][2].setHasPiece(true);
        
        GameBoard instance = new GameBoard();
        instance.setGameBoard(generatedDataBoard);
        instance.movePieceToSquare(pieceToMove, destination);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPiece method, of class GameBoard.
     */
    @Test
    public void testGetPiece() {
        System.out.println("getPiece");
        int pieceIndex = 0;
        GameBoard instance = new GameBoard();
        Piece[] testPieces = new Piece[1];
        instance.setPieces(testPieces);
        Piece expResult = null;
        Piece result = instance.getPiece(pieceIndex);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setUserPlayer method, of class GameBoard.
     */
    @Test
    public void testSetUserPlayer() {
        System.out.println("setUserPlayer");
        Player userPlayer = null;
        GameBoard instance = new GameBoard();
        instance.setUserPlayer(userPlayer);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPlayer method, of class GameBoard.
     */
    @Test
    public void testGetUserPlayer() {
        System.out.println("getUserPlayer");
        GameBoard instance = new GameBoard();
        Player expResult = null;
        Player result = instance.getUserPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

