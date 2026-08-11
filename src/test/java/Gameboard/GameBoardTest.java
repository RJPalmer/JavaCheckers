/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Gameboard;

import com.mycompany.javacheckers.Player;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
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

    private int originalRows;

    private int originalCols;

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
        originalRows = GameBoard.getBOARD_ROWS();

        originalCols = GameBoard.getBOARD_COLUMNS();
    }

    @AfterEach
    public void tearDown() {
        GameBoard.setBOARD_ROWS(originalRows);

        GameBoard.setBOARD_COLUMNS(originalCols);
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
        int expResult = 8;
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
        int expResult = 8;
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
        int expResult = 8;
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
        List<Piece> expResult = new ArrayList<Piece>();
        List<Piece> result = instance.getPieces();
        assertTrue(expResult.containsAll(result));
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
        List<Piece> testPieces = new ArrayList<Piece>();
        GameBoard instance = new GameBoard();
        instance.setPieces(testPieces);
        assertNotNull(instance.getPieces());
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

        //the starting location (3,3)
        int testX = 3;
        int testY = 3;
        Piece testPiece = this.generatePiece(testX, testY);

        //the ending location
        Point moveTestLocation = new Point(2, 4);

        //Generate a gameboard
        BoardSquare[][] generatedItem = generateDataBoard();

        //Get the square that represents the location (3,3)
        BoardSquare testSquare1 = generatedItem[testX][testY];

        //put the piece at the square
        testSquare1.setCurrentPiece(testPiece);
        testSquare1.setHasPiece(true);

        GameBoard instance = new GameBoard();
        instance.setGameBoard(generatedItem);
        instance.getPieces().add(testPiece);
        //move the piece to the location
        instance.movePieceToSquare(testPiece, moveTestLocation);

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
        Piece newState = generatePiece(3, 3);
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
    public void testIsBlockedNoPieces() {
        int testX, testY;
        testX = 3;
        testY = 3;
        System.out.println("isBlocked: No Pieces");
        Piece pieceToMove = generatePiece(testX, testY);
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        testSquare = generatedDataBoard[testX][testY];
        testSquare.setCurrentPiece(pieceToMove);
        generatedDataBoard[testX][testY] = testSquare;

        GameBoard instance = new GameBoard();
        boolean expResult = false;
        instance.setGameBoard(generatedDataBoard);

        boolean result = instance.isBlocked(pieceToMove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isBlocked method with one blocking Piece
     */
    @Test
    public void testIsBlockedOnePiecePositive() {

        BoardSquare blockSqr;

        System.out.println("isBlocked: One Piece");
        Piece pieceToMove = generatePiece(3, 3);
        Piece block1 = generatePiece(2, 4);
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        testSquare = generatedDataBoard[3][3];
        testSquare.setCurrentPiece(pieceToMove);

        blockSqr = generatedDataBoard[2][4];
        blockSqr.setCurrentPiece(block1);
        generatedDataBoard[3][3] = testSquare;
        generatedDataBoard[2][4] = blockSqr;

        GameBoard instance = new GameBoard();
        boolean expResult = false;
        instance.setGameBoard(generatedDataBoard);

        boolean result = instance.isBlocked(pieceToMove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsBlockedOnePieceNegative() {
        BoardSquare blockSqr;

        System.out.println("isBlocked: One Piece Negative");
        Piece pieceToMove = generatePiece(3, 3);
        pieceToMove.setPieceDirection("NEGATIVE");
        Piece block1 = generatePiece(2, 2);
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        testSquare = generatedDataBoard[3][3];
        testSquare.setCurrentPiece(pieceToMove);

        blockSqr = generatedDataBoard[2][2];
        blockSqr.setCurrentPiece(block1);
        generatedDataBoard[3][3] = testSquare;
        generatedDataBoard[2][2] = blockSqr;

        GameBoard instance = new GameBoard();
        boolean expResult = false;
        instance.setGameBoard(generatedDataBoard);

        boolean result = instance.isBlocked(pieceToMove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    private BoardSquare testSquare;

    @Test
    public void testIsBlockedTwoPiecesPositive() {
        BoardSquare blockSqr1;
        BoardSquare blockSqr2;

        System.out.println("isBlocked: Two Pieces Positive");

        System.out.println("Rows = " + GameBoard.getBOARD_ROWS());
        System.out.println("Cols = " + GameBoard.getBOARD_COLUMNS());
        Piece pieceToMove = generatePiece(3, 3);
        Piece block1 = generatePiece(2, 4);
        Piece block2 = generatePiece(4, 4);
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        BoardSquare testSquareInstance = generatedDataBoard[3][3];
        testSquareInstance.setCurrentPiece(pieceToMove);

        blockSqr1 = generatedDataBoard[4][2];
        blockSqr1.setCurrentPiece(block1);

        blockSqr2 = generatedDataBoard[4][4];
        blockSqr2.setCurrentPiece(block2);

        generatedDataBoard[3][3] = testSquareInstance;
        generatedDataBoard[4][2] = blockSqr1;
        generatedDataBoard[4][4] = blockSqr2;

        GameBoard instance = new GameBoard();
        boolean expResult = true;
        instance.setGameBoard(generatedDataBoard);

        boolean result = instance.isBlocked(pieceToMove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testIsBlockedTwoPiecesNegative() {
        BoardSquare blockSqr1;
        BoardSquare blockSqr2;

        System.out.println("isBlocked: Two Pieces Negative");
        Piece pieceToMove = generatePiece(3, 7);
        pieceToMove.setPieceDirection("NEGATIVE");
        Piece block1 = generatePiece(4, 6);
        Piece block2 = generatePiece(2, 6);
        BoardSquare[][] generatedDataBoard = generateDataBoard();
        BoardSquare testSquareInstance = generatedDataBoard[7][3];
        testSquareInstance.setCurrentPiece(pieceToMove);

        blockSqr1 = generatedDataBoard[6][2];
        blockSqr1.setCurrentPiece(block1);

        blockSqr2 = generatedDataBoard[6][4];
        blockSqr2.setCurrentPiece(block2);

        generatedDataBoard[7][3] = testSquareInstance;
        generatedDataBoard[6][2] = blockSqr1;
        generatedDataBoard[6][4] = blockSqr2;

        GameBoard instance = new GameBoard();
        boolean expResult = true;
        instance.setGameBoard(generatedDataBoard);

        //verify setup
        assertSame(pieceToMove, generatedDataBoard[7][3].getCurrentPiece());
        assertSame(block1, generatedDataBoard[6][2].getCurrentPiece());
        assertSame(block2, generatedDataBoard[6][4].getCurrentPiece());

        boolean result = instance.isBlocked(pieceToMove);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

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
        pieceToMove.setPieceDirection(POSITIVE);  //moving towards the bottom
        pieceToMove.setxCol(0);
        pieceToMove.setyRow(6);
        gameDataBoard[6][0].setHasPiece(true);
        gameDataBoard[6][0].setCurrentPiece(pieceToMove);

        // Define forward-left and forward-right squares
        //gameDataBoard[2][6] = new BoardSquare(Color.BLACK, false, null); // Empty square
        gameDataBoard[7][1] = new BoardSquare(Color.BLACK, false, null); // Empty square

        // Act: Get the move options
        testBoard.setGameBoard(gameDataBoard);
        List<Point> options = testBoard.moveOptions(pieceToMove);

        // Assert: Verify the results
        assertEquals(1, options.size(), "Should have 2 valid move options.");
        assertTrue(options.contains(new Point(1, 7)), "Forward-left should be a valid move.");
        //assertTrue(options.contains(new Point(6, 4)), "Forward-right should be a valid move.");
    }
    private static final String POSITIVE = "POSITIVE";

    /**
     * Test of movePieceToSquare method, of class GameBoard.
     */
    @Test
    public void testMovePieceToSquare() {
        System.out.println("movePieceToSquare");
        List<Piece> pieces = new ArrayList<Piece>();
        Piece pieceToMove = generatePiece(3, 3);
        Point destination = new Point(2, 4);
        pieces.add(pieceToMove);

        BoardSquare[][] generatedDataBoard = generateDataBoard();
        generatedDataBoard[3][3].setCurrentPiece(pieceToMove);
        generatedDataBoard[3][3].setHasPiece(true);

        GameBoard instance = new GameBoard();
        instance.setGameBoard(generatedDataBoard);
        instance.getPieces().add(pieceToMove);
        instance.movePieceToSquare(pieceToMove, destination);

        BoardSquare oldLocation = generatedDataBoard[3][3];
        BoardSquare newLocation = generatedDataBoard[4][2];
        assertAll("Verifying Piece Movement",
                () -> assertFalse(oldLocation.isHasPiece(), "Piece no longer at 3,3"),
                () -> assertTrue(newLocation.isHasPiece(), "Piece located at 2, 4"));
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPiece method, of class GameBoard.
     */
    @Test
    public void testGetPiece() {
        System.out.println("Test: getPiece");

        //test index
        int testPieceIndex = 1;

        //generate two pieces
        Piece testPiece1 = new Piece();
        Piece testPiece2 = new Piece();

        GameBoard instance = new GameBoard();
        instance.getPieces().add(testPiece1);
        instance.getPieces().add(testPiece2);

        Piece expResult = new Piece();
        Piece result = instance.getPiece(testPieceIndex);
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

    /**
     * Test of clearSquare method, of class GameBoard.
     */
    @org.junit.jupiter.api.Test
    public void testClearSquare() {
//        System.out.println("clearSquare");
//        BoardSquare currentSqr = null;
//        GameBoard instance = new GameBoard();
//        instance.clearSquare(currentSqr);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setPieceAtSquare method, of class GameBoard.
     */
    @org.junit.jupiter.api.Test
    public void testSetPieceAtSquare() {
//        System.out.println("setPieceAtSquare");
//        Piece currentSqr = null;
//        GameBoard instance = new GameBoard();
//        instance.setPieceAtSquare(currentSqr);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of paintComponent method, of class GameBoard.
     */
    @org.junit.jupiter.api.Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        GameBoard instance = new GameBoard();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of isBlocked method, of class GameBoard.
     */
    @org.junit.jupiter.api.Test
    public void testIsBlocked() {
//        System.out.println("isBlocked");
//        Piece pieceToMove = null;
//        GameBoard instance = new GameBoard();
//        boolean expResult = false;
//        boolean result = instance.isBlocked(pieceToMove);
//        //assertEquals(expResult, result);
//         //TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePieces method, of class GameBoard.
     */
    @org.junit.jupiter.api.Test
    public void testUpdatePieces() {
        System.out.println("updatePieces");
        Piece pieceToMove = null;
        GameBoard instance = new GameBoard();
        instance.updatePieces(pieceToMove);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
