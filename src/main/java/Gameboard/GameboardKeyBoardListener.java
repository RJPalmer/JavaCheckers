/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import com.mycompany.javacheckers.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author robertpalmer
 */

public class GameboardKeyBoardListener implements KeyListener {

    private GameBoard gameObj;

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

    /**
     * Empty Constructor
     */
    public GameboardKeyBoardListener() {
    }

    /**
     *
     * @param gameObj
     */
    public GameboardKeyBoardListener(com.mycompany.javacheckers.Game gameObj) {
        
        this.checkersGame = gameObj;
    }

    /**
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Enter key pressed!");
            checkersGame.getGameState().pauseGame();
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
