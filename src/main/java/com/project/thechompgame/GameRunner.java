package com.project.thechompgame;
/**
 *
 * <p>
 * Although the design doc state that GameController class initialize the players, the board, and the GUI. However, the
 * class diagram indicates the GameRunner class has Player P1, Player P2, GameController G, Board B, and ChompGUI cgi
 * as its attributes. Also, the design doc didn't specify initializing those Objects in the GameController constructor.
 * </p>
 * <p>
 * Modified version: to me, the GameRunner class's functionality is similar to the Main class without the main function.
 * Therefore, I combined the GameRunner class with ChompGUI class and initialized everything in ChompGUI.
 * </p>
 */
public class GameRunner {
    private Player p1;
    private Player p2;
    private Board b;
    private ChompGUI cgi;
    private GameController g;

    public GameRunner(Player p1, Player p2, Board b, ChompGUI cgi, GameController g) {
        this.p1 = p1;
        this.p2 = p2;
        this.b = b;
        this.cgi = cgi;
        this.g = g;
    }

    public void run() {
        g.startGame(p1, p2, b, cgi);
    }
}
