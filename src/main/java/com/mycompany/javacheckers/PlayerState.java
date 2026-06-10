/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

import Gameboard.BoardSquare;
import Gameboard.GameBoard;
import Gameboard.GameboardMouseListener;
import Gameboard.Piece;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * A State that represents the player's turn
 *
 * @author robertpalmer
 */
public class PlayerState implements State {

    private static final String START = "START";
    private GameBoard gameboard;

    private boolean hasMoved;

    private Player gamePlayer;

    PlayerState(GameBoard gameboard) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        super();
        this.gamePlayer = new Player();
        this.gameboard = gameboard;
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
     */
    public PlayerState() {
        gamePlayer = new Player();
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
            case "Pressed" -> {
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

            case "Dragged" -> {
                if (handleMouseDrag(gameboardMouseListener, e)) {
                    return;
                }
            }

            case "Released" -> {
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
                    gameState.processState(gameState, "YOUR_TURN");
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
     *                               state and mouse events.
     * @param e                      The MouseEvent containing the current mouse
     *                               coordinates.
     *
     * @return {@code true} if there is no selected piece, otherwise
     *         {@code false}.
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
    private void releaseGamePiece(GameboardMouseListener gameboardMouseListener, MouseEvent e) 
    {
        int currentX;
        int currentY;
        Piece existPiece;
        Piece gamePiece = gameboardMouseListener.getGamePiece();
        if (gamePiece != null) 
        {
            currentX = e.getX();
            currentY = e.getY();
            gameboardMouseListener.translateToGrid(currentX, currentY);
            GameBoard board = this.getGameboard();
            int squareX = gameboardMouseListener.getSquareX();
            int squareY = gameboardMouseListener.getSquareY();
            existPiece = board.checkForGamePiece(squareX, squareY);
            boolean nothingThere = Objects.isNull(existPiece);
            //<editor-fold defaultstate="collapsed" desc="old release logic">
//            if (gamePiece.isHasMoved()) {
//                if (Objects.isNull(existPiece)) {
//                    BoardSquare currentSqre = aThis.getBoard().getBoardSquare(aThis.getSquareX(), aThis.getSquareY());
//                    if (currentSqre.getColor() == Color.BLACK) {
//                        GameBoard board = aThis.getBoard();
//                        board.movePiece(gamePiece, aThis.getMoveCopy(), aThis.getSquareX(), aThis.getSquareY());
//                        aThis.setMoveCopy(null);
//                        gamePiece.setHasMoved(false);
//                        
//                        userPlayer.setMoveComplete();
//                        getGameState().processMouseEvent(gameState, aThis, e, RELEASED);
////                    changeState();
//                    } else {
//                        aThis.getBoard().resetPiece(gamePiece, aThis.getMoveCopy());
//                        aThis.setMoveCopy(null);
//                        gamePiece.setHasMoved(false);
//                    }
//                } else {
//                    if (gamePiece.IsMoveable()) {
//                        aThis.getBoard().resetPiece(gamePiece, aThis.getMoveCopy());
//                        aThis.setMoveCopy(null);
//                        gamePiece.setHasMoved(false);
//                    }
//                }
//            }
//</editor-fold>
            if (nothingThere) 
            {
                BoardSquare currentSqre = board.getBoardSquare(squareX, squareY);
                BoardSquare oldSqr;
                BoardSquare boardSquare = board.getBoardSquare(squareX, squareY);
                Piece moveCopy = gameboardMouseListener.getMoveCopy();

                // Get the starting and ending positions
                if (currentSqre.getColor() == Color.BLACK)
                {
                    int oldX = moveCopy.getxCol();
                    int oldY = moveCopy.getyRow();

                    int newX = squareX;
                    int newY = squareY;

                    // Calculate how far the piece moved
                    int deltaX = Math.abs(newX - oldX);
                    int deltaY = Math.abs(newY - oldY);

                    oldSqr = board.getBoardSquare(oldX, oldY);

                    // If it's a jump move (moved two squares in any direction)
                    if (deltaX == 2 && deltaY == 2) 
                    {
                        // Find the middle square (the piece being jumped over)
                        int midX = (oldX + newX) / 2;
                        int midY = (oldY + newY) / 2;

                        BoardSquare middleSquare = board.getBoardSquare(midX, midY);

                        if (middleSquare.isHasPiece()) 
                        {
                            Piece jumpedPiece = middleSquare.getCurrentPiece();

                            // Optionally: Check if it's an opponent's piece before removing
                            if (jumpedPiece != null && jumpedPiece.getPieceColor() != gamePiece.getPieceColor()) 
                            {
                                // Remove the opponent's piece
                                
                                
                                board.clearSquare(middleSquare);
                                
                                List<Piece> pieceIndex = this.gameboard.getPieces();
                                pieceIndex.remove(jumpedPiece);
                                this.getGameboard().setPieces(pieceIndex);
                                // You could also add it to a "captured pieces" list if you want to track
                                System.out.println("Jumped over and removed opponent's piece at: (" + midX + ", " + midY + ")");

                                // Clear the old square
                                board.clearSquare(oldSqr);

                                

                                // Update the piece state
                                gamePiece.isSelected = !gamePiece.isSelected;
                                gamePiece.setHasMoved(!gamePiece.isHasMoved());
                                
                                // Move the piece to the new square
                                board.movePieceToSquare(gamePiece, new Point(newX, newY));
                            }
                        }
                    } 
                    else if (deltaX == 1 && deltaY == 1) 
                    {
                        // Clear the old square
                        board.clearSquare(oldSqr);

                        // Update the piece state
                        gamePiece.isSelected = !gamePiece.isSelected;
                        gamePiece.setHasMoved(!gamePiece.isHasMoved());

                        // Move the piece to the new square
                        board.movePieceToSquare(gamePiece, new Point(newX, newY));
                    } 
                    else 
                    {
                        board.resetPiece(gamePiece, gameboardMouseListener.getMoveCopy());
                        gamePiece.setHasMoved(false);
                    }
                } 
                else 
                {
                    board.resetPiece(gamePiece, gameboardMouseListener.getMoveCopy());
                    gamePiece.setHasMoved(false);
                }

            }
            
            board.repaint();
        }

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
        if ("Paused".equals(command)) {
            gs.setCurrentState(new PausedState());
            gs.processState(gs, "Paused");
        }
        if ("YOUR_TURN".equals(command)) {
            hasMoved = false;
        }
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
