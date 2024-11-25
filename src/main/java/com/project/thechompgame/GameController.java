package com.project.thechompgame;

public class GameController {
    private Player currentTurn;
    // The original design doc doesn't have any variable to keep tracking if a game is over.
    // The modified version: use a private attribute to keep tracking if a game is over.
    private boolean gameComplete;
    // The original design doc doesn't have access to the board in this GameController class. However, without access
    // to the board, there's no way to check if the player is clicked on the "eaten" tile (which is invalid move
    // according to the game rule).
    // Modified version: access to the board and check if the player clicked on the "eaten" tile.
    private final Board board;

    // The original design doc doesn't have any parameter in the constructor. However, accessing to the board is
    // necessary for validate the player's move.
    // The original design doc doesn't initialize the attribute Player currentTurn. However, the design doc described
    // one of the functionality of this GameController class is to manage player turns.

    // Modified version: pass a Board as the parameter of this constructor.
    //                   pass a Player that take the first turn.
    public GameController(Board board, Player currentPlayer) {
        this.gameComplete = false;
        this.board = board;
        this.currentTurn = currentPlayer;
    }

    // The original design doc doesn't give any parameters to playMove() function and validateMove() function, which
    // gives no way to neither executes a player's move nor validate a move.
    //    public boolean playMove() {
    //
    //    }
    //
    //    private boolean validateMove() {
    //        return false;
    //    }

    // Modified version: pass in the location of the chosen tile
    public boolean playMove(int row, int col) {
        if (!validateMove(row, col)) {
            return false;
        }
        if (row == 7 && col == 0) {
            setGameComplete();
        }
        return true;
    }

    // The original design doc doesn't have access to the board in this GameController class. However, without access
    // to the board, there's no way to check if the player is clicked on the "eaten" tile (which is invalid move
    // according to the game rule).

    // Modified version: access to the board and check if the player clicked on the "eaten" tile.
    private boolean validateMove(int row, int col) {
        if (row < 0 || row > 7 || col < 0 || col > 6) {
            return false;
        } else {
            String[][] b = this.board.fetchBoardStatus();
            return !b[row][col].equals("eaten");
        }
    }

    // The original design doc describe the gameComplete function is used to check if all tiles have been eaten or if
    // the game has reached a conclusion. There is no indication of the usage for passing a tileCount as parameter.
    // Also, the Board class has a fetchTileCount function to track if there's any remaining tile left which indicate
    // the termination of the game.
    // public boolean gameComplete(int tileCount) {}

    // Modified version: use a private attribute to keep tracking if a game is complete.
    public boolean isGameComplete() {
        return this.gameComplete;
    }

    // The original design doc doesn't have any function to mark if a game is complete.
    // The modified version: use a setGameComplete function to mark this game is over.
    public void setGameComplete() {
        this.gameComplete = true;
    }

    // The original design doc describe the function as the game initializer. However, this class doesn't have access to
    // all the players, neither has a way to re-initialize the board.
    public void startGame(Player p1, Player p2, Board b, ChompGUI cgi) {

    }
}
