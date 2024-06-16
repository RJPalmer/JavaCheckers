/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Class that handles the 
 * @author robertpalmer
 */
public class GameboardResizeListener implements ComponentListener {
    
    Gameboard.GameBoard gameboard;
    
    @Override
    public void componentResized(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        gameboard = (Gameboard.GameBoard)e.getComponent();
        gameboard.updateSquare();
//        gameboard.setSize(new Dimension(gameboard.getRows() * gameboard.getSquareWidth(), gameboard.getColumns() * gameboard.getSquareWidth()));
       int boardWidth = gameboard.getRows() * gameboard.getSquareWidth();
       int boardHeight = gameboard.getColumns() * gameboard.getSquareWidth();
       gameboard.setSize(boardWidth, boardHeight);
gameboard.revalidate();
        gameboard.repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void componentShown(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
