package com.mycompany.javacheckers;

import Gameboard.GameBoard;
import Gameboard.Move;
import Gameboard.Piece;

/**
 *
 * @author robertpalmer
 */
public class Player {

        public PlayerArea pieceArea;

    /**
     * Get the value of pieceArea
     *
     * @return the value of pieceArea
     */
    public PlayerArea getPieceArea() {
        return pieceArea;
    }

    /**
     * Set the value of pieceArea
     *
     * @param pieceArea new value of pieceArea
     */
    public void setPieceArea(PlayerArea pieceArea) {
        this.pieceArea = pieceArea;
    }

    public Player(PlayerArea pieceArea, int piecesCount, Piece[] playerPieces, String playerColor, boolean isUserPlayer, boolean isTurnComplete) {
        this.pieceArea = pieceArea;
        this.piecesCount = piecesCount;
        this.playerPieces = playerPieces;
        this.playerColor = playerColor;
        this.isUserPlayer = isUserPlayer;
        this.isTurnComplete = isTurnComplete;
    }

    
    /**
     * The number of the pieces that the player has
     */
    public int piecesCount;

    /**
     * The pieces that belong to the player
     */
    public Piece[] playerPieces;    

    /**
     * The piece color associated with the player
     */
    public String playerColor;
    
    /**
     * Determines if the player is controlled by the user
     */
    public boolean isUserPlayer;
    
    /**
     * Determines if the player has completed their turn.
     */
    public boolean isTurnComplete;
    
    /**
     * Empty Constructor
     */
    public Player() {
        isTurnComplete = false;
    }

    /**
     * 
     * @param piecesCount
     * @param playerPieces
     * @param playerColor 
     */
    public Player(int piecesCount, Piece[] playerPieces, String playerColor) {
        this.piecesCount = piecesCount;
        this.playerPieces = playerPieces;
        this.playerColor = playerColor;
      
        isTurnComplete = false;
    }

    /**
     * 
     * @param pieceArea
     * @param piecesCount
     * @param playerPieces
     * @param playerColor 
     */
    public Player(PlayerArea pieceArea, int piecesCount, Piece[] playerPieces, String playerColor) {
        this.pieceArea = pieceArea;
        this.piecesCount = piecesCount;
        this.playerPieces = playerPieces;
        this.playerColor = playerColor;
    }

    
    /**
     *
     * @param piece
     */
    public void movePiece (Piece piece) {
    }

    /**
     *
     */
    public void kingPiece () {
    }

    /**
     * @return the playerColor
     */
    public String getPlayerColor() {
        return playerColor;
    }

    /**
     * @param playerColor the playerColor to set
     */
    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    /**
     * @return the piecesCount
     */
    public int getPiecesCount() {
        return piecesCount;
    }

    /**
     * @param piecesCount the piecesCount to set
     */
    public void setPiecesCount(int piecesCount) {
        this.piecesCount = piecesCount;
    }

    /**
     *
     *
     * @param gameboardMouseListener
     * @param gameBoard
     * @return
     */
    public Move[] checkForMoves(Piece gameboardMouseListener, GameBoard gameBoard) {
        //        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Move[] availableMoves = null;
//        if (gameBoard.isBlocked(gameboardMouseListener)) {
//        }
        return availableMoves;
    }

    /**
     * @param gameboard the value of gameboard
     * @return the boolean 
     */
    public boolean makeMove(GameBoard gameboard) {
        
        boolean moveMade = false;
        //can the player make a move
        if(piecesCount != 0){
                //if this player is controlled by the user
            if(isUserPlayer){
                //piece movement is handled by the mouselistener
                //move is considered made when 
                while(!isTurnComplete){
                }
                moveMade = true;
            }
            else{

            }
        }
        return moveMade;
    }

    /**
     *
     */
    public void setMoveComplete() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        isTurnComplete = !isTurnComplete;
    }


}

