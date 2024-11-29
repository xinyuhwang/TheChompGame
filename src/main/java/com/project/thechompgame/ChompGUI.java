package com.project.thechompgame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Objects;

/**
 * @author Xinyu Wang
 * @version 10/20/2024
 * The {@code ChompGUI} class implements .
 * <p>
 *     This ChompGUI class contains the methods to:
 *
 * </p>
 */
public class ChompGUI implements MouseListener, Observer{
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
    boolean isPlayer1Turn = true;

    JButton resetButton;

    Board board;
    JButton[][] tileButtons;

    Player p1;
    Player p2;

    public ChompGUI(Board board, Player player1, Player player2, GameController gameController) {
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
        currentTurnLabel = new JTextField(player1.getName());
        currentTurnLabel.setEditable(false);
        currentTurnLabel.setHorizontalAlignment(JTextField.CENTER);

        // Initialize message labels
        messageLabel = new JTextField("Welcome to CHOMP GAME");
        messageLabel.setEditable(false);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 22));

        // Initialize reset message label
        resetGameMessageLabel = new JTextField("Click Reset to Restart the Game");
        resetGameMessageLabel.setEditable(false);
        resetGameMessageLabel.setPreferredSize(new Dimension(347, 30));
        resetGameMessageLabel.setFont(new Font("Arial", Font.BOLD, 22));

        resetGameMessageLabel.setVisible(true);

        // initialize the game board
        this.board = board;
        board.attach(this);
        int rows = board.fetchBoardStatus().length;
        int cols = board.fetchBoardStatus()[0].length;
        tileButtons = new JButton[rows][cols];

        Color brown = new Color(155, 95, 55);
        Color papayaWhip = new Color(255, 239, 213);
        Color purple = new Color(115, 56, 250);
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                tileButtons[row][col] = new JButton();
                tileButtons[row][col].setPreferredSize(new Dimension(7, 7));
                if (row == rows - 1 && col == 0) {
                    tileButtons[row][col].setBackground(brown);
                    tileButtons[row][col].setOpaque(true);
                } else {
                    tileButtons[row][col].setBackground(papayaWhip);
                    tileButtons[row][col].setOpaque(true);
                }
                tileButtons[row][col].setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(purple, 2),
                        BorderFactory.createLineBorder(purple, 2)
                ));
                int r = row, c = col;
                tileButtons[row][col].addActionListener(_ -> {
                    isPlayer1Turn = !isPlayer1Turn;
                    currentTurnLabel.setText(isPlayer1Turn ? player1.getName() : player2.getName());
                    if (r == rows - 1 && c == 0) {
                        board.updateBoard(r, c);
                        String winner = isPlayer1Turn ? player1.getName() : player2.getName();
                        messageLabel.setText("Game Over!!! " + winner + " Wins");
                        resetGameMessageLabel.setBackground(Color.ORANGE);
                        resetGameMessageLabel.setForeground(Color.black);
                    } else {
                        board.updateBoard(r, c);
                    }
                });
                boardPanel.add(tileButtons[row][col]);
            }
        }
        boardPanel.setLayout(new GridLayout(rows, cols));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        boardPanel.setBackground(purple);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        tileButtons[0][0].setForeground(brown);

        this.p1 = player1;
        this.p2 = player2;

        // Initialize the reset button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetGame());

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

        // set size for reset button
        resetButton.setPreferredSize(new Dimension(100, 63));
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                buttonPanel.getBorder(),
                BorderFactory.createEmptyBorder(5, 6, 5, 500)
        ));
        resetButton.setBackground(Color.orange);

        // set size for labels
        messageLabel.setPreferredSize(new Dimension(300, 30));
        messageLabel.setBorder(new EmptyBorder(5, 5, 5, 10));
        resetGameMessageLabel.setPreferredSize(new Dimension(347, 30));
        resetMessagePanel.setPreferredSize(new Dimension(500, 60));
        resetMessagePanel.setBorder(new EmptyBorder(10, 7, 5, 7));

        // Set background colors
        Color cyan = new Color(0, 183, 235);
        frame.setBackground(purple);
        boardPanel.setBackground(purple);
        playerPanel.setBackground(purple);
        buttonAndMessagePanel.setBackground(purple);
        buttonPanel.setBackground(purple);
        playerTurnLabel.setBackground(Color.WHITE);
        currentTurnLabel.setBackground(cyan);
        messageLabel.setBackground(Color.ORANGE);
        resetGameMessageLabel.setBackground(purple);
        resetGameMessageLabel.setForeground(purple);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tileButtons) {

        }
    }

    @Override
    public void update() {
        String[][] boardStatus = board.fetchBoardStatus();
        for (int row = 0; row < boardStatus.length; row++) {
            for (int col = 0; col < boardStatus[row].length; col++) {
                tileButtons[row][col].setEnabled(!Objects.equals(boardStatus[row][col], "eaten"));
                if (Objects.equals(boardStatus[row][col], "eaten")) {
                    tileButtons[row][col].setBackground(Color.RED);
                }
            }
        }
    }

    private void resetGame() {
        messageLabel.setText("Welcome to CHOMP GAME");
        this.board.resetBoard();
        int rows = board.fetchBoardStatus().length;
        int cols = board.fetchBoardStatus()[0].length;

        Color brown = new Color(155, 95, 55);
        Color papayaWhip = new Color(255, 239, 213);
        Color purple = new Color(115, 56, 250);

        resetGameMessageLabel.setBackground(purple);
        resetGameMessageLabel.setForeground(purple);
        isPlayer1Turn = true;
        currentTurnLabel.setText(p1.getName());
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if (row == rows - 1 && col == 0) {
                    tileButtons[row][col].setBackground(brown);
                    tileButtons[row][col].setOpaque(true);
                    tileButtons[row][col].setEnabled(true);
                } else {
                    tileButtons[row][col].setBackground(papayaWhip);
                    tileButtons[row][col].setOpaque(true);
                    tileButtons[row][col].setEnabled(true);
                }
                tileButtons[row][col].setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(purple, 2),
                        BorderFactory.createLineBorder(purple, 2)
                ));
                int r = row, c = col;
                tileButtons[row][col].addActionListener(_ -> {
                    isPlayer1Turn = !isPlayer1Turn;
                    currentTurnLabel.setText(isPlayer1Turn ? p1.getName() : p2.getName());
                    if (r == rows - 1 && c == 0) {
                        board.updateBoard(r, c);
                        String winner = isPlayer1Turn ? p1.getName() : p2.getName();
                        messageLabel.setText("Game Over!!! " + winner + " Wins");
                        resetGameMessageLabel.setBackground(Color.ORANGE);
                        resetGameMessageLabel.setForeground(Color.black);
                    } else {
                        board.updateBoard(r, c);
                    }
                });
            }
        }
    }
}
