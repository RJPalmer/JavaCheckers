/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

import Gameboard.GameboardMouseListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author robertpalmer
 */
public class GameStateContext {

    /**
     * Empty Constructor
     */
    public GameStateContext() {
        this.currentState = new InitState();
        //this.checkersGame = new Game();
    }

    /**
     * Constructor
     *
     * @param currentState
     * @param checkersGame
     */
    public GameStateContext(State currentState, Game checkersGame) {
        this.currentState = new InitState();
        this.checkersGame = checkersGame;
    }

    private State currentState;
    private State prevState;

    /**
     * Get the value of prevState
     *
     * @return the value of prevState
     */
    public State getPrevState() {
        return prevState;
    }

    /**
     * Set the value of prevState
     *
     * @param prevState new value of prevState
     */
    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

    private Game checkersGame;

    /**
     * Get the value of checkersGame
     *
     * @return the value of checkersGame
     */
    public Game getCheckersGame() {
        return checkersGame;
    }

    /**
     * Set the value of checkersGame
     *
     * @param checkersGame new value of checkersGame
     */
    public void setCheckersGame(Game checkersGame) {
        this.checkersGame = checkersGame;
    }

    /**
     * Sets the current state
     *
     * @param currentState the currentState to set
     */
    public void setCurrentState(State currentState) {
           this.prevState = this.currentState;
           this.currentState = currentState;
    }

    /**
     *
     * @return
     */

    public State getCurrentState(){
        return currentState;
    }
    
    /**
     * 
     * @return 
     */
    public String getState() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return currentState.getState();
    }

    /**
     * Switch to PausedState
     */
    public void pauseGame() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        currentState.handleRequest(this, "Paused");
    }

    /**
     *
     * @param gameState
     * @param gameboardMouseListener the value of gameboardMouseListener
     * @param e
     * @param mouseAction
     */
    public void processMouseEvent(GameStateContext gameState, GameboardMouseListener gameboardMouseListener, MouseEvent e, String mouseAction) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        currentState.handleMouseRequest(gameState, gameboardMouseListener, e, mouseAction);
    }

    /*
     * Performs the actions associated with the given state
     */

    /**
     *
     * @param state
     * @param command
     */

    public void processState(GameStateContext state, String command) {
        currentState.handleRequest(this, command);
    }

    /*
     * Switches to either PlayerState or OpponentState
     */

    /**
     *
     */

    public void startGame() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//        setCurrentState(new PlayerState());
        currentState.handleRequest(this, "START");
    }
}
