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

    private GameBoard board;
    private Game checkersGame;
    private Piece gamePiece;
    private int mouseX = 0;
    private int mouseY = 0;
    private Piece moveCopy;
    private int squareX = 0;
    private int squareY = 0;

    public GameboardMouseListener(GameBoard aThis, Game aThis1) {
        this.checkersGame = aThis1;
        this.board = aThis;
        setCurrentPlayer(aThis1.getUserPlayer());
    }

    private Boolean checkOwnership(Piece gamePiece1) {
        //gamePiece.setPieceColor(Color.green);
        if (checkersGame.getUserPlayer().checkPiece(gamePiece1)) {
//            gamePiece1.isSelected = !gamePiece1.isSelected; 
           return true;
        } else {
            //gamePiece1 = null;
            return false;
        }
//                board.repaint();
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    private void setCurrentPlayer(Player currentPlayer) {
    }

    @Deprecated
    private void processMouseDragged(MouseEvent e) {
        checkersGame.processMouseDragged(e, this);
    }

    /**
     *
     * @param e the value of e
     *
     * @deprecated Moved to
     * {@link com.mycompany.javacheckers.Game#processMousePressed}
     */
    @Deprecated
    private void processMousePressed(MouseEvent e) {
        checkersGame.processMousePressed(e, this);
    }

    /**
     *
     * @param e the value of e
     *
     * @deprecated Moved to {@link Gameboard.BoardSquare#processMouseReleased}
     */
    @Deprecated
    private void processMouseReleased(MouseEvent e) {
        checkersGame.processMouseReleased(e, this);
    }

    /**
     * @return the board
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(GameBoard board) {
        this.board = board;
    }

    /**
     * @param checkersGame the checkersGame to set
     */
    public void setCheckersGame(Game checkersGame) {
        this.checkersGame = checkersGame;
    }

    /**
     * @return the gamePiece
     */
    public Piece getGamePiece() {
        return gamePiece;
    }

    /**
     * @param gamePiece the gamePiece to set
     */
    public void setGamePiece(Piece gamePiece) {
        this.gamePiece = gamePiece;
    }

    /**
     * @return the mouseX
     */
    public int getMouseX() {
        return mouseX;
    }

    /**
     * @param mouseX the mouseX to set
     */
    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    /**
     * @return the mouseY
     */
    public int getMouseY() {
        return mouseY;
    }

    /**
     * @param mouseY the mouseY to set
     */
    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    /**
     * @return the moveCopy
     */
    public Piece getMoveCopy() {
        return moveCopy;
    }

    /**
     * @param moveCopy the moveCopy to set
     */
    public void setMoveCopy(Piece moveCopy) {
        this.moveCopy = moveCopy;
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

    /**
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Processes the event of dragging the mouse.
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {

        processMouseDragged(e);
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
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {

        processMousePressed(e);

        getBoard().repaint();
        System.out.printf("Mousex: %d, MouseY: %d\n SquareX: %d, SquareY: %d\n", getMouseX(), getMouseY(), squareX, squareY);
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        processMouseReleased(e);
    }

    /*
     * Sets the attribute values of the moveCopy property to the attribute
     * values of the selected game piece
     */
    public void prepMoveCopy() {
        setMoveCopy(new Piece());
        getMoveCopy().setxPos(getGamePiece().getxPos());
        getMoveCopy().setyPos(getGamePiece().getyPos());
        getMoveCopy().setxCol(getGamePiece().getxCol());
        getMoveCopy().setyRow(getGamePiece().getyRow());
    }

    /*
     * @param gamePiece the piece to be selected
     *
     */
    public void selectPiece() {
        if (gamePiece != null && checkOwnership(gamePiece)) {
            gamePiece.isSelected = !gamePiece.isSelected;
        }
        else{
            throw new NullPointerException("The Game Piece has not been set or there was an issue checking ownership.");
        }
        getBoard().repaint();
    }

    /**
     *
     * @param mouseX
     * @param mouseY
     */
    public void translateToGrid(int mouseX, int mouseY) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        setSquareY((mouseX / getBoard().getSquareWidth()));
        setSquareX((mouseY / getBoard().getSquareWidth()));

    }

}
