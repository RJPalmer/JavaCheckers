/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gameboard;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author robertpalmer
 */
public class InstructionFrame extends JFrame {
    
    JPanel basePanel = new JPanel();
    JScrollPane instructionPane;

    public InstructionFrame(String new_Screen) {
        super(new_Screen);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        
        basePanel = new JPanel();
        
        // Add a label to the new frame
        // Instructions text
        String instructions = 
            "<html><body style='font-family:sans-serif;'>" +
            "<h1>Checkers Instructions</h1>" +
            "<h2>Objective:</h2>" +
            "<p>The goal is to capture all of your opponent's pieces or block them so they cannot move.</p>" +
            "<h2>Setup:</h2>" +
            "<ul>" +
            "<li>The game is played on an 8x8 board with alternating dark and light squares.</li>" +
            "<li>Each player starts with 12 pieces on the three rows closest to them, placed on dark squares.</li>" +
            "</ul>" +
            "<h2>Basic Rules:</h2>" +
            "<ul>" +
            "<li><b>Turns:</b> Players take turns; darker pieces move first.</li>" +
            "<li><b>Movement:</b> Pieces move diagonally forward to an empty dark square.</li>" +
            "<li><b>Capturing:</b> Jump over an opponent's piece to capture it. Multiple jumps are mandatory if possible.</li>" +
            "<li><b>Kinging:</b> Reach the opponent's back row to become a king. Kings can move backward and forward diagonally.</li>" +
            "</ul>" +
            "<h2>Winning:</h2>" +
            "<p>Win by capturing all opponent's pieces or blocking them from moving.</p>" +
            "</body></html>";
        JLabel label = new JLabel(instructions);
        
        
        instructionPane = new JScrollPane(label);
        basePanel.add(instructionPane);
//        getContentPane().add(instructionPane);
        getContentPane().add(basePanel);
    }

}
