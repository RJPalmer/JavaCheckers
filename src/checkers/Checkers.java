/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import javax.swing.JPanel;

import gameboard.GameBoard;
import gameboard.Piece;

/**
 * Checkers - An application that allows a user to play the game of checkers
 * @author Palmer
 */
public class Checkers {

    private GameBoard board;
    private Piece[] gamePieces;
    private Player[] players;
    private Game newGame;
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
        
        
        gamePieces = new Piece[13];
        players = new Player[2];
        
        newGame = new Game(board, gamePieces, players);
        
    }

}
