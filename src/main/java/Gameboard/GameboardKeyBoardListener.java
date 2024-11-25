/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import Gameboard.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author robertpalmer
 */

public class GameboardKeyBoardListener implements KeyListener {

    private GameBoard gameObj;

    /**
     * Get the value of gameObj
     *
     * @return the value of gameObj
     */
    public GameBoard getGameObj() {
        return gameObj;
    }

    /**
     * Set the value of gameObj
     *
     * @param gameObj new value of gameObj
     */
    public void setGameObj(GameBoard gameObj) {
        this.gameObj = gameObj;
    }

    public GameboardKeyBoardListener() {
    }

    public GameboardKeyBoardListener(GameBoard gameObj) {
        
        this.gameObj = gameObj;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Enter key pressed!");
            gameObj.pauseGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
