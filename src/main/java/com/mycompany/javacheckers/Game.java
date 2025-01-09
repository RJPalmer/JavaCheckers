/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javacheckers;

import Gameboard.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

/**
 * Handles the logic for playing the game
 *
 * @author Palmer
 */
public class Game {

    private static final int COLUMN_COUNT = 8;
    private static final String PAUSED = "Paused";
    private static final String PRESSED = "Pressed";
    private static final String RELEASED = "Released";
    private static final int ROW_COUNT = 8;

    /**
     *
     */
    public static final int GAME_PIECE_COUNT = 24;

    /**
     *
     */
    public static int PLAYER_PIECE_COUNT;

    /**
     *
     */
    public static final String PROP_USERCOLOR = "userColor";

    private GameStateContext gameState;
    private JFrame gameWindow;

    private boolean haveWinner;
    private ComputerPlayer opponent;
    private final transient PropertyChangeSupport propertyChangeSupport = new java.beans.PropertyChangeSupport(this);
    private String userColor;
    private Player userPlayer;
    /**
     *
     */
    public GameMenu gameMenu;
    /**
     *
     */
    public GameBoard gameboard;
    /**
     * Represents the pieces used for the game
     */
    public Piece[] piecesForGame;
    /**
     *
     */
    public PlayerArea[] playerDomains;

    /**
     * Empty Game Constructor
     */
    public Game() {
        PLAYER_PIECE_COUNT = 12;
        gameWindow = new JFrame();
        gameboard = new GameBoard();
        gameMenu = new GameMenu(this);
        piecesForGame = new Piece[]{};
        haveWinner = false;
        userColor = "";
        this.playerDomains = new PlayerArea[0];
        this.userPlayer = new Player();

        gameState = new GameStateContext();

    }

    /**
     * Game Constructor
     *
     * @param window
     * @param board      The gameboard used in the game
     * @param gamePieces The pieces that are used in the game
     * @param players    The players playing in the game.
     */
    public Game(JFrame window, GameBoard board, Piece[] gamePieces, Player[] players) {
        this();
        PLAYER_PIECE_COUNT = 12;

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);
        JScrollPane panel = new JScrollPane();
        panel.setPreferredSize(new Dimension(800, 800));

        gameState = new GameStateContext();
        gameWindow = window;
        gameWindow.getContentPane();

        BoardSquare[][] dataGameBoard;
        dataGameBoard = new BoardSquare[ROW_COUNT][COLUMN_COUNT];
        gameboard = board;
        GameboardMouseListener mouseAction;
        mouseAction = new GameboardMouseListener(gameboard, this);
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
             *
             * player1Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
             * player2Pieces[i] = new Piece(0, 0, 100, 100, 0, 360);
             * player1Pieces[i].setPieceColor(Color.RED);
             * player2Pieces[i].setPieceColor(Color.yellow);
             */
//</editor-fold>
        }

        playerDomains = new PlayerArea[players.length];
        initPieces(gamePieces, dataGameBoard, playerDomains);
        this.piecesForGame = gamePieces;

        //Gameboard Setup
        gameboard.setGameBoard(dataGameBoard);
        gameboard.setPieces(gamePieces);
        gameboard.setPreferredSize(new Dimension(800, 800));
        gameboard.setUserPlayer(this.userPlayer);
        gameboard.setParentPanel(cards);
        // gameboard.addKeyListener(new GameboardKeyBoardListener(gameboard));
        gameboard.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "pauseGame");
        gameboard.getActionMap().put("pauseGame", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                getGameState().pauseGame();
            }

        });
        gameboard.addMouseListener(mouseAction);
        gameboard.addMouseMotionListener(mouseAction);

        gameMenu.setParent(cards);
        gameMenu.setCardLayout(cardLayout);
        gameMenu.setIsNext(false);
        cards.add("menu", gameMenu);
        cards.add("board", gameboard);
        //cards.addKeyListener(new GameboardKeyBoardListener(gameboard));
        //cards.setFocusable(true);
        panel.setViewportView(cards);
//        tempPanel.add(panel);
        gameWindow.add(panel);
        userColor = "";

    }

    /**
     * Checks if a player has won the game
     *
     * @param player    the user player
     * @param opponent1 the computer player
     */
    private void checkForWinner(Player player, ComputerPlayer opponent1) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (player.getPiecesCount() == 0) {
            JOptionPane.showMessageDialog(gameWindow, String.format("The %s player has won", opponent1.getPlayerColor()));
            haveWinner = true;
        }
        if (opponent1.getPiecesCount() == 0) {
            JOptionPane.showMessageDialog(gameWindow, String.format("The %s player has won", player.getPlayerColor()));
            haveWinner = true;
        }
    }

    /**
     * Return reference to the game JFrame
     *
     * @return
     */
    private JFrame getGameWindow() {
        return gameWindow;
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
                    gamePieces[pieceIndex].setPieceDirection(POSITIVE);
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
                    gamePieces[pieceIndex].setPieceDirection("NEGATIVE");
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
    private static final String POSITIVE = "POSITIVE";

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

    /**
     *
     */
    public void changeState() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the gameState
     */
    public GameStateContext getGameState() {
        return gameState;
    }

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
     * @return the userPlayer
     */
    public Player getUserPlayer() {
        return userPlayer;
    }

    /**
     * @param userPlayer the userPlayer to set
     */
    public void setUserPlayer(Player userPlayer) {
        this.userPlayer = userPlayer;
    }

    /*
     * Starts the game
     */
    /**
     *
     */
    public void launch() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        gameWindow.setVisible(true);

    }

    /**
     *
     * @param e
     * @param gameboardMouseListener
     */
    public void processMouseDragged(MouseEvent e, GameboardMouseListener gameboardMouseListener) {
        //make sure there's a selected piece
        MouseEvent eMouseEvent = e;
        Piece selectedGamePiece = gameboardMouseListener.getGamePiece();
        if (selectedGamePiece != null && selectedGamePiece.isSelected) {
            //get current mouse x & y
            int newMouseX = e.getX();
            int newMouseY = e.getY();
            int pieceCurrentX = selectedGamePiece.getxPos();
            int pieceCurrentY = selectedGamePiece.getyPos();
            int changeY = 0;
            int changeX = 0;
            if (gameboardMouseListener.getMouseX() != 0 && gameboardMouseListener.getMouseY() != 0) {
                changeX = newMouseX - gameboardMouseListener.getMouseX();
                changeY = newMouseY - gameboardMouseListener.getMouseY();
            }
            gameboardMouseListener.setMouseX(newMouseX);
            gameboardMouseListener.setMouseY(newMouseY);
            //translate mouse screen coordinates into rows/colum
            gameboardMouseListener.translateToGrid(newMouseX, newMouseY);
            //if(newMouseX)
            //update the piece x/y to match the mouse x/y
            selectedGamePiece.setxPos(pieceCurrentX + changeX);
            selectedGamePiece.setyPos(pieceCurrentY + changeY);
            selectedGamePiece.setHasMoved(true);
            gameboardMouseListener.prepMoveCopy();
            gameboardMouseListener.getBoard().repaint();
            //this.userPlayer.setPieceMoved(true);
        }
    }

    /**
     *
     * @param e                      the value of e
     * @param gameboardMouseListener the value of gameboardMouseListener
     */
    public void processMousePressed(MouseEvent e, GameboardMouseListener gameboardMouseListener) {
        gameState.processMouseEvent(gameState, gameboardMouseListener, e, PRESSED);
    }

    /**
     *
     * @param e
     * @param aThis
     */
    public void processMouseReleased(MouseEvent e, GameboardMouseListener aThis) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        
        int currentX;
        int currentY;
        Piece existPiece;
        Piece gamePiece = aThis.getGamePiece();
        if (gamePiece != null) {
            currentX = e.getX();
            currentY = e.getY();
            aThis.translateToGrid(currentX, currentY);
            existPiece = aThis.getBoard().checkForGamePiece(aThis.getSquareX(), aThis.getSquareY());
            if (gamePiece.isHasMoved()) {
                if (Objects.isNull(existPiece)) {
                    BoardSquare currentSqre = aThis.getBoard().getBoardSquare(aThis.getSquareX(), aThis.getSquareY());
                    if (currentSqre.getColor() == Color.BLACK) {
                        GameBoard board = aThis.getBoard();
                        board.movePiece(gamePiece, aThis.getMoveCopy(), aThis.getSquareX(), aThis.getSquareY());
                        aThis.setMoveCopy(null);
                        gamePiece.setHasMoved(false);
                        
                        userPlayer.setMoveComplete();
                        getGameState().processMouseEvent(gameState, aThis, e, RELEASED);
//                    changeState();
                    } else {
                        aThis.getBoard().resetPiece(gamePiece, aThis.getMoveCopy());
                        aThis.setMoveCopy(null);
                        gamePiece.setHasMoved(false);
                    }
                } else {
                    if (gamePiece.IsMoveable()) {
                        aThis.getBoard().resetPiece(gamePiece, aThis.getMoveCopy());
                        aThis.setMoveCopy(null);
                        gamePiece.setHasMoved(false);
                    }
                }
            }
            aThis.getBoard().repaint();
        }
        

    }

    /**
     * Displays the next card in the card layout of the game menu's parent
     * container.
     * <p>
     * This method checks if the {@code gameMenu} is not {@code null}. If it is
     * valid, it retrieves the {@link CardLayout} of the parent container of
     * {@code gameMenu} and moves to the next card in the layout.
     * </p>
     *
     * @throws ClassCastException if the parent container of {@code gameMenu}
     *                            does not use a {@link CardLayout}.
     */
    public void showMenu() {
        if (gameMenu != null) {
            CardLayout tempLayout = (CardLayout) gameMenu.getParent().getLayout();
            tempLayout.next(gameMenu.getParent());

        }

    }

    /**
     *
     */
    public void start() {
        try {
            getGameState().setCurrentState(new InitState());
            swapScreens(gameMenu);
            //getGameState().processState();
            startGame();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets the JFrame to visible to display the screen
     *
     * @throws java.lang.InterruptedException
     */
    public void startGame() throws InterruptedException {

        String playerColor = getUserPlayer().getPlayerColor();
        boolean moveMade = false;
        //throw new UnsupportedOperationException("Not yet implemented");
        //        gameWindow.setVisible(true);
//PlayerArea oppArea = new PlayerArea();

        int lastPlayed = 0;
//let the user pick their boardSquareColor
        setUserPlayer(pickUserPlayer());
        userPlayer.isUserPlayer = true;

        getUserColor();
        playerColor = getUserPlayer().getPlayerColor();
//setup the other player
        setUserColor(playerColor);

        if (playerColor.equals("Yellow")) {

            playerDomains[1].setAreaColor("Red");
            opponent = new ComputerPlayer(playerDomains[1], PLAYER_PIECE_COUNT, null, "Red");
            OpponentState opponentState = new OpponentState(opponent);
            getGameState().setCurrentState(opponentState);
        } else {
            playerDomains[0].setAreaColor("Yellow");
            opponent = new ComputerPlayer(playerDomains[0], PLAYER_PIECE_COUNT, null, "Yellow");
            PlayerState playerState = new PlayerState();
            getGameState().setCurrentState(playerState);
        }

        userPlayer.playerPieces = setPlayerPieces(getUserPlayer());
        opponent.playerPieces = setPlayerPieces(opponent);

        getGameState().startGame();

    }

    /**
     *
     * @param gameMenu the value of gameMenu
     */
    public void swapScreens(GameMenu gameMenu) {
        CardLayout tempLayout = (CardLayout) gameMenu.getParent().getLayout();
        tempLayout.next(gameMenu.getParent());

    }

    /**
     *
     */
    public void resume() {
        swapScreens(gameMenu);
    }

    /**
     * Determines whether the game is over.
     * <p>
     * This method always returns {@code false}, indicating that the game is
     * never over. Override this method in subclasses to implement actual
     * game-over logic.
     * </p>
     *
     * @return {@code false}, indicating the game is not over.
     */
    public boolean isGameOver() {
        return false;
    }

    /**
     *
     * @return
     */
    public ComputerPlayer getOpponentPlayer() {
        return this.opponent;
    }

}
