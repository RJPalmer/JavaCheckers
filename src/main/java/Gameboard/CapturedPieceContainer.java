/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author robertpalmer
 */
public class CapturedPieceContainer extends JPanel {
    
    private CapturedPieceDisplay opponentCapturedPieces;
    
    private CapturedPieceDisplay playerCapturedPieces;

    
    public CapturedPieceContainer() {
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        opponentCapturedPieces = new CapturedPieceDisplay();
        opponentCapturedPieces.setBorder(BorderFactory.createLineBorder(Color.RED));
        
        playerCapturedPieces = new CapturedPieceDisplay();
        playerCapturedPieces.setBorder(BorderFactory.createLineBorder(Color.yellow));
        
        add(playerCapturedPieces);
        add(opponentCapturedPieces);
        
//        setLayout(B);
    }
    
    

    /**
     * Get the value of playerCapturedPieces
     *
     * @return the value of playerCapturedPieces
     */
    public CapturedPieceDisplay getPlayerCapturedPieces() {
        return playerCapturedPieces;
    }

    /**
     * Set the value of playerCapturedPieces
     *
     * @param playerCapturedPieces new value of playerCapturedPieces
     */
    public void setPlayerCapturedPieces(CapturedPieceDisplay playerCapturedPieces) {
        this.playerCapturedPieces = playerCapturedPieces;
    }


    /**
     * Get the value of opponentCapturedPieces
     *
     * @return the value of opponentCapturedPieces
     */
    public CapturedPieceDisplay getOpponentCapturedPieces() {
        return opponentCapturedPieces;
    }

    /**
     * Set the value of opponentCapturedPieces
     *
     * @param opponentCapturedPieces new value of opponentCapturedPieces
     */
    public void setOpponentCapturedPieces(CapturedPieceDisplay opponentCapturedPieces) {
        this.opponentCapturedPieces = opponentCapturedPieces;
    }

    public void updatePlayerScore(int capturedPieceCount) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        playerCapturedPieces.setCapturedPieceCount(capturedPieceCount);
    }

    public void updateOpponentScore(int capturedPieceCount) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        opponentCapturedPieces.setCapturedPieceCount(capturedPieceCount);
    }



}
