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
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    public void setCurrentPlayer(Player currentPlayer) {
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
    private String userPieceColor;

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

//        MouseEvent eMouseEvent = e;
//
//        //Getting current mouse screen coordinates
//        mouseX = eMouseEvent.getX();
//        mouseY = eMouseEvent.getY();
//
//        //translate mouse screen coordinates into rows/colum
//        translateToGrid(mouseX, mouseY);
//
//        //check the board to see if there's a piece there
//        gamePiece = board.checkForGamePiece(squareX, squareY);
//
//        selectPiece(gamePiece);
//        var object = board.getPieces();
//
//        board.repaint();
//        System.out.printf("Mousex: %d, MouseY: %d\n SquareX: %d, SquareY: %d\n", mouseX, mouseY, squareX, squareY);
    }

    /*
     *
     */
    private void selectPiece(Gameboard.Piece gamePiece) {
        if (gamePiece != null) {
            if (gamePiece.isSelected) {
                //gamePiece.setPieceColor(Color.yellow);
                gamePiece.isSelected = !gamePiece.isSelected;
//                board.repaint();
            } else {
                //gamePiece.setPieceColor(Color.green);
                if (checkersGame.getUserPlayer().checkPiece(gamePiece)) {
                    gamePiece.isSelected = !gamePiece.isSelected;
                }
//                board.repaint();
            }

        }
//            gamePiece.isSelected = !gamePiece.isSelected;
    }

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

//        MouseEvent eMouseEvent = e;
//        moveCopy = new Piece();
//
//        //Getting current mouse screen coordinates
//        mouseX = eMouseEvent.getX();
//        mouseY = eMouseEvent.getY();
//
//        //translate mouse screen coordinates into rows/colum
//        translateToGrid(mouseX, mouseY);
//
//        //check the board to see if there's a piece there
//        gamePiece = board.checkForGamePiece(squareX, squareY);
//
//        if (gamePiece != null) {
//            prepMoveCopy();
//            board.highlightPossibleJumps(gamePiece);
//            //gamePiece.isSelected = !gamePiece.isSelected; //gamePiece.setPieceColor(Color.yellow);
//
////            if (ArrayUtils.isEmpty(board.checkForMoves(gamePiece))) {
////
////            }
//            //board.repaint();
//            //gamePiece.setPieceColor(Color.green);
//            //board.repaint();
//        }

          MouseEvent eMouseEvent = e;

        //Getting current mouse screen coordinates
        mouseX = eMouseEvent.getX();
        mouseY = eMouseEvent.getY();

        //translate mouse screen coordinates into rows/colum
        translateToGrid(mouseX, mouseY);

        //check the board to see if there's a piece there
        gamePiece = board.checkForGamePiece(squareX, squareY);

        selectPiece(gamePiece);
        var object = board.getPieces();

        board.repaint();
        System.out.printf("Mousex: %d, MouseY: %d\n SquareX: %d, SquareY: %d\n", mouseX, mouseY, squareX, squareY);
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
                if (gamePiece.isHasMoved()) {
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
