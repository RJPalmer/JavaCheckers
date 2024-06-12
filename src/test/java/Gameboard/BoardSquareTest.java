/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Gameboard;

import java.awt.Color;
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
public class BoardSquareTest {
    
    public BoardSquareTest() {
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
     * Test of getCurrentPiece method, of class BoardSquare.
     */
    @Test
    public void testGetCurrentPiece() {
        System.out.println("getCurrentPiece");
        BoardSquare instance = new BoardSquare(null, false, new Piece());
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
        BoardSquare instance = new BoardSquare(null, false, null);
        instance.setCurrentPiece(currentPiece);
        assertNotNull(instance.getCurrentPiece());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isHasPiece method, of class BoardSquare.
     */
    @Test
    public void testIsHasPiece() {
        System.out.println("isHasPiece");
        BoardSquare instance = new BoardSquare(null, false, null);
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
        boolean hasPiece = false;
        BoardSquare instance = new BoardSquare(null, true, null);
        instance.setHasPiece(hasPiece);
        assertEquals(hasPiece, instance.isHasPiece());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class BoardSquare.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        BoardSquare instance = new BoardSquare(Color.red, false, null);
        Color expResult = Color.red;
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
        Color color = Color.red;
        BoardSquare instance = new BoardSquare(null, false, null);
        instance.setColor(color);
        assertEquals(color, instance.getColor());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
