/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javacheckers;

import Gameboard.BoardSquare;
import Gameboard.GameBoard;
import Gameboard.GameboardResizeListener;
import Gameboard.Piece;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Handles the logic for playing the game
 * @author Palmer
 */
public class Game {

    private static final int GAME_PIECE_COUNT = 24;
    private static final int ROW_COUNT = 8;
    private static final int COLUMN_COUNT = 8;
    private JFrame gameGUI;
    private GameboardResizeListener resizer;

    /**
     * Empty Game Constructor
     */
    public Game() {
        gameGUI = new JFrame("Welcome to Checkers");
        gameGUI.setSize(800, 800);
        gameGUI.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        gameGUI.addComponentListener(resizer);

    }

    /**
     * Game Constructor
     * 
     * @param board
     * @param gamePieces
     * @param players
     */
    public Game(GameBoard board, Piece[] gamePieces, Player[] players) {
        //throw new UnsupportedOperationException("Not yet implemented");
        this();
//        JScrollPane scrollPane = new JScrollPane()
        Container container;
        JScrollPane panel = new JScrollPane();
        panel.setPreferredSize(new Dimension(800, 800));
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
                gameBoard[rowIndex][colIndex] = new BoardSquare(color, false, null);
            }
        }

//        //TO BE REMOVED
//        Piece[] player1Pieces = new Piece[GAME_PIECE_COUNT / 2];
//        Piece[] player2Pieces = new Piece[GAME_PIECE_COUNT / 2];
        for (int i = 0; i < gamePieces.length; i++) {
            gamePieces[i] = new Piece(0, 0, 0, 0, 100, 100, 0, 360, false);
//<editor-fold defaultstate="collapsed" desc="comment">
/*

            player1Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
            player2Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
            player1Pieces[i].setPieceColor(Color.RED);
            player2Pieces[i].setPieceColor(Color.yellow);
             */
//</editor-fold>      
        }

        initPieces(gamePieces, gameBoard);

        //List<Piece> list = new ArrayList<Piece>(Arrays.asList(player1Pieces));
        //list.addAll(Arrays.asList(player2Pieces));
        //list.toArray(gamePieces);
        board.setGameBoard(gameBoard);
        board.setPieces(gamePieces);
        board.setPreferredSize(new Dimension(800, 800));
        panel.setViewportView(board);
        JPanel tempPanel = new JPanel();
        tempPanel.add(panel);
//        panel.setPreferredSize(new Dimension(800, 800));
        container.add(tempPanel);

    }

    /**
     * Sets the JFrame to visible to display the screen
     */
    void startGame() {
        //throw new UnsupportedOperationException("Not yet implemented");
        gameGUI.setVisible(true);
    }

    /**
     * Places a piece on a square on the gameboard
     * @param rowIndex
     * @param colIndex
     * @param boardSquare
     * @param player1Piece
     */
    private void placePiece(int rowIndex, int colIndex, BoardSquare boardSquare, Piece player1Piece) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        player1Piece.setxCol(colIndex);
        player1Piece.setyRow(rowIndex);
        boardSquare.setCurrentPiece(player1Piece);
        boardSquare.setHasPiece(true);

    }

    /**
     * Sets up the pieces for the game and places them in their initial positions.
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
        for (int rowIndex = 0; rowIndex < playerRowCount; rowIndex++) {
            for (int colIndex = 0; colIndex < COLUMN_COUNT; colIndex++) {
                Color color = gameBoard[rowIndex][colIndex].getColor();
                if (color.equals(Color.black)) {
                    gamePieces[pieceIndex].setxCol(colIndex);
                    gamePieces[pieceIndex].setyRow(rowIndex);
                    gamePieces[pieceIndex].setPieceColor(Color.yellow);
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex], gamePieces[pieceIndex]);
                    pieceIndex++;
                    if (pieceIndex >= pieceCount) {
                        break;
                    }
                }
            }
        }
        int playerTwoRowStart = ROW_COUNT - playerRowCount;

        for (int rowIndex = playerTwoRowStart; rowIndex < ROW_COUNT; rowIndex++) {
            for (int colIndex = 0; colIndex < COLUMN_COUNT; colIndex++) {
                Color color = gameBoard[rowIndex][colIndex].getColor();
                if (color.equals(Color.black)) {
                    gamePieces[pieceIndex].setxCol(colIndex);
                    gamePieces[pieceIndex].setyRow(rowIndex);
                    gamePieces[pieceIndex].setPieceColor(Color.RED);
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex], gamePieces[pieceIndex]);
                    pieceIndex++;
                    if (pieceIndex >= GAME_PIECE_COUNT) {
                        break;
                    }
                }
            }
        }
    }
}
