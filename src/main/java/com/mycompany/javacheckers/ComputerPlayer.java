/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javacheckers;

import Gameboard.BoardSquare;
import Gameboard.GameBoard;
import Gameboard.Piece;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A Player Controlled by the application
 *
 * @author robertpalmer
 */
public class ComputerPlayer extends Player {

    /**
     *
     * @param pieceArea
     * @param piecesCount
     * @param playerPieces
     * @param playerColor
     */
    public ComputerPlayer(PlayerArea pieceArea, int piecesCount, Piece[] playerPieces, String playerColor) {
        super(pieceArea, piecesCount, playerPieces, playerColor);
    }

    /**
     *
     * @param PLAYER_PIECE_COUNT
     * @param object
     * @param yellow
     */
    ComputerPlayer(int PLAYER_PIECE_COUNT, Piece[] object, String yellow) {
        super(PLAYER_PIECE_COUNT, object, yellow);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @param gameboard the value of gameboard
     * @return the boolean
     */
    @Override
    public boolean makeMove(GameBoard gameboard) {
        boolean moveMade = false;
        practiceMove(gameboard);
        moveMade = !moveMade;
        return moveMade; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * Simulate an automatic move made by the computer
     *
     * @param gameboard
     */
    private void practiceMove(GameBoard gameboard) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        String myColor = this.getPlayerColor();
        //identify player area
        PlayerArea temp = this.getPieceArea();
        //identify the front row
        int front_row;
        Piece pieceToMove = new Piece();
        Piece pieceOnceMoved = new Piece();
        
        pieceOnceMoved.setPieceColor(pieceToMove.getPieceColor());
        pieceOnceMoved.setHeight(pieceToMove.getHeight());
        List<Point> pieceOptions = new ArrayList<>();
        var rand = new Random();
        //identify pieces in the front row

        //<editor-fold defaultstate="collapsed" desc="pick a random piece">
        if (this.piecesCount != 0) {

            switch (myColor) {
                case "Red" -> {
                    front_row = temp.getAreaRows()[0];
                    var eligible = Arrays.stream(playerPieces).filter(piece -> piece.getyRow() == front_row).toArray();

                    int randIndex = rand.nextInt((eligible.length - 1) + 1) + 0;
                    pieceToMove = (Piece) eligible[randIndex];
                    gameboard.checkForGamePiece(pieceToMove.getyRow(), pieceToMove.getxCol());
                }

                case "Yellow" -> {
                    front_row = temp.getAreaRows()[temp.getAreaRows().length - 1];
                    Object[] eligible = Arrays.stream(playerPieces).filter(piece -> piece.getyRow() == front_row).toArray();
                    int randIndex = rand.nextInt((eligible.length - 0) + 1) + 0;
                    pieceToMove = (Piece) eligible[randIndex];
                }
            }
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="move piece one space forward">
        //find out if the piece is blocked
        if (!gameboard.isBlocked(pieceToMove)) {
            //where can the piece move
            pieceOptions = gameboard.moveOptions(pieceToMove);
            //if options are available
            if (!pieceOptions.isEmpty()) {
                //one option 
               if (pieceOptions.size() == 1) {
                    Point destination = pieceOptions.getFirst();
                    
                    //move the piece
                    //gameboard.movePiece(pieceOnceMoved, pieceToMove, pieceOnceMoved.getxPos(), pieceOnceMoved.getyPos());
                    gameboard.movePieceToSquare(pieceToMove, destination);
                } //multiple options
                else {
                    //pick one
                    Point destination = pieceOptions.get(rand.nextInt(pieceOptions.size()));

                    //move the piece
//                    gameboard.movePiece(pieceOnceMoved, pieceToMove, pieceOnceMoved.getxPos(), pieceOnceMoved.getyPos());
                    gameboard.movePieceToSquare(pieceToMove, destination);
                }
            }

            //move the piece
        } else {

        }
        //</editor-fold>
        //that's it
    }

}
