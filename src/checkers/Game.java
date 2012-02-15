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

        for (int i = 0; i < gamePieces.length; i++) {
            gamePieces[i] = new Piece(0, 0, 100, 100, 0, 360);
        }
        initPieces(gamePieces);
        board.setPieces(gamePieces);
        container.add(board);
    }

    void startGame() {
        //throw new UnsupportedOperationException("Not yet implemented");
        gameGUI.setVisible(true);
    }

    private void initPieces(Piece[] pieces) {

        int swap = 1;
        int pieceIndex = 0;
        for (int k = 0; k <= gameGUI.getHeight(); k += (99)) {
            if (swap % 2 == 1) {

                for (int j = 99; j <= gameGUI.getWidth(); j += (2 * 99)) {

                    if (pieceIndex < pieces.length) {
                        pieces[pieceIndex].setxPos(j);
                        pieces[pieceIndex].setyPos(k);
                        pieceIndex++;
                    }
                }

                swap++;
            }//end if
            else {
                for (int j = 0; j <= gameGUI.getWidth(); j += (2 * 99)) {
                    if (pieceIndex < pieces.length) {
                        pieces[pieceIndex].setxPos(j);
                        pieces[pieceIndex].setyPos(k);
                        pieceIndex++;
                    }
                }//end for loop

                swap++;
            }//end else
            if (swap > 2) {
                swap = 1;
            }
        }//end for loop
    }
}
