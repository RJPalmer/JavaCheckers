/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Piece.java - Represents a piece to be placed on the game board
 *
 * @author Palmer
 */
public class Piece {

    /**
     * @return the xCol
     */
    public int getxCol() {
        return xCol;
    }

    /**
     * @param xCol the xCol to set
     */
    public void setxCol(int xCol) {
        this.xCol = xCol;
    }

    /**
     * @return the yRow
     */
    public int getyRow() {
        return yRow;
    }

    /**
     * @param yRow the yRow to set
     */
    public void setyRow(int yRow) {
        this.yRow = yRow;
    }

    private int xPos;
    private int yPos;
    private int xCol;
    private int yRow;
    private int width;
    private int height;
    private int startAngle;
    private int endAngle;
    private Color pieceColor;
    public boolean isSelected;
    private int foreward;
    private int maxRangeX = 2;
    private int minRangeX = 1;
    private int maxRangeY = 2;
    private int minRangeY = 1;

    /**
     *
     */
    public Piece() {
        this.xPos = 0;
        this.yPos = 0;
        this.xCol = 0;
        this.yRow = 0;
        this.width = 0;
        this.height = 0;
        this.startAngle = 0;
        this.endAngle = 0;
        this.pieceColor = new Color(0, 0, 0);
        this.isSelected = false;
        this.foreward = 1;
    }

    /**
     *
     * @param xPos
     * @param yPos
     * @param width
     * @param height
     * @param startAngle
     * @param endAngle
     */
    public Piece(int xPos, int yPos, int xCol, int yRow, int width, int height, int startAngle, int endAngle) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xCol = xCol;
        this.yRow = yRow;
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.pieceColor = Color.WHITE;
        this.isSelected = false;
        this.foreward = 1;
    }

    /**
     * getEndAngle - returns the end angle of the piece arc
     *
     * @return endAngle
     */
    public int getEndAngle() {
        return endAngle;
    }

    /**
     * setEndAngle - sets the end angle of the piece arc
     *
     * @param endAngle
     */
    public void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }

    /**
     * getHeight - returns the height of the piece object
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * setHeight - sets the height of the piece object
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * getStartAngle - returns the starting angle for the piece arc
     *
     * @return
     */
    public int getStartAngle() {
        return startAngle;
    }

    /**
     * setStartAngle - sets the starting angle for the piece arc
     *
     * @param startAngle
     */
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    /**
     * getWidth - returns the piece width
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * setWidth - sets the piece width
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * getxPos - returns the x position of the piece
     *
     * @return
     */
    public int getxPos() {
        return xPos;
    }

    /**
     * setxPos - sets the x position of the piece
     *
     * @param xPos
     */
    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * getyPos - returns the y position of the piece
     *
     * @return
     */
    public int getyPos() {
        return yPos;
    }

    /**
     * setyPos - sets the y position for the piece
     *
     * @param yPos
     */
    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * drawPiece - renders the piece using the given graphics component
     *
     * @param g2
     */
    public void drawPiece(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (isSelected) {
            g2.setColor(Color.YELLOW);
        } else {
            g2.setColor(pieceColor);
        }
        g2.fillArc(xPos, yPos, width, height, startAngle, endAngle);
    }

    /**
     * movePiece - moves the piece to the given position.
     *
     * @param newX
     * @param newY
     */
    public void movePiece(int newSqrX, int newSqrY) {

        if (withinRange(newSqrX, newSqrY)) {
            this.setxPos(newSqrX * width);
            this.setyPos(newSqrY * width);
        }

    }

    /**
     * getPieceColor - returns the color of the piece
     *
     * @return the pieceColor
     */
    public Color getPieceColor() {
        return pieceColor;
    }

    /**
     * setPieceColor - sets the color of the piece
     *
     * @param pieceColor the pieceColor to set
     */
    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    /**
     * withinRange - determines if the selected square is within the movement
     * range of the piece
     *
     * @param newSqrX
     * @param newSqrY
     * @return
     */
    private boolean withinRange(int newSqrX, int newSqrY) {
        int currentSqrX = xPos / width;
        int currentSqrY = yPos / width;
        if ((newSqrY < currentSqrY) && foreward == 1) {
            return false;
        }//end if
        else if ((newSqrY < currentSqrY) && foreward != 1) {
            if ((Math.abs(newSqrX - currentSqrX) == 1)
                    && Math.abs(newSqrY - currentSqrY) == 1) {
                return true;
            }//end if
        } else if ((newSqrY > currentSqrY) && foreward == 1) {
            if ((Math.abs(newSqrX - currentSqrX) == 1)
                    && Math.abs(newSqrY - currentSqrY) == 1) {
                return true;
            }//end if
        } else if ((newSqrY > currentSqrY) && foreward != 1) {
            return false;
        }//end else-if
        return false;
    }
}
