/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;


/**
 *
 * @author robertpalmer
 */
public class InitState implements State {
    
    @Override
    public void handleRequest(){
        System.out.println("Setting up game");
    }
    
}
