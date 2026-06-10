/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.Player;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.savedPieceX = 0; 
        this.savedPieceY = 0;
    }

    private Boolean checkOwnership(Piece gamePiece1) {
        //gamePiece.setPieceColor(Color.green);
        return checkersGame.getUserPlayer().checkPiece(gamePiece1);//            gamePiece1.isSelected = !gamePiece1.isSelected;
        //gamePiece1 = null;
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
        System.out.printf("Mouse Pressed\nMousex: %d, MouseY: %d\n SquareX: %d, SquareY: %d\n", getMouseX(), getMouseY(), squareX, squareY);
    }

    /**
     *
     * The Mouse has been released. Process
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.printf("Mouse Released\nMousex: %d, MouseY: %d\n SquareX: %d, SquareY: %d\n", getMouseX(), getMouseY(), squareX, squareY);
        processMouseReleased(e);
//        this.checkersGame.processMouseReleased(e, this);
    }

    /*
     * Sets the attribute values of the moveCopy property to the attribute
     * values of the selected game piece
     */
    public void prepMoveCopy() {
        Piece copiedPiece = new Piece();
        try {
            copiedPiece = (Piece) this.getGamePiece().clone();
//        Piece currentPiece = getGamePiece();
//
//        moveCopy.setxPos(currentPiece.getxPos());
//        moveCopy.setyPos(currentPiece.getyPos());
//        moveCopy.setxCol(currentPiece.getxCol());
//        moveCopy.setyRow(currentPiece.getyRow());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(GameboardMouseListener.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setMoveCopy(copiedPiece);
    }

    public void savePieceState() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        setSavedPieceX(this.getGamePiece().getxPos());
        setSavedPieceY(this.getGamePiece().getyPos());
                
    }
    private int savedPieceY;

    /**
     * Get the value of savedPieceY
     *
     * @return the value of savedPieceY
     */
    public int getSavedPieceY() {
        return savedPieceY;
    }

    /**
     * Set the value of savedPieceY
     *
     * @param savedPieceY new value of savedPieceY
     */
    public void setSavedPieceY(int savedPieceY) {
        this.savedPieceY = savedPieceY;
    }

    private int savedPieceX;

    /**
     * Get the value of savedPieceX
     *
     * @return the value of savedPieceX
     */
    public int getSavedPieceX() {
        return savedPieceX;
    }

    /**
     * Set the value of savedPieceX
     *
     * @param savedPieceX new value of savedPieceX
     */
    public void setSavedPieceX(int savedPieceX) {
        this.savedPieceX = savedPieceX;
    }


    /*
     * @param gamePiece the piece to be selected
     *
     */
    public void selectPiece() {

        Boolean hasOwnership = checkOwnership(this.gamePiece);
        if (this.gamePiece != null && hasOwnership) {
            this.gamePiece.isSelected = !this.gamePiece.isSelected;
        } else {
            System.out.println("Ownership = " + hasOwnership);
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
        setSquareX((mouseX / getBoard().getSquareWidth()));
        setSquareY((mouseY / getBoard().getSquareWidth()));
        System.out.printf("Translated Co-ordinates (x,y): %d, %d\n", getSquareX(), getSquareY());
    }

}
