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
public class InitState implements State {

    @Override
    public void changeState(com.mycompany.javacheckers.GameStateContext gs) {

    }

    @Override
    public String getState() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return "Init State";
    }

    /*
     *
     */
    @Override
    public void handleMouseRequest(GameStateContext gameState, GameboardMouseListener gameboardMouseListener, MouseEvent e, String command) {

    }

    @Override
    public void handleRequest(com.mycompany.javacheckers.GameStateContext gs, java.lang.String command) {
        System.out.println("Setting up game");

        switch (command) {
            case "START":

                gs.getCheckersGame().start();
                break;
            default:
                throw new AssertionError();
        }

    }

    @Override
    public void switchToPause(GameStateContext gameState) {
        System.out.println("Pausing Game");

    }

}
