/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

/**
 *
 * @author robertpalmer
 */
public class GameState {
    private State currentState;

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
    
    public void processState(){
        if(currentState != null){
            currentState.handleRequest();
        }else{
            System.out.println("No state set");
        }
    }
}
