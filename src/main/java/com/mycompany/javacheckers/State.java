/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.javacheckers;

import Gameboard.GameboardMouseListener;
import java.awt.event.MouseEvent;

/**
 *
 * @author robertpalmer
 */
public interface State {

    public void handleMouseRequest(GameStateContext gameState, GameboardMouseListener gameboardMouseListener, MouseEvent e, String command);

    /**
     *
     * @param gameState
     */
    public void switchToPause(com.mycompany.javacheckers.GameStateContext gameState);


    /**
     *
     * @return A String with the name of the state
     */
    String getState();

    /**
     *
     * @param gs the value of gs
     */
    void changeState(com.mycompany.javacheckers.GameStateContext gs);


    /**
     *
     * @param gs the value of gs
     * @param command the value of command */
    void handleRequest(com.mycompany.javacheckers.GameStateContext gs, java.lang.String command);
    
}
