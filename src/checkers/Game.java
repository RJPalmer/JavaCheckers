/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import gameboard.GameBoard;
import gameboard.Piece;
import java.awt.Container;
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
        gameGUI.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
    }

    public Game(GameBoard board, Piece[] gamePieces, Player[] players) {
        //throw new UnsupportedOperationException("Not yet implemented");
        this();
        Container container;
        container = gameGUI.getContentPane();
        board.setPieces(gamePieces);
        container.add(board);
    }

    void startGame() {
        //throw new UnsupportedOperationException("Not yet implemented");
        gameGUI.setVisible(true);
    }
    
}
