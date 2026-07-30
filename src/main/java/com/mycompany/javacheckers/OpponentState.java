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
import Gameboard.BoardContainer;

public class OpponentState implements State {

    private ComputerPlayer playerLogic;

    public OpponentState(ComputerPlayer opponent, GameBoard gameboard) {
        this.playerLogic = opponent;

    }

    public OpponentState(ComputerPlayer opponent, BoardContainer boardContainer) {
        this.playerLogic = opponent;

    }
    private BoardContainer boardContainer;

    /**
     * Get the value of boardContainer
     *
     * @return the value of boardContainer
     */
    public BoardContainer getBoardContainer() {
        return boardContainer;
    }

    /**
     * Set the value of boardContainer
     *
     * @param boardContainer new value of boardContainer
     */
    public void setBoardContainer(BoardContainer boardContainer) {
        this.boardContainer = boardContainer;
    }

    private GameBoard gameboard;

    /**
     * Get the value of gameboard
     *
     * @return the value of gameboard
     */
    public GameBoard getGameboard() {
        return gameboard;
    }

    /**
     * Set the value of gameboard
     *
     * @param gameboard new value of gameboard
     */
    public void setGameboard(GameBoard gameboard) {
        this.gameboard = gameboard;
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
        Game checkersGame = gs.getCheckersGame();
        switch (command) {
            case "START":
                if (!checkersGame.isGameOver()) {
                    setBoardContainer(checkersGame.getBoardContainer());
                    playerLogic.makeMove(getBoardContainer().getGameBoard());
                    if (playerLogic.isMoveMade()) {
                        playerLogic.setMoveMade(false);
                        gs.setCurrentState(new PlayerState(checkersGame));
                        gs.processState(gs, "YOUR_TURN");
                    }

                }
                break;

            case "Paused":
                gs.setCurrentState(new PausedState());
                gs.processState(gs, "Paused");
                break;

            case "YOUR_TURN":
                boardContainer = checkersGame.getBoardContainer();
                playerLogic.makeMove(boardContainer.getGameBoard());
                if (playerLogic.isMoveMade()) {
                    playerLogic.setMoveMade(false);
                    gs.setCurrentState(new PlayerState(checkersGame));
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

    public int getCapturedPieceCount() {
        //       throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return 0;
    }

}
