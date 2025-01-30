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

    private boolean moveMade;

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
        this.moveMade = false;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @param gameboard the value of gameboard
     */
    @Override
    public void makeMove(GameBoard gameboard) {

        practiceMove(gameboard);
        //moveMade = !isMoveMade();
//        return moveMade; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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

        //piece that will be moved
        Piece pieceToMove = new Piece();

        //
//        Piece pieceOnceMoved = new Piece();
//        pieceOnceMoved.setPieceColor(pieceToMove.getPieceColor());
//        pieceOnceMoved.setHeight(pieceToMove.getHeight());
        //used to create a random number
        var rand = new Random();
        //identify pieces in the front row
        pieceToMove = selectPieceToMove(temp, rand, pieceToMove, gameboard);

        movePiece(gameboard, pieceToMove, rand);
        gameboard.repaint();

    }

    private void movePiece(GameBoard gameboard, Piece pieceToMove, Random rand) {
        List<Point> pieceOptions;
        //<editor-fold defaultstate="collapsed" desc="move piece one space forward">
        //find out if the piece is blocked
        System.out.println("Preparing to move");
        if (!gameboard.isBlocked(pieceToMove)) {
            //where can the piece move

            //if options are available
            while (!moveMade) {
                pieceOptions = gameboard.moveOptions(pieceToMove);
                if (!pieceOptions.isEmpty()) {
                    System.out.println("Options available");
                    //one option
                    if (pieceOptions.size() == 1) {
                        Point destination = pieceOptions.getFirst();

                        //move the piece
                        //gameboard.movePiece(pieceOnceMoved, pieceToMove, pieceOnceMoved.getxPos(), pieceOnceMoved.getyPos());
                        gameboard.movePieceToSquare(pieceToMove, destination);
                        System.out.printf("Piece moved to (%d, %d)\n", destination.x, destination.y);
                        this.moveMade = true;
                    } //multiple options
                    else {
                        //pick one
                        Point destination = pieceOptions.get(rand.nextInt(pieceOptions.size()));

                        //move the piece
//                    gameboard.movePiece(pieceOnceMoved, pieceToMove, pieceOnceMoved.getxPos(), pieceOnceMoved.getyPos());
                        gameboard.movePieceToSquare(pieceToMove, destination);
                        System.out.printf("Piece moved to (%d, %d)\n", destination.x, destination.y);
                        this.moveMade = true;
                    }
                } else {
System.out.println("Don't have any pieces to move.");
                }
            }
            //move the piece
        } else {
            System.out.println("Unable to move any pieces.");
            System.out.printf("Attempted to move piece (%d, %d)", pieceToMove.getxCol(), pieceToMove.getyRow());
        }
        //</editor-fold>
        //that's it
    }

    /**
     * Selects a piece from the front row based on the player color.
     *
     * @param myColor     The color of the player pieces.
     * @param temp        The player area.
     * @param rand        The random generator for selecting a piece.
     * @param pieceToMove The piece to be moved.
     * @param gameboard   The game board where the game is being played.
     *
     * @return The selected piece from the front row.
     */
    private Piece selectPieceToMove(PlayerArea temp, Random rand, Piece pieceToMove, GameBoard gameboard) {

        System.out.println("Selecting Piece to move");
        //<editor-fold defaultstate="collapsed" desc="(OLD) pick a random piece from the front row">
        /*
         * if (this.piecesCount != 0) {
         *
         * switch (myColor) { case "Red" -> { front_row = temp.getAreaRows()[0];
         * var eligible = Arrays.stream(playerPieces).filter(piece ->
         * piece.getyRow() == front_row).toArray();
         *
         * int randIndex = rand.nextInt((eligible.length - 1) + 1) + 0;
         * pieceToMove = (Piece) eligible[randIndex];
         * gameboard.checkForGamePiece(pieceToMove.getyRow(),
         * pieceToMove.getxCol()); }
         *
         * case "Yellow" -> { front_row =
         * temp.getAreaRows()[temp.getAreaRows().length - 1]; Object[] eligible
         * = Arrays.stream(playerPieces).filter(piece -> piece.getyRow() ==
         * front_row).toArray(); int randIndex = rand.nextInt((eligible.length -
         * 0) + 1) + 0; pieceToMove = (Piece) eligible[randIndex]; } } } return
         * pieceToMove;
         */
//</editor-fold>

        List<Piece> eligiblePieces = new ArrayList<>();
        int[] rows = temp.getAreaRows();

        // Collect all eligible pieces from the player area
        for (int row : rows) {
            eligiblePieces.addAll(Arrays.asList(playerPieces).stream()
                    .filter(piece -> piece.getyRow() == row && !gameboard.isBlocked(piece))
                    .toList());
        }

        // Pick a random piece from the list of eligible pieces
        if (!eligiblePieces.isEmpty()) {
            int randIndex = rand.nextInt(eligiblePieces.size());
            pieceToMove = eligiblePieces.get(randIndex);
        }
        System.out.printf("Selected the piece at (%d, %d)\n", pieceToMove.getxCol(), pieceToMove.getyRow());
        return pieceToMove;
    } 

    /**
     * @return the moveMade
     */
    public boolean isMoveMade() {
        return moveMade;
    }

    /**
     * Sets the value of the moveMade property
     * 
     * @param b the Boolean value to be set
     */
    public void setMoveMade(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this.moveMade = b;
    }

}
