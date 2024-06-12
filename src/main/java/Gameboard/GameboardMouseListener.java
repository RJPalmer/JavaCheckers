/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseMotionListener;


/**
 *
 * @author robertpalmer
 */
public class GameboardMouseListener implements MouseListener, MouseInputListener, MouseMotionListener {

    private GameBoard board;
    private Piece gamePiece;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        int squareX = 0;
        int squareY = 0;
        int mouseX = 0;
        int mouseY = 0;
        
        MouseEvent eMouseEvent = e;

        mouseX = e.getXOnScreen();
        mouseY = e.getYOnScreen();
        
        System.out.printf("Mousex: %d, MouseY: %d",mouseX, mouseY);
        
        
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

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
          int squareX = 0;
        int squareY = 0;

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

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

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
    
}
