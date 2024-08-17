/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import java.awt.Color;

/**
 * Represents a square on the game board
 * @author robertpalmer
 */
public class BoardSquare {

    /**
     * The color of the square
     */
    private Color Color;

    /**
     * Whether or not there's a Piece on the square
     */
    private boolean hasPiece;

    /**
     * The Piece on the square
     */
    private Piece currentPiece;

    /**
     * Get the value of currentPiece
     *
     * @return the value of currentPiece
     */
    public Piece getCurrentPiece() {
        return currentPiece;
    }

    /**
     * Set the value of currentPiece
     *
     * @param currentPiece new value of currentPiece
     */
    public void setCurrentPiece(Piece currentPiece) {
        this.currentPiece = currentPiece;
    }

    /**
     * Constructor for board square
     * @param Color
     * @param hasPiece
     * @param currentPiece 
     */
    public BoardSquare(Color Color, boolean hasPiece, Piece currentPiece) {
        this.Color = Color;
        this.hasPiece = hasPiece;
        this.currentPiece = currentPiece;
    }

    /**
     * Get the value of hasPiece
     *
     * @return the value of hasPiece
     */
    public boolean isHasPiece() {
        return hasPiece;
    }

    /**
     * Set the value of hasPiece
     *
     * @param hasPiece new value of hasPiece
     */
    public void setHasPiece(boolean hasPiece) {
        this.hasPiece = hasPiece;
    }

    /**
     * Get the value of Color
     *
     * @return the value of Color
     */
    public Color getColor() {
        return this.Color;
    }

    /**
     * Set the value of Color
     *
     * @param color
     */
    public void setColor(Color color) {
        this.Color = color;
    }

}
