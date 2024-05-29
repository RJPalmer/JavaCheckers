/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import gameboard.BoardSquare;
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

    private static final int GAME_PIECE_COUNT = 24;
    private static final int ROW_COUNT = 8;
    private static final int COLUMN_COUNT = 8;
    private JFrame gameGUI;
    private int numPieces;

    /**
     *
     */
    public Game() {
        gameGUI = new JFrame("Welcome to Checkers");
        gameGUI.setSize(800, 800);
        gameGUI.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

    }

    /**
     *
     * @param board
     * @param gamePieces
     * @param players
     */
    public Game(GameBoard board, Piece[] gamePieces, Player[] players) {
        //throw new UnsupportedOperationException("Not yet implemented");
        this();
        Container container;

        container = gameGUI.getContentPane();

        BoardSquare[][] gameBoard;
        gameBoard = new BoardSquare[ROW_COUNT][COLUMN_COUNT];

        //sets up gameboard
        for (int rowIndex = 0; rowIndex < ROW_COUNT; rowIndex++) {
            Color color1, color2;
            if (rowIndex % 2 == 0) {
                color1 = Color.BLACK;
                color2 = Color.BLUE;
            } else {
                color1 = Color.BLUE;
                color2 = Color.BLACK;
            }
            for (int colIndex = 0; colIndex < COLUMN_COUNT; colIndex++) {
                Color color = (colIndex % 2 == 0) ? color1 : color2;
                gameBoard[rowIndex][colIndex] = new gameboard.BoardSquare(color, false, null);
            }
        }
        
        
//        //TO BE REMOVED
//        Piece[] player1Pieces = new Piece[GAME_PIECE_COUNT / 2];
//        Piece[] player2Pieces = new Piece[GAME_PIECE_COUNT / 2];

        for (int i = 0; i < gamePieces.length; i++) {
                gamePieces[i] = new Piece(0,0,100,100,0,360);
//            player1Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
//            player2Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
//            player1Pieces[i].setPieceColor(Color.RED);
//            player2Pieces[i].setPieceColor(Color.yellow);

                
        }

        initPieces(gamePieces, gameBoard);
        
        //List<Piece> list = new ArrayList<Piece>(Arrays.asList(player1Pieces));
        //list.addAll(Arrays.asList(player2Pieces));
        //list.toArray(gamePieces);
        board.setGameBoard(gameBoard);
        board.setPieces(gamePieces);
        container.add(board);
    }

    void startGame() {
        //throw new UnsupportedOperationException("Not yet implemented");
        gameGUI.setVisible(true);
    }

    /**
     * Places game pieces on the gameboard
     * @param pieces1
     * @param pieces2 
     */
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

        pieceIndex = 0;
        //for the bottom pieces
        for (int k = (gameGUI.getHeight() - 102);
                k >= ((gameGUI.getHeight() - (102 * 3))); k -= (100)) {
            if (swap % 2 == 0) {

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

    /**
     * 
     * @param player1Pieces
     * @param player2Pieces
     * @param gameBoard 
     */
    private void initPieces(Piece[] player1Pieces, Piece[] player2Pieces, BoardSquare[][] gameBoard) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        int pieceCount = 12;
        int playerRowCount = 3;
        int rowCount = 8;
        int pieceIndex = 0; 
       
        //for each row of the gameboard
        for (int rowIndex = 0; rowIndex < playerRowCount; rowIndex++){
            for (int colIndex =0; colIndex < COLUMN_COUNT; colIndex++){
                Color color = gameBoard[rowIndex][colIndex].getColor();
                if(color.equals(Color.black)){
                    player1Pieces[pieceIndex].setxPos(colIndex);
                    player1Pieces[pieceIndex].setyPos(rowIndex);
                    player1Pieces[pieceIndex].setPieceColor(Color.yellow);
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex], player1Pieces[pieceIndex]);
                    pieceIndex++;
                    if(pieceIndex >= pieceCount)
                        break;
                }
            }
        }
        
        for (int rowIndex = ROW_COUNT - playerRowCount - 1; rowIndex < ROW_COUNT; rowIndex++){
            for (int colIndex =0; colIndex < COLUMN_COUNT; colIndex++){
                Color color = gameBoard[rowIndex][colIndex].getColor();
                if(color.equals(Color.black)){
                    player2Pieces[pieceIndex].setxPos(colIndex);
                    player2Pieces[pieceIndex].setyPos(rowIndex);
                    player2Pieces[pieceIndex].setPieceColor(Color.RED);
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex], player2Pieces[pieceIndex]);
                    pieceIndex++;
                    if(pieceIndex >= pieceCount)
                        break;
                }
            }
        }
    }

    /**
     * 
     * @param rowIndex
     * @param colIndex
     * @param boardSquare
     * @param player1Piece 
     */
    private void placePiece(int rowIndex, int colIndex, BoardSquare boardSquare, Piece player1Piece) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        player1Piece.setxPos(colIndex);
        player1Piece.setyPos(rowIndex);
        boardSquare.setCurrentPiece(player1Piece);
        
    }

    /**
     * 
     * @param gamePieces
     * @param gameBoard 
     */
    private void initPieces(Piece[] gamePieces, BoardSquare[][] gameBoard) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int pieceCount = 12;
        int playerRowCount = 3;
        int rowCount = 8;
        int pieceIndex = 0; 
       
        //for each row of the gameboard
        for (int rowIndex = 0; rowIndex < playerRowCount; rowIndex++){
            for (int colIndex =0; colIndex < COLUMN_COUNT; colIndex++){
                Color color = gameBoard[rowIndex][colIndex].getColor();
                if(color.equals(Color.black)){
                    gamePieces[pieceIndex].setxPos(colIndex);
                    gamePieces[pieceIndex].setyPos(rowIndex);
                    gamePieces[pieceIndex].setPieceColor(Color.yellow);
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex], gamePieces[pieceIndex]);
                    pieceIndex++;
                    if(pieceIndex >= pieceCount)
                        break;
                }
            }
        }
        int playerTwoRowStart = ROW_COUNT - playerRowCount;
        
        for (int rowIndex = playerTwoRowStart; rowIndex < ROW_COUNT; rowIndex++){
            for (int colIndex =0; colIndex < COLUMN_COUNT; colIndex++){
                Color color = gameBoard[rowIndex][colIndex].getColor();
                if(color.equals(Color.black)){
                    gamePieces[pieceIndex].setxPos(colIndex);
                    gamePieces[pieceIndex].setyPos(rowIndex);
                    gamePieces[pieceIndex].setPieceColor(Color.RED);
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex], gamePieces[pieceIndex]);
                    pieceIndex++;
                    if(pieceIndex >= GAME_PIECE_COUNT)
                        break;
                }
            }
        }
    }
}
