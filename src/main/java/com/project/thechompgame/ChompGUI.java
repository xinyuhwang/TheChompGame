package com.project.thechompgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChompGUI implements ActionListener {
    JFrame frame;
    JPanel boardPanel;
    JPanel playerPanel;
    JPanel buttonPanel;
    JPanel messagePanel;

    JTextField playerTurnLabel;
    JTextField currentTurnLabel;

    public ChompGUI() {
        frame = new JFrame("Chomp Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 900);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        boardPanel = new JPanel();
        playerPanel = new JPanel();
        buttonPanel = new JPanel();
        messagePanel = new JPanel();

        playerTurnLabel = new JTextField("Player Turn");
        currentTurnLabel = new JTextField();

        boardPanel.setPreferredSize(new Dimension(550, 750));
        playerPanel.setPreferredSize(new Dimension(120, 290));
        playerPanel.setBorder(BorderFactory.createCompoundBorder(
                playerPanel.getBorder(),
                BorderFactory.createEmptyBorder(25, 7, 10, 7)
        ));
        playerTurnLabel.setPreferredSize(new Dimension(95, 95));
        playerTurnLabel.setBorder(BorderFactory.createCompoundBorder(
                playerTurnLabel.getBorder(),
                BorderFactory.createEmptyBorder(5, 6, 5, 6)
        ));
        currentTurnLabel.setPreferredSize(new Dimension(60, 60));

        Color purple = new Color(120, 56, 250);
        Color cyan = new Color(0, 183, 235);
        frame.setBackground(purple);
        boardPanel.setBackground(purple);
        playerPanel.setBackground(purple);
        buttonPanel.setBackground(purple);
        messagePanel.setBackground(purple);
        playerTurnLabel.setBackground(Color.WHITE);
        currentTurnLabel.setBackground(cyan);

        playerPanel.add(playerTurnLabel);
        playerPanel.add(currentTurnLabel);

        frame.add(boardPanel, BorderLayout.WEST);
        frame.add(playerPanel, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(messagePanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ChompGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
