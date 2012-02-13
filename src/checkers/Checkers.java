/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import gameboard.GameBoard;
import gameboard.Piece;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
        checkers.getGameGui().setVisible(true);
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
        Container container;
        
        gameGui = new JFrame("Welcome to Checkers");
        gameGui.setSize(800, 800);
        // TODO code application logic here
       
        gameGui.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        //gameGui.setLayout(new CardLayout());
        container = gameGui.getContentPane();
       
        /*
        loadingScreen = new JPanel();
        loadingScreen.setBackground(Color.BLUE);
        container.add(loadingScreen);
        */
        board = new GameBoard();
        
        //container.add(loadingScreen);
        container.add(board);
        
        gamePieces = new Piece[24];
        players = new Player[2];
        
        newGame = new Game(board, gamePieces, players);
        
    }

    /**
     * @return the gameGui
     */
    public JFrame getGameGui() {
        return gameGui;
    }

    /**
     * @param gameGui the gameGui to set
     */
    public void setGameGui(JFrame gameGui) {
        this.gameGui = gameGui;
    }
}
