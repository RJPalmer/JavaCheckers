/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javacheckers;

import Gameboard.GameBoard;
import javax.swing.JPanel;

import Gameboard.Piece;

/**
 * Checkers - An application that allows a user to play the game of checkers
 * @author Palmer
 */
public class Checkers {

    
    /**
     * GameBoard
     */
    private GameBoard board;
    /**
     * gamePieces
     */
    private Piece[] gamePieces;
    /**
     * players
     */
    private Player[] players;
    /**
     * newGame
     */
    private Game newGame;
    /**
     * loadingScreen
     */
    private JPanel loadingScreen;

    /**
     * 
     */
    public Checkers() {
        initComponents();
        
    }

    /**
     * 
     * @param board
     * @param gamePieces
     * @param players 
     */
    public Checkers(GameBoard board, Piece[] gamePieces, Player[] players) {
        this.board = board;
        this.gamePieces = gamePieces;
        this.players = players;
        
        newGame = new Game(this.board, this.gamePieces, this.getPlayers());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Checkers checkers = new Checkers();
        checkers.newGame.startGame();
    }

    /**
     * @return the players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
    /**
     * 
     * @param newPlayer 
     */
    public void addPlayer(Player newPlayer){
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void initComponents() {
        boolean isLoading = true;
        
       
        /*
        loadingScreen = new JPanel();
        loadingScreen.setBackground(Color.BLUE);
        container.add(loadingScreen);
        */
        board = new GameBoard();
        
        //container.add(loadingScreen);
        
        
        gamePieces = new Piece[GAME_PIECE_COUNT];
        players = new Player[PLAYER_COUNT];
        
        newGame = new Game(board, gamePieces, players);
        
    }
    private static final int PLAYER_COUNT = 2;
    private static final int GAME_PIECE_COUNT = 24;

}
