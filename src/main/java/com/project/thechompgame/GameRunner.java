package com.project.thechompgame;
/**
 * @author Xinyu Wang
 * @version 10/20/2024
 * The {@code GameRunner} class implements .
 * <p>
 *    This GameRunner class contains the methods to:
 *
 * </p>
 * <p>
 * Although the design doc state that GameController class initialize the players, the board, and the GUI. However, the
 * class diagram indicates the GameRunner class has Player P1, Player P2, GameController G, Board B, and ChompGUI cgi
 * as its attributes. Also, the design doc didn't specify initializing those Objects in the GameController constructor.
 * </p>
 * <p>
 * Modified version: to me, the GameRunner class's functionality is similar to the Main class.
 * Therefore, I combined initialized everything in this GameRunner class and added the main function.
 * I don't understand what does it mean to add a boolean value next to the player initialization in the original design.
 * Therefore, the pair data of (player name, true)  is not implemented in here.
 * </p>
 */
public class GameRunner {
//    private Player p1;
//    private Player p2;
//    private Board b;
//    private ChompGUI cgi;
//    private GameController g;

//    public GameRunner(Player p1, Player p2, Board b, ChompGUI cgi, GameController g) {
//        this.p1 = p1;
//        this.p2 = p2;
//        this.b = b;
//        this.cgi = cgi;
//        this.g = g;
//    }

    public static void main(String[] args) {
        String[][] gameBoard = new String[8][7];
        Player p1 = new Player("P1");
        Player p2 = new Player("P2");
        Board board = new Board(gameBoard, 8, 7);
        GameController gameController = new GameController(board, p1);
        ChompGUI chompGUI = new ChompGUI(board, p1, p2, gameController);
        gameController.startGame(p1, p2, board, chompGUI);
    }
}
