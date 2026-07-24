/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author robertpalmer
 */
public class BoardContainer extends JPanel {

    private CapturedPieceContainer capturePiecesPanel;

    /**
     * Get the value of capturePiecesPanel
     *
     * @return the value of capturePiecesPanel
     */
    public CapturedPieceContainer getCapturePiecesPanel() {
        return capturePiecesPanel;
    }

    /**
     * Set the value of capturePiecesPanel
     *
     * @param capturePiecesPanel new value of capturePiecesPanel
     */
    public void setCapturePiecesPanel(CapturedPieceContainer capturePiecesPanel) {
        this.capturePiecesPanel = capturePiecesPanel;
    }

    /**
     * @return the gameBoard
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * @param gameBoard the gameBoard to set
     */
    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }
    private GameBoard gameBoard;
    private static final int MARGIN = 20;
    
     public BoardContainer(GameBoard board){
        this.gameBoard = board;
        initializeLayout();
    }

    private void initializeLayout() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        capturePiecesPanel = new CapturedPieceContainer();
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(getGameBoard(), gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(capturePiecesPanel, gridBagConstraints);
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(Color.DARK_GRAY);
    }
}
