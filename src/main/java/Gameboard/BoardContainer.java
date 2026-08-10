/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import com.mycompany.javacheckers.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author robertpalmer
 */
public class BoardContainer extends JPanel {


    private CapturedPieceContainer capturePiecesPanel;

    private com.mycompany.javacheckers.Game gameConnection;

    @Override
    protected void paintComponent(Graphics g) {
        updatePlayerScores(gameConnection);
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    /**
     * Get the value of gameConnection
     *
     * @return the value of gameConnection
     */
    public com.mycompany.javacheckers.Game getGameConnection() {
        return gameConnection;
    }

    /**
     * Set the value of gameConnection
     *
     * @param gameConnection new value of gameConnection
     */
    public void setGameConnection(com.mycompany.javacheckers.Game gameConnection) {
        this.gameConnection = gameConnection;
    }

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

    public BoardContainer(GameBoard board) {
        this.gameBoard = board;
        initializeLayout();
    }

    /**
     *
     * @param gameConnection
     */
    public BoardContainer(Game gameConnection) {
        this.gameConnection = gameConnection;
        this.gameBoard = gameConnection.gameboard;
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

    public List<Piece> getPlayerCapturedPieces() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param gameConnection
     */
    private void updatePlayerScores(Game gameConnection) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        capturePiecesPanel.updatePlayerScore(gameConnection.getPlayerCapturedPiecesCount());
        capturePiecesPanel.updateOpponentScore(gameConnection.getOpponentCapturedPieceCount());
    }
}
