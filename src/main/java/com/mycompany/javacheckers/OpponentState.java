/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

import Gameboard.GameBoard;
import Gameboard.GameboardMouseListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author robertpalmer
 */
public class OpponentState implements State {

    private ComputerPlayer playerLogic;

    OpponentState(ComputerPlayer opponent) {
        this.playerLogic = opponent;
    }

    /**
     * Get the value of playerLogic
     *
     * @return the value of playerLogic
     */
    public ComputerPlayer getPlayerLogic() {
        return playerLogic;
    }

    /**
     * Set the value of playerLogic
     *
     * @param playerLogic new value of playerLogic
     */
    public void setPlayerLogic(ComputerPlayer playerLogic) {
        this.playerLogic = playerLogic;
    }

    /**
     *
     */
    public OpponentState() {

    }

    /**
     *
     * @return
     */
    @Override
    public String getState() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return "Opponent Turn";
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
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    /**
     *
     * @param gs
     * @param command
     */
    @Override
    public void handleRequest(com.mycompany.javacheckers.GameStateContext gs, java.lang.String command) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("It's the opponent's turn");
        switch (command) {
            case "START":
                if (!gs.getCheckersGame().isGameOver()) {
                    GameBoard gameboard = gs.getCheckersGame().gameboard;
                    playerLogic.makeMove(gameboard);
                    if (playerLogic.isMoveMade()) {
                        gs.setCurrentState(new PlayerState());
                        gs.processState(gs, "YOUR_TURN");
                    }

                }
                break;
                
            case "Paused":
                gs.setCurrentState(new PausedState());
                gs.processState(gs, "Paused");
                break;

            case "YOUR_TURN":
                GameBoard gameboard = gs.getCheckersGame().gameboard;
                playerLogic.makeMove(gameboard);
                if (playerLogic.isMoveMade()) {
                    
                    gs.setCurrentState(new PlayerState());
                    gs.processState(gs, "YOUR_TURN");
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    /**
     *
     * @param gs
     */
    @Override
    public void changeState(com.mycompany.javacheckers.GameStateContext gs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param gameState
     */
    @Override
    public void switchToPause(GameStateContext gameState) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
