package com.project.thechompgame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChompGUI implements ActionListener {
    JFrame frame;
    JPanel boardPanel;
    JPanel playerPanel;
    JPanel buttonAndMessagePanel;
    JPanel buttonPanel;
    JPanel messagePanel;
    JPanel resetMessagePanel;

    JTextField playerTurnLabel;
    JTextField currentTurnLabel;
    JTextField messageLabel;
    JTextField resetGameMessageLabel;

    JButton resetButton;

    public ChompGUI() {
        frame = new JFrame("Chomp Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 900);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Initialize panels
        boardPanel = new JPanel();
        playerPanel = new JPanel();
        buttonAndMessagePanel = new JPanel();
        buttonPanel = new JPanel();
        messagePanel = new JPanel();
        resetMessagePanel = new JPanel();

        // Initialize player turn labels
        playerTurnLabel = new JTextField("Player Turn");
        playerTurnLabel.setEditable(false);
        currentTurnLabel = new JTextField();
        currentTurnLabel.setEditable(false);

        // Initialize the reset button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        messageLabel = new JTextField("Welcome to CHOMP GAME");
        messageLabel.setEditable(false);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 22));
        resetGameMessageLabel = new JTextField("Click Reset to Restart the Game");
        resetGameMessageLabel.setEditable(false);
        resetGameMessageLabel.setFont(new Font("Arial", Font.BOLD, 22));
        resetGameMessageLabel.setVisible(false);

        // Set the size for panels and other function units
        boardPanel.setPreferredSize(new Dimension(580, 680));
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
        buttonAndMessagePanel.setPreferredSize(new Dimension(400, 220));
        buttonPanel.setPreferredSize(new Dimension(680, 90));

        resetButton.setPreferredSize(new Dimension(100, 63));
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                buttonPanel.getBorder(),
                BorderFactory.createEmptyBorder(5, 6, 5, 500)
        ));

        messageLabel.setPreferredSize(new Dimension(300, 30));
        messageLabel.setBorder(new EmptyBorder(5, 5, 5, 10));
        resetGameMessageLabel.setPreferredSize(new Dimension(347, 30));
        resetMessagePanel.setPreferredSize(new Dimension(500, 60));
        resetMessagePanel.setBorder(new EmptyBorder(15, 7, 5, 7));

        // Set background colors
        Color purple = new Color(115, 56, 250);
        Color cyan = new Color(0, 183, 235);
        frame.setBackground(purple);
        boardPanel.setBackground(purple);
        playerPanel.setBackground(purple);
        buttonAndMessagePanel.setBackground(purple);
        buttonPanel.setBackground(purple);
        playerTurnLabel.setBackground(Color.WHITE);
        currentTurnLabel.setBackground(cyan);
        messageLabel.setBackground(Color.ORANGE);
        resetGameMessageLabel.setBackground(Color.ORANGE);
        resetMessagePanel.setBackground(purple);

        // Add elements to panels
        playerPanel.add(playerTurnLabel);
        playerPanel.add(currentTurnLabel);
        buttonPanel.add(resetButton);
        buttonAndMessagePanel.add(buttonPanel, BorderLayout.WEST);
        buttonAndMessagePanel.add(messageLabel, BorderLayout.CENTER);
        resetMessagePanel.add(resetGameMessageLabel);
        buttonAndMessagePanel.add(resetMessagePanel, BorderLayout.SOUTH);

        // Add panels to the frame
        frame.add(boardPanel, BorderLayout.WEST);
        frame.add(playerPanel, BorderLayout.EAST);
        frame.add(buttonAndMessagePanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ChompGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
