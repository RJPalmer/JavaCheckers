/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import gameboard.GameBoard;
import gameboard.Piece;
import javax.swing.JFrame;

/**
 *
 * @author Palmer
 */
public class Game {

    private JFrame gameGUI;
    
    public Game() {
        gameGUI = new JFrame("Welcome to Checkers");
        gameGUI.setSize(800, 800);
    }

    public Game(GameBoard board, Piece[] gamePieces, Player[] players) {
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    void startGame() {
        //throw new UnsupportedOperationException("Not yet implemented");
        gameGUI.setVisible(true);
    }
    
}
