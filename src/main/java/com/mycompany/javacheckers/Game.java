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
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Handles the logic for playing the game
 *
 * @author Palmer
 */
public class Game {

    public static final int GAME_PIECE_COUNT = 24;
    public static int PLAYER_PIECE_COUNT;
    private static final int ROW_COUNT = 8;
    private static final int COLUMN_COUNT = 8;

    /**
     *
     */
    public static final String PROP_USERCOLOR = "userColor";
    private JFrame gameGUI;
    private GameboardResizeListener resizer;
    public GameBoard gameboard;
    private boolean haveWinner;
    private Player userPlayer;
    private ComputerPlayer opponent;
    private int turnCount;
    private String userColor;

    /**
     * Represents the pieces used for the game
     */
    public Piece[] piecesForGame;
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);

    /**
     * Empty Game Constructor
     */
    public Game() {
        PLAYER_PIECE_COUNT = 12;
        gameGUI = new JFrame("Welcome to Checkers");
        gameGUI.setSize(800, 800);
        gameGUI.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        gameGUI.addComponentListener(resizer);

        gameboard = new GameBoard();
        piecesForGame = new Piece[]{};
        haveWinner = false;
        turnCount = 1;
        userColor = "";
        this.playerDomains = new PlayerArea[0];
        this.userPlayer = new Player();
    }

    /**
     * Game Constructor
     *
     * @param board The gameboard used in the game
     * @param gamePieces The pieces that are used in the game
     * @param players The players playing in the game.
     */
    public Game(GameBoard board, Piece[] gamePieces, Player[] players) {
        this();
        PLAYER_PIECE_COUNT = 12;

        //throw new UnsupportedOperationException("Not yet implemented");
//        JScrollPane scrollPane = new JScrollPane()
        Container container;
        JScrollPane panel = new JScrollPane();
        panel.setPreferredSize(new Dimension(800, 800));
        container = gameGUI.getContentPane();

        BoardSquare[][] dataGameBoard;
        dataGameBoard = new BoardSquare[ROW_COUNT][COLUMN_COUNT];
        gameboard = board;
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
                dataGameBoard[rowIndex][colIndex] = new BoardSquare(color, false, null);
            }
        }

//<editor-fold defaultstate="collapsed" desc="comment">
//TO BE REMOVED
//        Piece[] player1Pieces = new Piece[GAME_PIECE_COUNT / 2];
//        Piece[] player2Pieces = new Piece[GAME_PIECE_COUNT / 2];
//</editor-fold>
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

        playerDomains = new PlayerArea[players.length];
        initPieces(gamePieces, dataGameBoard, playerDomains);
        this.piecesForGame = gamePieces;
        //List<Piece> list = new ArrayList<Piece>(Arrays.asList(player1Pieces));
        //list.addAll(Arrays.asList(player2Pieces));
        //list.toArray(gamePieces);
        gameboard.setGameBoard(dataGameBoard);
        gameboard.setPieces(gamePieces);
        gameboard.setPreferredSize(new Dimension(800, 800));
        gameboard.setUserPlayer(this.userPlayer);
        panel.setViewportView(board);
        JPanel tempPanel = new JPanel();
        tempPanel.add(panel);
//        panel.setPreferredSize(new Dimension(800, 800));
        container.add(tempPanel);
        userColor = "";

    }

    /**
     * Sets the JFrame to visible to display the screen
     */
    public void startGame() throws InterruptedException {

        String playerColor = userPlayer.getPlayerColor();
        boolean moveMade = false;
        //throw new UnsupportedOperationException("Not yet implemented");
        gameGUI.setVisible(true);
        //PlayerArea oppArea = new PlayerArea();

        int lastPlayed = 0;
        //let the user pick their boardSquareColor
        userPlayer = pickUserPlayer();
        userPlayer.isUserPlayer = true;

        getUserColor();
        playerColor = userPlayer.getPlayerColor();
        //setup the other player
        setUserColor(playerColor);

        if (playerColor.equals("Yellow")) {

            playerDomains[1].setAreaColor("Red");
            opponent = new ComputerPlayer(playerDomains[1], PLAYER_PIECE_COUNT, null, "Red");
        } else {
            playerDomains[0].setAreaColor("Yellow");
            opponent = new ComputerPlayer(playerDomains[0], PLAYER_PIECE_COUNT, null, "Yellow");
        }

        //give the players their pieces;
        userPlayer.playerPieces = setPlayerPieces(userPlayer);
        opponent.playerPieces = setPlayerPieces(opponent);
//        userPlayer = userPlayer;
//        opponent = opponent;
        //play the game until you have a winner
        while (!haveWinner) {

            //darker boardSquareColor goes first
                if (turnCount == 1) {
                if ("Red".equals(userPlayer.getPlayerColor())) {
                    userPlayer.makeMove(this.gameboard);
                    if (moveMade) {
                        lastPlayed = 0;
                    }
                } else {
                    opponent.makeMove(this.gameboard);
                    if (moveMade) {
                        lastPlayed = 1;
                        this.gameboard.repaint();
                    }
                }

                //now the other player goes
                switch (lastPlayed) {
                    case 0 -> {
                        opponent.makeMove(this.gameboard);
                        checkForWinner(userPlayer, opponent);
                        lastPlayed = 1;
                    }

                    case 1 -> {
                        userPlayer.makeMove(this.gameboard);
                        checkForWinner(userPlayer, opponent);
                        lastPlayed = 0;
                    }
                }
            }
            //for all other turns
            switch (lastPlayed) {
                case 0 -> {
                    opponent.makeMove(this.gameboard);
                    if (moveMade) {
                        checkForWinner(userPlayer, opponent);
                        lastPlayed = 1;
                    }
                }

                case 1 -> {
                    
                    userPlayer.makeMove(this.gameboard);
                    if (moveMade) {
                        checkForWinner(userPlayer, opponent);
                        lastPlayed = 0;
                    }
                }
            }
            turnCount++;
        }
    }

    /**
     *
     */
    public PlayerArea[] playerDomains;

    /**
     * Get the value of playerDomains
     *
     * @return the value of playerDomains
     */
    public PlayerArea[] getPlayerDomains() {
        return playerDomains;
    }

    /**
     * Set the value of playerDomains
     *
     * @param playerDomains new value of playerDomains
     */
    public void setPlayerDomains(PlayerArea[] playerDomains) {
        this.playerDomains = playerDomains;
    }

    /**
     * Places a piece on a square on the gameboard
     *
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
     * Sets up the pieces for the game and places them in their initial
     * positions.
     *
     * @param gamePieces
     * @param gameBoard
     */
    private void initPieces(Piece[] gamePieces, BoardSquare[][] gameBoard) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int pieceCount = 12;
        int playerRowCount = 3;
        int pieceIndex = 0;

        //for each row of the gameboard
        for (int rowIndex = 0; rowIndex < playerRowCount; rowIndex++) {
            for (int colIndex = 0; colIndex < COLUMN_COUNT; colIndex++) {
                Color color = gameBoard[rowIndex][colIndex].getColor();
                if (color.equals(Color.black)) {
                    gamePieces[pieceIndex].setxCol(colIndex);
                    gamePieces[pieceIndex].setyRow(rowIndex);
                    gamePieces[pieceIndex].setPieceColor(Color.yellow);
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex],
                            gamePieces[pieceIndex]);
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
                    placePiece(rowIndex, colIndex, gameBoard[rowIndex][colIndex],
                            gamePieces[pieceIndex]);
                    pieceIndex++;
                    if (pieceIndex >= GAME_PIECE_COUNT) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Determines which piece boardSquareColor gets associated with the user
     *
     * @return A player object with the user's chosen piece boardSquareColor
     */
    private Player pickUserPlayer() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Player chosenPlayer;
        String[] pieceColors = {"Yellow", "Red"};

        //have the user pick which boardSquareColor they want
        int choice = JOptionPane.showOptionDialog(null, "Choose A Color",
                "Pick Your Color", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, pieceColors, pieceColors[0]);
        if (choice == 1) {
            chosenPlayer = new Player(playerDomains[1], PLAYER_PIECE_COUNT, null, pieceColors[choice]);
        } else {
            chosenPlayer = new Player(playerDomains[0], PLAYER_PIECE_COUNT, null, pieceColors[choice]);
        }

        //chosenPlayer = new Player(, PLAYER_PIECE_COUNT, null, pieceColors[choice]);
        return chosenPlayer;
    }

    /**
     * Checks if a player has won the game
     *
     * @param player the user player
     * @param opponent1 the computer player
     */
    private void checkForWinner(Player player, ComputerPlayer opponent1) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (player.getPiecesCount() == 0) {
            JOptionPane.showMessageDialog(gameGUI, String.format("The %s player has won", opponent1.getPlayerColor()));
            haveWinner = true;
        }
        if (opponent1.getPiecesCount() == 0) {
            JOptionPane.showMessageDialog(gameGUI, String.format("The %s player has won", player.getPlayerColor()));
            haveWinner = true;
        }
    }

    /**
     * Returns the piece boardSquareColor associated with the user
     *
     * @return the userColor
     */
    public String getUserColor() {
        return userColor;
    }

    /**
     * Sets the piece boardSquareColor associated with the user
     *
     * @param userColor the userColor to set
     */
    public void setUserColor(String userColor) {
        java.lang.String oldUserColor = this.userColor;
        this.userColor = userColor;
        propertyChangeSupport.firePropertyChange(PROP_USERCOLOR, oldUserColor, userColor);
    }

    /**
     * Filters the game pieces and returns the ones that belong to the player
     *
     * @return
     */
    private Piece[] setPlayerPieces(Player userPlayer1) {
        Piece[] playerPieces = null;
        try {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            //Piece[] playerPieces = null;

            String playerColor = userPlayer1.getPlayerColor().toLowerCase();
            Color tempColor;
            Field field = Color.class.getField(playerColor);
            tempColor = (Color) field.get(null);

            Color temp2 = tempColor;
            List<Piece> filtered;
            filtered = Arrays.stream(this.piecesForGame).filter(piece -> piece.getPieceColor()
                    == temp2).collect(Collectors.toList());
            playerPieces = filtered.toArray(Piece[]::new);
            return playerPieces;
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            return playerPieces;
        }
    }

    private void initPieces(Piece[] gamePieces, BoardSquare[][] dataGameBoard, PlayerArea[] playerDomains) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int pieceCount = 12;
        int playerRowCount = 3;
        int pieceIndex = 0;
        List<Integer> rows = new ArrayList<Integer>();
        Color pieceColor1 = Color.yellow;
        Color pieceColor2 = Color.RED;

        playerDomains[1] = new PlayerArea();
        playerDomains[1].setAreaColor("Red");
        playerDomains[0] = new PlayerArea();
        playerDomains[0].setAreaColor("Yellow");

        //for each row of the gameboard
        for (int rowIndex = 0; rowIndex < playerRowCount; rowIndex++) {
            for (int colIndex = 0; colIndex < COLUMN_COUNT; colIndex++) {
                Color boardSquareColor = dataGameBoard[rowIndex][colIndex].getColor();
                if (boardSquareColor.equals(Color.black)) {
                    gamePieces[pieceIndex].setxCol(colIndex);
                    gamePieces[pieceIndex].setyRow(rowIndex);
                    gamePieces[pieceIndex].setPieceColor(pieceColor1);
                    placePiece(rowIndex, colIndex, dataGameBoard[rowIndex][colIndex],
                            gamePieces[pieceIndex]);
                    pieceIndex++;
                    if (pieceIndex >= pieceCount) {
                        break;
                    }
                }
            }
            rows.add(rowIndex);
        }

        int[] temp = rows.stream().mapToInt(Integer::intValue).toArray();
        playerDomains[0].setAreaRows(temp);
        rows.clear();
        int playerTwoRowStart = ROW_COUNT - playerRowCount;

        for (int rowIndex = playerTwoRowStart; rowIndex < ROW_COUNT; rowIndex++) {

            for (int colIndex = 0; colIndex < COLUMN_COUNT; colIndex++) {
                Color color = dataGameBoard[rowIndex][colIndex].getColor();
                if (color.equals(Color.black)) {
                    gamePieces[pieceIndex].setxCol(colIndex);
                    gamePieces[pieceIndex].setyRow(rowIndex);

                    gamePieces[pieceIndex].setPieceColor(pieceColor2);
                    placePiece(rowIndex, colIndex, dataGameBoard[rowIndex][colIndex],
                            gamePieces[pieceIndex]);
                    pieceIndex++;
                    if (pieceIndex >= GAME_PIECE_COUNT) {
                        break;
                    }
                }
            }
            rows.add(rowIndex);
        }
        temp = rows.stream().mapToInt(Integer::intValue).toArray();
        playerDomains[1].setAreaRows(temp);
    }

}
