/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author robertpalmer
 */
public class CapturedPieceDisplay extends JPanel {

    private ImageIcon opponentPieceIcon;
    
    private JLabel capturedPieceLabel;
    
    private int capturedPieceCount;
    
    private int imageIconHeight;
    
        private int imageIconWidth;

    /**
     * Get the value of imageIconWidth
     *
     * @return the value of imageIconWidth
     */
    public int getImageIconWidth() {
        return imageIconWidth;
    }

    /**
     * Set the value of imageIconWidth
     *
     * @param imageIconWidth new value of imageIconWidth
     */
    public void setImageIconWidth(int imageIconWidth) {
        this.imageIconWidth = imageIconWidth;
    }


    /**
     * Get the value of imageIconHeight
     *
     * @return the value of imageIconHeight
     */
    public int getImageIconHeight() {
        return imageIconHeight;
    }

    /**
     * Set the value of imageIconHeight
     *
     * @param imageIconHeight new value of imageIconHeight
     */
    public void setImageIconHeight(int imageIconHeight) {
        this.imageIconHeight = imageIconHeight;
    }


    /**
     * Get the value of capturedPieceCount
     *
     * @return the value of capturedPieceCount
     */
    public int getCapturedPieceCount() {
        return capturedPieceCount;
    }

    /**
     * Set the value of capturedPieceCount
     *
     * @param capturedPieceCount new value of capturedPieceCount
     */
    public void setCapturedPieceCount(int capturedPieceCount) {
        this.capturedPieceCount = capturedPieceCount;
    }


    /**
     * Get the value of capturedPieceLabel
     *
     * @return the value of capturedPieceLabel
     */
    public JLabel getCapturedPieceLabel() {
        return capturedPieceLabel;
    }

    /**
     * Set the value of capturedPieceLabel
     *
     * @param capturedPieceLabel new value of capturedPieceLabel
     */
    public void setCapturedPieceLabel(JLabel capturedPieceLabel) {
        this.capturedPieceLabel = capturedPieceLabel;
    }


    /**
     * Get the value of opponentPieceIcon
     *
     * @return the value of opponentPieceIcon
     */
    public ImageIcon getOpponentPieceIcon() {
        return opponentPieceIcon;
    }

    /**
     * Set the value of opponentPieceIcon
     *
     * @param opponentPieceIcon new value of opponentPieceIcon
     */
    public void setOpponentPieceIcon(ImageIcon opponentPieceIcon) {
        this.opponentPieceIcon = opponentPieceIcon;
    }

    public CapturedPieceDisplay() {
        opponentPieceIcon = createPieceIcon(getGraphics());
        capturedPieceCount = 0;
        capturedPieceLabel = new JLabel("x " + capturedPieceCount);
        capturedPieceLabel.setFont(new Font("Serif", Font.BOLD, 14));
        capturedPieceLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        capturedPieceLabel.setIcon(opponentPieceIcon);
        
        add(capturedPieceLabel);
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        ImageIcon pieceImageIcon = createPieceIcon(g2d);
        
        setOpponentPieceIcon(pieceImageIcon);
        
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        
        
    }
    
    private ImageIcon createPieceIcon(Graphics graphics){
        //BufferedImage image = new BufferedImage(WIDTH, HEIGHT, HEIGHT)
        

        return new ImageIcon();
    }
}
