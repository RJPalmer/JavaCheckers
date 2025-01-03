/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

import Gameboard.GameBoard;
import Gameboard.GameboardMouseListener;
import Gameboard.Piece;
import java.awt.event.MouseEvent;

/**
 * A State that represents the player's turn
 *
 * @author robertpalmer
 */
public class PlayerState implements State {

    private boolean hasMoved;

    /**
     *
     */
    public PlayerState() {
    }

    /**
     *
     * @param gs
     */
    @Override
    public void changeState(com.mycompany.javacheckers.GameStateContext gs) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    /**
     *
     * @return
     */
    @Override
    public String getState() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return "Player State";
    }

    /**
     *
     * @param gameState
     * @param gameboardMouseListener
     * @param e
     * @param pressed
     */
    @Override
    public void handleMouseRequest(GameStateContext gameState, GameboardMouseListener gameboardMouseListener, MouseEvent e, String pressed) {
        switch (pressed) {
            case "Pressed":
                MouseEvent eMouseEvent = e;

                int eMouseEventX = eMouseEvent.getX();
                //Getting current mouse screen coordinates
                gameboardMouseListener.setMouseX(eMouseEventX);
                int eMouseEventY = eMouseEvent.getY();
                gameboardMouseListener.setMouseY(eMouseEventY);
                //translate mouse screen coordinates into rows/colum
                gameboardMouseListener.translateToGrid(gameboardMouseListener.getMouseX(), gameboardMouseListener.getMouseY());
                int squareX = gameboardMouseListener.getSquareX();
                int squareY = gameboardMouseListener.getSquareY();
                GameBoard board = gameboardMouseListener.getBoard();
                //check the board to see if there's a piece there
                gameboardMouseListener.setGamePiece(board.checkForGamePiece(squareX, squareY));
                Piece gamePiece = gameboardMouseListener.getGamePiece();
                gameboardMouseListener.setGamePiece(gameboardMouseListener.selectPiece(gamePiece));
                //        var object = board.getPieces(); new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

                break;

            case "Dragged":
                break;
                
            case "Released":
                Player userPlayer = gameState.getCheckersGame().getUserPlayer();
                
                if (userPlayer.isTurnComplete) {
                    //userPlayer.isTurnComplete = true;
                    OpponentState opponentPlayer = new OpponentState(gameState.getCheckersGame().getOpponentPlayer());
                    
                    userPlayer.setMoveComplete();
                    gameState.setCurrentState(opponentPlayer);
                    gameState.processState(gameState, "YOUR_TURN");
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     *
     * @param gs
     * @param command
     */
    @Override
    public void handleRequest(com.mycompany.javacheckers.GameStateContext gs, java.lang.String command) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("It''s the player's turn");
//        if(START.equals(command)){
//            gs.processState(gs, "Paused");
//            
//        }
        if ("Paused".equals(command)) {
            gs.setCurrentState(new PausedState());
            gs.processState(gs, "Paused");
        }
        if ("YOUR_TURN".equals(command)) {
            hasMoved = false;
        }
    }
    private static final String START = "START";

    /**
     * Get the value of hasMoved
     *
     * @return the value of hasMoved
     */
    public boolean isHasMoved() {
        return hasMoved;
    }

    /**
     * Set the value of hasMoved
     *
     * @param hasMoved new value of hasMoved
     */
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    /**
     *
     * @param gameState
     */
    @Override
    public void switchToPause(GameStateContext gameState) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

}
