/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gameboard;

import java.awt.*;
/**
 *
 * @author Palmer
 */
public class Square {
    private int boardRow;
    private int boardColumn;
    private int width;
    private int height;

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }
    private Color squareColor;

    /**
     *
     */
    public Square() {
        boardRow = 0;
        boardColumn = 0;
        height = 100;
        width = 100;
        squareColor = Color.WHITE;
    }

    /**
     *
     * @param boardRow
     * @param boardColumn
     * @param width
     * @param height
     * @param squareColor
     */
    public Square(int boardRow, int boardColumn, int width, int height, Color squareColor) {
        this.boardRow = boardRow;
        this.boardColumn = boardColumn;
        this.squareColor = squareColor;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @return
     */
    public int getBoardColumn() {
        return boardColumn;
    }

    /**
     *
     * @param boardColumn
     */
    public void setBoardColumn(int boardColumn) {
        this.boardColumn = boardColumn;
    }

    /**
     *
     * @return
     */
    public int getBoardRow() {
        return boardRow;
    }

    /**
     *
     * @param boardRow
     */
    public void setBoardRow(int boardRow) {
        this.boardRow = boardRow;
    }

    /**
     *
     * @return
     */
    public Color getSquareColor() {
        return squareColor;
    }

    /**
     *
     * @param squareColor
     */
    public void setSquareColor(Color squareColor) {
        this.squareColor = squareColor;
    }
    
    
}
