/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

/**
 * A State that represents the player's turn 
* @author robertpalmer
 */
public class PlayerState implements State {

    private boolean hasMoved;

    @Override
    public String getState() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return "Player State";
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

    public PlayerState() {
    }

    @Override
    public void handleRequest() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("It''s the player''s turn");
    }

    @Override
    public void nextState(GameState gs) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @Override
    public void prevState(GameState gs) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
