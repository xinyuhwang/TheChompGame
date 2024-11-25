package com.project.thechompgame;

public class Board {
    private final String[][] gameBoard;
    private final int width;
    private final int height;

    /**
     * Constructor:
     * Initializes the board, including setting up the dimensions (width and height) and placing the poison tile.
     * In the design doc, there is no parameter for the constructor.
     * As showed in the GUI diagram, the width is 7 and the height is 8.
     */
    public Board() {
        this.width = 7;
        this.height = 8;
        gameBoard = new String[this.width][this.height];
        this.gameBoard[0][this.height - 1] = "poison tile";
        initializeBoard();
    }
    //    The function header in the original design. However, the constructor already initialized the width and height of
    //    the gameBoard, I don't see the purpose of having width and height in the parameter of initializedBoard function.
    //    public void initializeBoard(int width, int height) {}

    /**
     * Initializes all tiles as 'active'.
     */
    // The modified version of initializedBoard function.
    private void initializeBoard() {
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (!this.gameBoard[i][j].equals("poison tile")) {
                    this.gameBoard[i][j] = "active";
                }
            }
        }
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
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (i <= rowTile && j >= columnTile) {
                    this.gameBoard[i][j] = "eaten";
                }
            }
        }
    }

    /**
     * Returns the number of remaining active tiles, helping determine when the game is over.
     */
    public int fetchTileCount() {
        int remainingTiles = 0;
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if (this.gameBoard[i][j].equals("active") || this.gameBoard[i][j].equals("poison tile")) {
                    remainingTiles++;
                }
            }
        }
        return remainingTiles;
    }
}
