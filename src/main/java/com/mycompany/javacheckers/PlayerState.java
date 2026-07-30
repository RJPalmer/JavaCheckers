/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

import Gameboard.BoardContainer;
import Gameboard.BoardSquare;
import Gameboard.GameBoard;
import Gameboard.GameboardMouseListener;
import Gameboard.Piece;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;

/**
 * A State that represents the player's turn
 *
 * @author robertpalmer
 */
public class PlayerState implements State {

    private Game currentGame;

    /**
     * Get the value of currentGame
     *
     * @return the value of currentGame
     */
    public Game getCurrentGame() {
        return currentGame;
    }

    /**
     * Set the value of currentGame
     *
     * @param currentGame new value of currentGame
     */
    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    private List<Piece> capturedPieces = null;

    /**
     * Get the value of capturedPieces
     *
     * @return the value of capturedPieces
     */
    public List<Piece> getCapturedPieces() {
        return boardContainer.getPlayerCapturedPieces();
    }

    /**
     * Get the number of captured
     *
     * @return the size of capturedPieces
     */
    public int getCapturedPieceCount() {
        return currentGame.getPlayerCapturedPiecesCount();
    }
    private static final String START = "START";
    private static final String YOUR_TURN = "YOUR_TURN";
    private static final String PAUSED = "Paused";
    private static final String RELEASED = "Released";
    private static final String DRAGGED = "Dragged";
    private static final String PRESSED = "Pressed";
    private GameBoard gameboard;
    private BoardContainer boardContainer;

    private boolean hasMoved;

    private Player gamePlayer;

    PlayerState(GameBoard gameboard) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        super();
        this.gamePlayer = new Player();
        this.gameboard = gameboard;
        this.boardContainer = null;
        this.currentGame = null;
    }

    PlayerState(BoardContainer bc) {
        super();
        this.gamePlayer = new Player();
        this.boardContainer = bc;
        this.gameboard = bc.getGameBoard();
        this.capturedPieces = bc.getPlayerCapturedPieces();
        this.currentGame = null;
    }

    /**
     * adds piece to the captured list
     * 
     * @param capturedPiece
     */
    public void addCapturedPiece(Piece capturedPiece) {
        if (capturedPiece != null) {
            currentGame.getPlayerCapturedPieceList().add(capturedPiece);
        }
    }

    public PlayerState(Game currentGame) {
        super();
        this.currentGame = currentGame;
        this.gamePlayer = currentGame.getUserPlayer();
        this.boardContainer = currentGame.getBoardContainer();
        this.gameboard = boardContainer.getGameBoard();
    }

    /**
     *
     */
    public PlayerState() {
        gamePlayer = new Player();
        this.currentGame = null;
    }

    /**
     * Get the value of gamePlayer
     *
     * @return the value of gamePlayer
     */
    public Player getGamePlayer() {
        return gamePlayer;
    }

    /**
     * Set the value of gamePlayer
     *
     * @param gamePlayer new value of gamePlayer
     */
    public void setGamePlayer(Player gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    /**
     *
     * @param gs
     */
    @Override
    public void changeState(com.mycompany.javacheckers.GameStateContext gs) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    /**
     *
     * @return
     */
    @Override
    public String getState() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return "Player State";
    }

    /**
     *
     * @param gameState
     * @param gameboardMouseListener
     * @param e
     * @param pressed
     */
    @Override
    public void handleMouseRequest(GameStateContext gameState, GameboardMouseListener gameboardMouseListener, MouseEvent e, String pressed) {
        switch (pressed) {
            case PRESSED -> {
                MouseEvent eMouseEvent;
                eMouseEvent = e;

                int eMouseEventX = eMouseEvent.getX();
                int eMouseEventY = eMouseEvent.getY();
                int squareX;
                int squareY;

                gameboardMouseListener.setMouseX(eMouseEventX);
                gameboardMouseListener.setMouseY(eMouseEventY);

                //translate mouse screen coordinates into rows/colum
                gameboardMouseListener.translateToGrid(eMouseEventX, eMouseEventY);

                squareX = gameboardMouseListener.getSquareX();
                squareY = gameboardMouseListener.getSquareY();
                //Getting current mouse screen coordinates

                GameBoard board = getGameboard();
                Piece checkForGamePiece = board.checkForGamePiece(squareX, squareY);
                //Piece gamePiece;

                if (Objects.nonNull(checkForGamePiece)) {
                    //check the board to see if there's a piece there
                    gameboardMouseListener.setGamePiece(checkForGamePiece);
                    gameboardMouseListener.selectPiece();
                }
                //        var object = board.getPieces(); new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            case DRAGGED -> {
                if (handleMouseDrag(gameboardMouseListener, e)) {
                }
            }

            case RELEASED -> {
//                releaseGamePiece_deprecated(gameboardMouseListener, e);
                releaseGamePiece(gameboardMouseListener, e);
                Piece gamePiece = gameboardMouseListener.getGamePiece();
                boolean hasMoved1 = gamePiece.isHasMoved();

                if (hasMoved1) {
                    Player userPlayer = gameState.getCheckersGame().getUserPlayer();
                    gamePiece.setHasMoved(!hasMoved);
                    //userPlayer.isTurnComplete = true;
                    gameState.getCheckersGame().gameboard = getGameboard();
                    OpponentState opponentPlayer = new OpponentState(gameState.getCheckersGame().getOpponentPlayer(), getGameboard());

                    userPlayer.setMoveComplete();
                    gameState.setCurrentState(opponentPlayer);
                    gameState.processState(gameState, YOUR_TURN);
                }

            }
            default ->
                throw new AssertionError();
        }
    }

    /**
     * Handles the mouse drag event for moving a selected game piece on the
     * board.
     * <p>
     * <p>
     * This method updates the position of a selected game piece based on the
     * mouse movement. It calculates the change in position, updates the piece's
     * coordinates, and marks it as moved if the movement exceeds a square's
     * width. The method also updates the mouse position and repaints the game
     * board.</p>
     *
     * @param gameboardMouseListener The listener that tracks the game board
     * state and mouse events.
     * @param e The MouseEvent containing the current mouse coordinates.
     *
     * @return {@code true} if there is no selected piece, otherwise
     * {@code false}.
     */
    private boolean handleMouseDrag(GameboardMouseListener gameboardMouseListener, MouseEvent e) {
        int gamePieceX;
        int gamePieceY;

        // Ensure there is a selected piece
        gameboardMouseListener.savePieceState();
        Piece selectedGamePiece = gameboardMouseListener.getGamePiece();
        Piece originState = new Piece();

        originState.setxPos(gameboardMouseListener.getSavedPieceX());
        originState.setyPos(gameboardMouseListener.getSavedPieceY());

        GameBoard board = getGameboard();
        if (!selectedGamePiece.isSelected) {
            return true; // Exit early to avoid unnecessary processing
        }
        // Get current mouse position
        int newMouseX = e.getX();
        int newMouseY = e.getY();
        int prevMouseX = gameboardMouseListener.getMouseX();
        int prevMouseY = gameboardMouseListener.getMouseY();
        // Calculate movement change
        int changeX = (prevMouseX != 0) ? newMouseX - prevMouseX : 0;
        int changeY = (prevMouseY != 0) ? newMouseY - prevMouseY : 0;
//        int originX = originState.getxPos();
//        int originY = originState.getyPos();
//        int originChngeX;
//        int originChngeY;

        // Update mouse position
        gameboardMouseListener.setMouseX(newMouseX);
        gameboardMouseListener.setMouseY(newMouseY);

        // Translate screen coordinates to grid position
        gameboardMouseListener.translateToGrid(newMouseX, newMouseY);

        gamePieceX = selectedGamePiece.getxPos();
        gamePieceY = selectedGamePiece.getyPos();

        // Move the selected piece
        selectedGamePiece.setxPos(gamePieceX + changeX);
        selectedGamePiece.setyPos(gamePieceY + changeY);

        int squareX = gameboardMouseListener.getSquareX();
        int squareY = gameboardMouseListener.getSquareY();

        gamePieceX = selectedGamePiece.getxPos();
        gamePieceY = selectedGamePiece.getyPos();

//        originChngeX = gamePieceX - originX;
//        originChngeY = gamePieceY - originY;
        // Mark piece as moved if it moves beyond a square's width
        if (Math.abs(changeX) > board.getSquareWidth() || Math.abs(changeY) > board.getSquareWidth()) {
            selectedGamePiece.setHasMoved(true);

            //check if there's a piece at this location
            Piece checkForGamePiece = board.checkForGamePiece(squareX, squareY);
            Player gamePlayer1 = this.getGamePlayer();
            if (!Objects.isNull(checkForGamePiece) && !gamePlayer1.checkPiece(checkForGamePiece)) {
                System.out.println("Passing over enemy piece");
            }
        }
        // Prepare the move copy and repaint the board
        gameboardMouseListener.prepMoveCopy();
        gameboardMouseListener.getBoard().repaint();
        return false;
    }

    /*
     * 
     */

    /**
     * Handles the release of a dragged game piece.
     * <p>
     * When a piece is released, this method:
     * <ul>
     * <li>Determines the target board square.</li>
     * <li>Validates the move.</li>
     * <li>Performs a normal move or capture move.</li>
     * <li>Removes captured pieces from the board.</li>
     * <li>Resets invalid moves.</li>
     * </ul>
     *
     * @param gameboardMouseListener Mouse listener containing drag state
     * information.
     * @param e Mouse release event.
     */
    private void releaseGamePiece(GameboardMouseListener gameboardMouseListener, MouseEvent e) {

        Piece gamePiece = gameboardMouseListener.getGamePiece();

        if (gamePiece == null) {
            return;
        }

        GameBoard board = getGameboard();

        // Determine the destination square
        gameboardMouseListener.translateToGrid(e.getX(), e.getY());

        int newX = gameboardMouseListener.getSquareX();
        int newY = gameboardMouseListener.getSquareY();

        Piece occupyingPiece = board.checkForGamePiece(newX, newY);

        // Cannot move onto an occupied square
        if (occupyingPiece != null) {
            resetMove(board, gamePiece, gameboardMouseListener);
            board.repaint();
            return;
        }

        BoardSquare destinationSquare = board.getBoardSquare(newX, newY);

        // Pieces may only occupy black squares
        if (destinationSquare.getColor() != Color.BLACK) {
            resetMove(board, gamePiece, gameboardMouseListener);
            board.repaint();
            return;
        }

        Piece moveCopy = gameboardMouseListener.getMoveCopy();

        int oldX = moveCopy.getxCol();
        int oldY = moveCopy.getyRow();

        int deltaX = Math.abs(newX - oldX);
        int deltaY = Math.abs(newY - oldY);

        BoardSquare oldSquare = board.getBoardSquare(oldX, oldY);
        boolean forwardMove = isForwardMove(gamePiece, oldY, newY);

        // Handle capture move
        if (forwardMove) {
            if (deltaX == 2 && deltaY == 2) {

                int midX = (oldX + newX) / 2;
                int midY = (oldY + newY) / 2;

                BoardSquare middleSquare = board.getBoardSquare(midX, midY);
                Piece jumpedPiece = middleSquare.getCurrentPiece();

                boolean validCapture
                        = jumpedPiece != null
                        && jumpedPiece.getPieceColor() != gamePiece.getPieceColor();

                if (!validCapture) {
                    resetMove(board, gamePiece, gameboardMouseListener);
                    board.repaint();
                    return;
                }

                // Remove captured piece
                addCapturedPiece(jumpedPiece);
                board.clearSquare(middleSquare);

                List<Piece> pieces = board.getPieces();
                pieces.remove(jumpedPiece);
                board.setPieces(pieces);

                completeMove(
                        board,
                        gamePiece,
                        oldSquare,
                        newX,
                        newY,
                        gameboardMouseListener
                );

            } // Handle normal move
            else if (deltaX == 1 && deltaY == 1) {

                completeMove(
                        board,
                        gamePiece,
                        oldSquare,
                        newX,
                        newY,
                        gameboardMouseListener
                );

            } // Invalid move
            else {

                resetMove(board, gamePiece, gameboardMouseListener);

            }
        } else {
            resetMove(board, gamePiece, gameboardMouseListener);
        }
        currentGame.updateScores();
        boardContainer.repaint();
    }

    /**
     * Completes a valid move by updating the board and piece state.
     *
     * @param board The game board.
     * @param piece The piece being moved.
     * @param oldSquare The square the piece moved from.
     * @param newX Destination column.
     * @param newY Destination row.
     * @param listener Mouse listener maintaining move state.
     */
    private void completeMove(
            GameBoard board,
            Piece piece,
            BoardSquare oldSquare,
            int newX,
            int newY,
            GameboardMouseListener listener) {

        board.clearSquare(oldSquare);

        piece.setHasMoved(true);

        // Use setter if available
        piece.isSelected = false;

        board.movePieceToSquare(piece, new Point(newX, newY));

        listener.setMoveCopy(null);
    }

    /**
     * Restores a piece to its original location after an invalid move.
     *
     * @param board The game board.
     * @param piece The piece being reset.
     * @param listener Mouse listener maintaining move state.
     */
    private void resetMove(
            GameBoard board,
            Piece piece,
            GameboardMouseListener listener) {

        board.resetPiece(piece, listener.getMoveCopy());

        piece.setHasMoved(false);

        // Use setter if available
        piece.isSelected = false;

        listener.setMoveCopy(null);
    }

    /**
     *
     * @param gs
     * @param command
     */
    @Override
    public void handleRequest(com.mycompany.javacheckers.GameStateContext gs, java.lang.String command) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        System.out.println("It''s the player's turn");
//        if(START.equals(command)){
//            gs.processState(gs, "Paused");
//            
//        }
        if (PAUSED.equals(command)) {
            gs.setCurrentState(new PausedState());
            gs.processState(gs, PAUSED);
        }
        if (YOUR_TURN.equals(command)) {
            hasMoved = false;
        }
    }

    /**
     * Determines whether a move is in the correct forward direction for the
     * piece.
     * <p>
     * Regular pieces may only move forward by one row (normal move) or two rows
     * (capture). King pieces may move in either direction.
     *
     * @param piece The piece being moved.
     * @param oldY The starting row.
     * @param newY The destination row.
     * @return {@code true} if the move is in a legal forward direction;
     * {@code false} otherwise.
     */
    private boolean isForwardMove(Piece piece, int oldY, int newY) {

        int rowChange = newY - oldY;

        // King pieces may move in either direction.
        if (piece instanceof KingPiece) {
            return Math.abs(rowChange) == 1 || Math.abs(rowChange) == 2;
        }

        // Black pieces move toward increasing row numbers.
        if (piece.getPieceColor() == Color.YELLOW) {
            return rowChange == 1 || rowChange == 2;
        }

        // Red pieces move toward decreasing row numbers.
        return rowChange == -1 || rowChange == -2;
    }

    /**
     * Get the value of hasMoved
     *
     * @return the value of hasMoved
     */
    public boolean isHasMoved() {
        return hasMoved;
    }

    /**
     * Set the value of hasMoved
     *
     * @param hasMoved new value of hasMoved
     */
    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    /**
     *
     * @param gameState
     */
    @Override
    public void switchToPause(GameStateContext gameState) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    /**
     * @return the gameboard
     */
    public GameBoard getGameboard() {
        return gameboard;
    }

    /**
     * @param gameboard the gameboard to set
     */
    public void setGameboard(GameBoard gameboard) {
        this.gameboard = gameboard;
    }

}
