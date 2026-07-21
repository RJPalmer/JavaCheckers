/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author robertpalmer
 */
public class BoardContainer extends JPanel {

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
        
        setLayout(new GridBagLayout());
        add(getGameBoard());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setBackground(Color.DARK_GRAY);
    }
}
