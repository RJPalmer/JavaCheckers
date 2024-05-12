/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    private Color squareColor;

    public Square() {
        boardRow = 0;
        boardColumn = 0;
        height = 100;
        width = 100;
        squareColor = Color.WHITE;
    }

    public Square(int boardRow, int boardColumn, int width, int height, Color squareColor) {
        this.boardRow = boardRow;
        this.boardColumn = boardColumn;
        this.squareColor = squareColor;
        this.width = width;
        this.height = height;
    }

    public int getBoardColumn() {
        return boardColumn;
    }

    public void setBoardColumn(int boardColumn) {
        this.boardColumn = boardColumn;
    }

    public int getBoardRow() {
        return boardRow;
    }

    public void setBoardRow(int boardRow) {
        this.boardRow = boardRow;
    }

    public Color getSquareColor() {
        return squareColor;
    }

    public void setSquareColor(Color squareColor) {
        this.squareColor = squareColor;
    }
    
    
}
