/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package gameboard;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robertpalmer
 */
public class BoardSquareTest {
    
    public BoardSquareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentPiece method, of class BoardSquare.
     */
    @Test
    public void testGetCurrentPiece() {
        System.out.println("getCurrentPiece");
        BoardSquare instance = new BoardSquare(Color.black, false, new Piece());
        Piece expResult = null;
        Piece result = instance.getCurrentPiece();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentPiece method, of class BoardSquare.
     */
    @Test
    public void testSetCurrentPiece() {
        System.out.println("setCurrentPiece");
        Piece currentPiece = new Piece();
        BoardSquare instance = new BoardSquare(Color.black, false, null);
        instance.setCurrentPiece(currentPiece);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(currentPiece, instance.getCurrentPiece());
    }

    /**
     * Test of isHasPiece method, of class BoardSquare.
     */
    @Test
    public void testIsHasPiece() {
        System.out.println("isHasPiece");
        BoardSquare instance = new BoardSquare(Color.red, false, null);
        boolean expResult = false;
        boolean result = instance.isHasPiece();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setHasPiece method, of class BoardSquare.
     */
    @Test
    public void testSetHasPiece() {
        System.out.println("setHasPiece");
        boolean hasPiece = true;
        BoardSquare instance = new BoardSquare(Color.black, false, null);
        instance.setHasPiece(hasPiece);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(hasPiece, instance.isHasPiece());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class BoardSquare.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        BoardSquare instance = new BoardSquare(Color.black, false, null);
        Color expResult = Color.black;
        Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class BoardSquare.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        Color color = Color.blue;
        BoardSquare instance = new BoardSquare(Color.black, false, null);
        instance.setColor(color);
        assertEquals(color, instance.getColor());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
