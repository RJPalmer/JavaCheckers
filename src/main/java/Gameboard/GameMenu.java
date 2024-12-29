/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import com.mycompany.javacheckers.Game;
import com.mycompany.javacheckers.GameStateContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * A JPanel that displays the main menu
 *
 * @author robertpalmer
 */
public class GameMenu extends JPanel {

    /**
     * @return the obj
     */
    public com.mycompany.javacheckers.Game getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(com.mycompany.javacheckers.Game obj) {
        this.obj = obj;
    }

    private com.mycompany.javacheckers.Game obj;

    private JPanel parent;

    private CardLayout cl;

    private boolean isNext_bool = false;

    /**
     *
     * @param obj
     */
    public GameMenu(com.mycompany.javacheckers.Game obj) {
        // Set up the panel
        setLayout(new GridLayout(3, 1, 10, 10)); // 2 rows, 1 column with spacing
        this.setBackground(Color.red);
        // Create buttons
        JButton viewInstruction = new JButton("View Instructions");
        JButton startGameButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");

        // Add action listeners for buttons
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameStateContext gameState = obj.getGameState();

//                swapToMenu();
                gameState.processState(gameState, "START");
            }
        });

        viewInstruction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                System.out.println("Viewing Game Instructions");

                // Create a new frame for the new screen
                InstructionFrame view = new InstructionFrame("Game instructions");

                // Make the new frame visible
                view.setVisible(true);
            }

        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action for exiting the game
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Add buttons to the panel
        add(startGameButton);
        add(viewInstruction);
        add(exitButton);

        // Optional: Add a border for visual appeal
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.obj = obj;
    }

    /**
     *
     * @deprecated Moved to {@link com.mycompany.javacheckers.Game#swapToMenu}
     */
    @Deprecated
    private void swapToMenu() {
        obj.swapScreens(this);
    }

    /**
     *
     * @param cards
     */
    public void setParent(JPanel cards) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        parent = cards;
    }

    /**
     *
     * @param cardLayout
     */
    public void setCardLayout(CardLayout cardLayout) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        cl = cardLayout;
    }

    /**
     *
     * @param b
     */
    public void setIsNext(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        isNext_bool = b;
    }
}
