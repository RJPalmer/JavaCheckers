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
 *
 * @author robertpalmer
 */
public class GameboardMouseListener implements MouseListener, MouseInputListener, MouseMotionListener {

    public GameboardMouseListener(GameBoard aThis, Game aThis1) {
        this.checkersGame = aThis1;
        this.board = aThis;
        setCurrentPlayer(aThis1.getUserPlayer());
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    private void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

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

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /*
     *
     */
    private Piece selectPiece(Gameboard.Piece gamePiece) {
        if (gamePiece != null) {
            if (gamePiece.isSelected) {
                //gamePiece.setPieceColor(Color.yellow);
                gamePiece.isSelected = !gamePiece.isSelected;
//                board.repaint();
                return gamePiece;
            } 
            else {
                if (checkOwnership(gamePiece)) {
                   return gamePiece;
                }
                else{
                    return null;
                }
            }

        } 
        else {
            return gamePiece;
        }
    }

    private Boolean checkOwnership(Piece gamePiece1) {
        //gamePiece.setPieceColor(Color.green);
        if (checkersGame.getUserPlayer().checkPiece(gamePiece1)) {
            gamePiece1.isSelected = !gamePiece1.isSelected;
            return true;
        } else {
            gamePiece1 = null;
            return false;
        }
//                board.repaint();
    }

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

        MouseEvent eMouseEvent = e;

        //Getting current mouse screen coordinates
        mouseX = eMouseEvent.getX();
        mouseY = eMouseEvent.getY();

        //translate mouse screen coordinates into rows/colum
        translateToGrid(mouseX, mouseY);

        //check the board to see if there's a piece there
        gamePiece = board.checkForGamePiece(squareX, squareY);

        gamePiece = selectPiece(gamePiece);
//        var object = board.getPieces();

        board.repaint();
        System.out.printf("Mousex: %d, MouseY: %d\n SquareX: %d, SquareY: %d\n", mouseX, mouseY, squareX, squareY);
    }

    private void prepMoveCopy() {
        moveCopy = new Piece();
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
                BoardSquare currentSqre = board.getBoardSquare(squareX, squareY);
                if (currentSqre.getColor() == Color.BLACK) {
                    board.movePiece(gamePiece, moveCopy, squareX, squareY);
                    moveCopy = null;
                    gamePiece.setHasMoved(false);
                    currentPlayer.setMoveComplete();
                } else {
                    board.resetPiece(gamePiece, moveCopy);
                    moveCopy = null;
                    gamePiece.setHasMoved(false);
                }
            } else {
                if (gamePiece.IsMoveable()) {
                    board.resetPiece(gamePiece, moveCopy);
                    moveCopy = null;
                    gamePiece.setHasMoved(false);
                }
            }
            board.repaint();

        }
//          int squareX = 0;
//        int squareY = 0;

        // update the square width
        //updateSquare();
        /*
         * //when the user releases the mouse //we want the piece to be drawn
         * in the square the mouse is over //the square the mouse is over
         * squareX = e.getX() / squareWidth; squareY = e.getY() / squareWidth;
         * piece1.setxPos((squareX * squareWidth)); piece1.setyPos(squareY *
         * squareWidth);
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
     * Processes the event of dragging the mouse.
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {

        //make sure there's a selected piece
        MouseEvent eMouseEvent = e;

        if (gamePiece != null && gamePiece.isSelected) {

            //get current mouse x & y
            int newMouseX = e.getX();
            int newMouseY = e.getY();
            int pieceCurrentX = gamePiece.getxPos();
            int pieceCurrentY = gamePiece.getyPos();
            int changeY = 0, changeX = 0;
            if (mouseX != 0 && mouseY != 0) {

                changeX = newMouseX - mouseX;

                changeY = newMouseY - mouseY;
            }

            mouseX = newMouseX;
            mouseY = newMouseY;
            //translate mouse screen coordinates into rows/colum
            translateToGrid(newMouseX, newMouseY);
            //if(newMouseX)
            //update the piece x/y to match the mouse x/y
            gamePiece.setxPos(pieceCurrentX + changeX);
            gamePiece.setyPos(pieceCurrentY + changeY);
            gamePiece.setHasMoved(true);

            prepMoveCopy();
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
        setSquareY((mouseX / board.getSquareWidth()));
        setSquareX((mouseY / board.getSquareWidth()));

    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @param checkersGame the checkersGame to set
     */
    public void setCheckersGame(Game checkersGame) {
        this.checkersGame = checkersGame;
    }

}
