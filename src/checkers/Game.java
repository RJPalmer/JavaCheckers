/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import gameboard.GameBoard;
import gameboard.Piece;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Palmer
 */
public class Game {

    private JFrame gameGUI;
    private int numPieces;

    public Game() {
        gameGUI = new JFrame("Welcome to Checkers");
        gameGUI.setSize(800, 800);
        gameGUI.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

    }

    public Game(GameBoard board, Piece[] gamePieces, Player[] players) {
        //throw new UnsupportedOperationException("Not yet implemented");
        this();
        Container container;
        
        numPieces = 26;
        container = gameGUI.getContentPane();
        Piece[] player1Pieces = new Piece[numPieces / 2 ];
        Piece[] player2Pieces = new Piece[numPieces / 2];
        
        
        for (int i = 0; i < (numPieces / 2); i++) {
           
            player1Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
            player2Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
            player1Pieces[i].setPieceColor(Color.RED);
            player2Pieces[i].setPieceColor(Color.yellow);
        }
        
        
        initPieces(player1Pieces, player2Pieces);
        gamePieces = new Piece[numPieces];
        List<Piece> list = new ArrayList<Piece>(Arrays.asList(player1Pieces));
        list.addAll(Arrays.asList(player2Pieces));
        list.toArray(gamePieces);
        board.setPieces(gamePieces);
        container.add(board);
    }

    void startGame() {
        //throw new UnsupportedOperationException("Not yet implemented");
        gameGUI.setVisible(true);
    }

    private void initPieces(Piece[] pieces1, Piece[] pieces2) {

        int swap = 1;
        int pieceIndex = 0;
        //for the top pieces
        for (int k = 0; k <= (99 * 3); k += (99)) {
            if (swap % 2 == 1) {

                for (int j = 99; j <= gameGUI.getWidth(); j += (2 * 99)) {

                    if (pieceIndex < pieces1.length) {
                        pieces1[pieceIndex].setxPos(j);
                        pieces1[pieceIndex].setyPos(k);
                        pieceIndex++;
                    }
                }

                swap++;
            }//end if
            else {
                for (int j = 0; j <= gameGUI.getWidth(); j += (2 * 99)) {
                    if (pieceIndex < pieces1.length) {
                        pieces1[pieceIndex].setxPos(j);
                        pieces1[pieceIndex].setyPos(k);
                        pieceIndex++;
                    }
                }//end for loop

                swap++;
            }//end else
            if (swap > 2) {
                swap = 1;
            }
        }//end for loop
        
        //for the bottom pieces
        for (int k = (gameGUI.getHeight() - 99); 
                k >= ((gameGUI.getHeight() - (99*3))); k -= (99)) {
            if (swap % 2 == 1) {

                for (int j = 99; j <= gameGUI.getWidth(); j += (2 * 99)) {

                    if (pieceIndex < pieces2.length) {
                        pieces2[pieceIndex].setxPos(j);
                        pieces2[pieceIndex].setyPos(k);
                        pieceIndex++;
                    }
                }

                swap++;
            }//end if
            else {
                for (int j = 0; j <= gameGUI.getWidth(); j += (2 * 99)) {
                    if (pieceIndex < pieces2.length) {
                        pieces2[pieceIndex].setxPos(j);
                        pieces2[pieceIndex].setyPos(k);
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
