/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author Palmer
 */
public class GameBoard extends JPanel implements MouseListener, MouseMotionListener {

    private int rows;
    private int columns;
    private int squareWidth;
    // private Graphics panelG;
    private Square boardSquare1;
    private Square boardSquare2;
    private int selectedPiece;
    // private JPanel checkerBoard;
    private Piece[] pieces;

    /**
     * 
     */
    public GameBoard() {
        initComponents();
    }

    /**
     * 
     */
    private void initComponents() {
        // this.setBackground(Color.red);
        setSquareWidth(100);
        pieces = new Piece[14];

        // piece1 = new Piece();
        for (int i = 0; i < pieces.length; i++) {
            pieces[i] = new Piece(0, 0, squareWidth, squareWidth, 0, 360);
        }
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);

        updateSquare();
        drawBoard(g);
        // drawPieces(g);

        /*
         * g2.setColor(Color.DARK_GRAY);
         * piece1.movePiece(2*squareWidth, squareWidth);
         * piece1.drawPiece(g2);
         * //g2.fillArc(0, 0, 100, 100, 0, 360);
         * 
         */
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int squareX = 0;
        int squareY = 0;
        MouseEvent eMouseEvent = e;

        // update the square width
        updateSquare();

        // we only want to move the piece if the piece has been selected

        // if the mouse is on top of the piece, the piece should change color
        // if the mouse is to the right of top left corner, but to the left of the
        // top right corner
        // if (eMouseEvent.getX() > piece1.getxPos()
        // && eMouseEvent.getX() < (piece1.getxPos() + squareWidth)
        // && eMouseEvent.getY() > piece1.getyPos()
        // && eMouseEvent.getY() < (piece1.getyPos() + squareWidth)) {

        for (int i = 0; i < pieces.length; i++) {
            if (e.getX() > pieces[i].getxPos()
                    && e.getX() < (pieces[i].getxPos() + getSquareWidth())
                    && e.getY() > pieces[i].getyPos()
                    && e.getY() < (pieces[i].getyPos() + getSquareWidth())) {

                // if the piece has not been selected
                if (!pieces[i].isSelected) {
                    // set isSelected to true
                    pieces[i].isSelected = true; // the square the mouse is over
                    selectedPiece = i;
                } // end if
                else {
                    pieces[i].isSelected = false;
                } // end else

            } // end if
            else if (pieces[selectedPiece] != null) {
                squareX = e.getX() / getSquareWidth();
                squareY = e.getY() / getSquareWidth();

                // move the piece coordinates to the appropriate square
                pieces[selectedPiece].movePiece(squareX, squareY);

            } // end if

        } // end for

        // redraw the screen
        repaint();
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * @return the columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * @param columns the columns to set
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // user clicks on the piece
        // we want the piece to move with the mouse
        // set the piece coordinates to that of the mouse coordinates
        /*
         * updateSquare();
         * piece1.setxPos(e.getX()- (squareWidth / 2));
         * piece1.setyPos(e.getY()- (squareWidth / 2));
         * repaint();
         * 
         */
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int squareX = 0;
        int squareY = 0;

        // update the square width
        updateSquare();/*
                        * //when the user releases the mouse
                        * //we want the piece to be drawn in the square the mouse is over
                        * //the square the mouse is over
                        * squareX = e.getX() / squareWidth;
                        * squareY = e.getY() / squareWidth;
                        * piece1.setxPos((squareX * squareWidth));
                        * piece1.setyPos(squareY * squareWidth);
                        */
        repaint();

        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {/*
                                             * // throw new UnsupportedOperationException("Not supported yet.");
                                             * piece1.setxPos(e.getX()- (squareWidth / 2));
                                             * piece1.setyPos(e.getY()- (squareWidth / 2));
                                             */
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * updateSquare - updates the width of the squares on the board.
     */
    private void updateSquare() {
        setSquareWidth(this.getWidth() / 8);
    }

    /**
     * setPieces - takes a given set of pieces and sets the variable
     * 
     * @param pieces
     */
    public void setPieces(Piece[] pieces) {
        this.pieces = pieces;
    }

    /**
     * @param g
     */
    private void drawBoard(Graphics g) {
        boardSquare1 = new Square(0, 0, getSquareWidth(), getSquareWidth(), Color.BLUE);
        boardSquare2 = new Square(0, 0, getSquareWidth(), getSquareWidth(), Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        int swap = 1;
        for (int k = 0; k <= this.getHeight(); k += (getSquareWidth())) {
            if (swap % 2 == 1) {
                drawBoardRow(g2, k, false);
                swap++;
            } // end if
            else {
                drawBoardRow(g2, k, true);
                swap++;
            } // end else
            if (swap > 2) {
                swap = 1;
            }
        } // end for loop
    }


    /**
     * @param g2
     * @param k
     * @param swapColor
     */
    private void drawBoardRow(Graphics2D g2, int k, Boolean swapColor) {
        if (!swapColor) {
            for (int i = 0; i <= getSquareWidth() * 8; i += (2 * getSquareWidth())) {

                drawBoardSquare(g2, k, i, boardSquare1);

            }
            for (int j = getSquareWidth(); j <= getSquareWidth() * 8; j += (2 * getSquareWidth())) {
                drawBoardSquare(g2, k, j, boardSquare2);
            }
        } else {
            for (int i = 0; i <= getSquareWidth() * 8; i += (2 * getSquareWidth())) {

                drawBoardSquare(g2, k, i, boardSquare2);

            }
            for (int j = getSquareWidth(); j <= getSquareWidth() * 8; j += (2 * getSquareWidth())) {
                drawBoardSquare(g2, k, j, boardSquare1);
            }
        }
    }

    /**
     * @param g2
     * @param k
     * @param i
     * @param square
     */
    private void drawBoardSquare(Graphics2D g2, int k, int i, Square square) {
        g2.setColor(square.getSquareColor());
        g2.fillRect(i, k,
                square.getWidth(), square.getHeight());
    }

    /**
     * 
     * @param g
     */
    private void drawPieces(Graphics g) {
        int pieceX;
        int pieceY;
        int adjustX;
        int adjustY;

        for (int i = 0; i < pieces.length; i++) {
            pieceX = pieces[i].getxPos();
            pieceY = pieces[i].getyPos();

            adjustX = pieceX / this.getSquareWidth();
            adjustY = pieceY / this.getSquareWidth();
            pieces[i].setxPos(this.getSquareWidth() * adjustX);
            pieces[i].setyPos(this.getSquareWidth() * adjustY);
            pieces[i].setWidth(squareWidth);
            pieces[i].setHeight(squareWidth);
            pieces[i].drawPiece(g);
        }
    }

    /**
     * @return the squareWidth
     */
    public int getSquareWidth() {
        return squareWidth;
    }

    /**
     * @param squareWidth the squareWidth to set
     */
    public void setSquareWidth(int squareWidth) {
        this.squareWidth = squareWidth;
    }

    private void updatePiece(int xPos, int yPos) {

    }
}
