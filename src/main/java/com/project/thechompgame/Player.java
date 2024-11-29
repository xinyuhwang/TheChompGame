package com.project.thechompgame;
/**
 * @author Xinyu Wang
 * @version 10/20/2024
 * The {@code Player} class implements the Player object.
 * <p>
 *     This Player class contains the methods to:
 *          constructor a player with their name;
 *          return a player's name using getName().
 * </p>
 * <p>
 *     The original design doc of the class diagram (Player Decision Flowchart) indicate they want to check if a player
 *      is real and if it is currently their turn, but I don't see any function listed anywhere in the doc indicates
 *      these functionality.
 * </p>
 */
public class Player {
    private final String name;

    /**
     * Constructor:
     * Initializes the player with a specified name.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * The original design doc doesn't have this function.
     * Modified version: without this function, I couldn't access and display the player's name on the GUI.
     */
    public String getName() {
        return name;
    }
}
