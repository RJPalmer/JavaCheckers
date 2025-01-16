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

    private static final String START = "START";

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
            case "Pressed" -> {
                MouseEvent eMouseEvent;
                eMouseEvent = e;

                int eMouseEventX = eMouseEvent.getX();
                int eMouseEventY = eMouseEvent.getY();
                int squareX;
                int squareY;

                gameboardMouseListener.setMouseX(eMouseEventX);
                gameboardMouseListener.setMouseY(eMouseEventY);

                //translate mouse screen coordinates into rows/colum
                gameboardMouseListener.translateToGrid(eMouseEventX, eMouseEventY);

                squareY = gameboardMouseListener.getSquareY();
                squareX = gameboardMouseListener.getSquareX();
                //Getting current mouse screen coordinates

                GameBoard board = gameboardMouseListener.getBoard();
                Piece checkForGamePiece = board.checkForGamePiece(squareX, squareY);
                //Piece gamePiece;
                //check the board to see if there's a piece there
                gameboardMouseListener.setGamePiece(checkForGamePiece);
                gameboardMouseListener.selectPiece();
                //        var object = board.getPieces(); new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }


            case "Dragged" -> {
//                gameboardMouseListener.getGamePiece();
            }

            case "Released" -> {
                Player userPlayer = gameState.getCheckersGame().getUserPlayer();

                if (userPlayer.isTurnComplete) {
                    //userPlayer.isTurnComplete = true;
                    OpponentState opponentPlayer = new OpponentState(gameState.getCheckersGame().getOpponentPlayer());

                    userPlayer.setMoveComplete();
                    gameState.setCurrentState(opponentPlayer);
                    gameState.processState(gameState, "YOUR_TURN");
                }
            }
            default ->
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
