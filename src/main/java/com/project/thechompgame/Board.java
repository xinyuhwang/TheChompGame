package com.project.thechompgame;
/**
 * @author Xinyu Wang
 * @version 10/20/2024
 * The {@code Board} class implements .
 * <p>
 *     This Board class contains the methods to:
 *
 * </p>
 * <p>
 *     This project is supposed to designed based on certain design pattern. The original design doc didn't mention any
 *     design pattern.
 *     Modified version: use Observer pattern to implement the connection between click actions in GUI and the board
 *     status update.
 * </p>
 */
interface Observer {
    void update();
}

public class Board {
    private final String[][] gameBoard;
    private final int row;
    private final int col;
    private Observer observer;
    // not in the original design, but would be more efficient to have one
    private boolean gameOver;

    /**
     * Constructor:
     * Initializes the board, including setting up the dimensions (width and height) and placing the poison tile.
     * In the design doc, there is no parameter for the constructor. However, without parameter, we cannot initialize
     * the gameBoard in the game.
     * In the design doc, a width and a height is used in construct the board. However, use row and col to construct a
     * String matrix make more sense in this design.
     * Modified version: pass gameBoard, width, and height in the parameter of Board constructor. Use row and col to
     * replace width and height.
     */
    public Board(String[][] gameBoard, int row, int col) {
        this.gameBoard = gameBoard;
        this.row = row;
        this.col = col;
        this.gameBoard[row - 1][0] = "poison tile";
        initializeBoard(this.gameBoard);
        gameOver = false;
    }
    //    The function header in the original design. However, the constructor already initialized the width and height of
    //    the gameBoard, I don't see the purpose of having width and height in the parameter of initializedBoard function.
    //    public void initializeBoard(int width, int height) {}

    /**
     * Initializes all tiles as 'active'.
     */
    // The modified version of initializedBoard function.
    private void initializeBoard(String[][] gameBoard) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (gameBoard[i][j] == null || !gameBoard[i][j].equals("poison tile")) {
                    gameBoard[i][j] = "active";
                }
            }
        }
    }

    public void attach(Observer observer) {
        this.observer = observer;
    }

    public void notifyObserver() {
        observer.update();
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

    /**
     * Returns the current state of the board as a 2D array of strings.
     */
    public String[][] fetchBoardStatus() {
        return this.gameBoard;
    }

    /**
     * In the original design doc, this function is used to update a specific tile to 'eaten' when a change is required.
     * Modified version: according to the game rule and GUI diagram, when a tile is chosen as 'eaten', all the tiles
     *                   above it or all the tiles to its right should also be marked as 'eaten'.
     * @param rowTile, the row number of this chosen tile
     * @param columnTile, the column number of this chosen tile
     */
    public void updateBoard(int rowTile, int columnTile) {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (i <= rowTile && j >= columnTile) {
                    this.gameBoard[i][j] = "eaten";
                }
            }
        }
        if (rowTile == this.row - 1 && columnTile == 0) {
            this.gameOver = true;
        }
        notifyObserver();
    }

    /**
     * Returns the number of remaining active tiles, helping determine when the game is over.
     */
    public int fetchTileCount() {
        int remainingTiles = 0;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (this.gameBoard[i][j].equals("active") || this.gameBoard[i][j].equals("poison tile")) {
                    remainingTiles++;
                }
            }
        }
        return remainingTiles;
    }

    /**
     * This is not in the original design. However, there is no way to reset the board only use the function startGame
     * in GameController class.
     * Modified version:
     * Use resetBoard function to reset the board.
     */
    public void resetBoard() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                if (!gameBoard[i][j].equals("poison tile")) {
                    gameBoard[i][j] = "active";
                }
            }
        }
    }
}
