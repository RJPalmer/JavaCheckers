/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.Player;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;
    
/**
 * Handles events involving the actions of the mouse on the Gameboard
 * @author robertpalmer
 */
public class GameboardMouseListener implements MouseListener, MouseInputListener, MouseMotionListener {

    /**
     * @return the squareX
     */
    public int getSquareX() {
        return squareX;
    }

    /**
     * @param squareX the squareX to set
     */
    public void setSquareX(int squareX) {
        this.squareX = squareX;
    }

    /**
     * @return the squareY
     */
    public int getSquareY() {
        return squareY;
    }

    /**
     * @param squareY the squareY to set
     */
    public void setSquareY(int squareY) {
        this.squareY = squareY;
    }

    private GameBoard board;
    private Game checkersGame;
    private Piece gamePiece;
    private Piece moveCopy;
    private int squareX = 0;
    private int squareY = 0;
    private int mouseX = 0;
    private int mouseY = 0;
    private Player currentPlayer;
    private String userPieceColor;

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        MouseEvent eMouseEvent = e;

        //Getting current mouse screen coordinates
        mouseX = eMouseEvent.getX();
        mouseY = eMouseEvent.getY();

        //translate mouse screen coordinates into rows/colum
        translateToGrid(mouseX, mouseY);

        //check the board to see if there's a piece there
        gamePiece = board.checkForGamePiece(squareX, squareY);

        if (gamePiece != null) {
            if (gamePiece.isSelected) {
                //gamePiece.setPieceColor(Color.yellow);
                gamePiece.isSelected = false;
                board.repaint();
            } else {
                //gamePiece.setPieceColor(Color.green);
                gamePiece.isSelected = true;
                board.repaint();
            }
        }

        System.out.printf("Mousex: %d, MouseY: %d\n SquareX: %d, SquareY: %d\n", mouseX, mouseY, squareX, squareY);

//        // update the square width
//        //updateSquare();
//
//        // we only want to move the piece if the piece has been selected
//        // if the mouse is on top of the piece, the piece should change color
//        // if the mouse is to the right of top left corner, but to the left of the
//        // top right corner
//        // if (eMouseEvent.getX() > piece1.getxPos()
//        // && eMouseEvent.getX() < (piece1.getxPos() + squareWidth)
//        // && eMouseEvent.getY() > piece1.getyPos()
//        // && eMouseEvent.getY() < (piece1.getyPos() + squareWidth)) {
//        for (int i = 0; i < pieces.length; i++) {
//            if (e.getX() > pieces[i].getxPos()
//                    && e.getX() < (pieces[i].getxPos() + getSquareWidth())
//                    && e.getY() > pieces[i].getyPos()
//                    && e.getY() < (pieces[i].getyPos() + getSquareWidth())) {
//
//                // if the piece has not been selected
//                if (!pieces[i].isSelected) {
//                    // set isSelected to true
//                    pieces[i].isSelected = true; // the square the mouse is over
//                    selectedPiece = i;
//                } // end if
//                else {
//                    pieces[i].isSelected = false;
//                } // end else
//
//            } // end if
//            else if (pieces[selectedPiece] != null) {
//                squareX = e.getX() / getSquareWidth();
//                squareY = e.getY() / getSquareWidth();
//
//                // move the piece coordinates to the appropriate square
//                pieces[selectedPiece].movePiece(squareX, squareY);
//
//            } // end if
//
//        } // end for
        // redraw the screen
        //repaint();
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        MouseEvent eMouseEvent = e;
        moveCopy = new Piece();

        //Getting current mouse screen coordinates
        mouseX = eMouseEvent.getX();
        mouseY = eMouseEvent.getY();

        //translate mouse screen coordinates into rows/colum
        translateToGrid(mouseX, mouseY);

        //check the board to see if there's a piece there
        gamePiece = board.checkForGamePiece(squareX, squareY);

        if (gamePiece != null) {
            prepMoveCopy();
            gamePiece.isSelected = !gamePiece.isSelected; //gamePiece.setPieceColor(Color.yellow);

//            if (ArrayUtils.isEmpty(board.checkForMoves(gamePiece))) {
//
//            }
            //board.repaint();
            //gamePiece.setPieceColor(Color.green);
            //board.repaint();
        }
    }

    private void prepMoveCopy() {
        moveCopy.setxPos(gamePiece.getxPos());
        moveCopy.setyPos(gamePiece.getyPos());
        moveCopy.setxCol(gamePiece.getxCol());
        moveCopy.setyRow(gamePiece.getyRow());
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int currentX;
        int currentY;
        Piece existPiece;
        if (gamePiece != null) {
            currentX = e.getX();
            currentY = e.getY();

            translateToGrid(currentX, currentY);

            existPiece = board.checkForGamePiece(squareX, squareY);

            if (Objects.isNull(existPiece)) {
                BoardSquare currentSqre = board.getBoardSquare(squareX - 1, squareY - 1);
                if (currentSqre.getColor() == Color.BLACK) {
                    board.movePiece(gamePiece, moveCopy, squareX - 1, squareY - 1);
                    moveCopy = null;
                    gamePiece.setHasMoved(false);
                    currentPlayer.setMoveComplete();
                } else {
                    board.resetPiece(gamePiece, moveCopy);
                    moveCopy = null;
                    gamePiece.setHasMoved(false);
                }
            } else {
                if (gamePiece.isHasMoved()) {
                    board.resetPiece(gamePiece, moveCopy);
                    moveCopy = null;
                    gamePiece.setHasMoved(false);
                } else {
                    existPiece.isSelected = !existPiece.isSelected;
                }
            }
            board.repaint();

        }
//          int squareX = 0;
//        int squareY = 0;

        // update the square width
        //updateSquare();
        /*
                        * //when the user releases the mouse
                        * //we want the piece to be drawn in the square the mouse is over
                        * //the square the mouse is over
                        * squareX = e.getX() / squareWidth;
                        * squareY = e.getY() / squareWidth;
                        * piece1.setxPos((squareX * squareWidth));
                        * piece1.setyPos(squareY * squareWidth);
         */
        //repaint();
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        //String selectPieceColor = gamePiece.getPieceColor().toString();
        //userPieceColor = board.getUserColor();
        //make sure there's a selected piece
        if (gamePiece != null && gamePiece.IsMoveable()) {
            
            //get current mouse x & y
            int newMouseX = e.getX();
            int newMouseY = e.getY();

            //if(newMouseX)
            //update the piece x/y to match the mouse x/y
            gamePiece.setxPos(newMouseX);
            gamePiece.setyPos(newMouseY);
            gamePiece.setHasMoved(true);

            board.repaint();

        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @param board the board to set
     */
    public void setBoard(GameBoard board) {
        this.board = board;
    }

    /**
     * 
     * @param mouseX
     * @param mouseY 
     */
    private void translateToGrid(int mouseX, int mouseY) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        setSquareY((mouseX / board.getSquareWidth()) + 1);
        setSquareX((mouseY / board.getSquareWidth()) + 1);

    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
