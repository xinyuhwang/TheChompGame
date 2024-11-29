package com.project.thechompgame;

import java.awt.event.MouseEvent;
/**
 * @author Xinyu Wang
 * @version 10/20/2024
 * The {@code MouseListener} interface that indicated in the original design doc implements the mouseClick function
 * and mousePressed function. However, I think it is not needed for the functionalities of this project. This project
 * uses a design pattern, as what I understand an Observer design pattern, that uses an Observer interface with an
 * update function that can update the board whenever there is a change happen.
 */
public interface MouseListener {
    /**
     * This method is invoked when a mouse button is clicked (pressed and released) on a component.
     */
    public void mouseClicked(MouseEvent e);

    /**
     * The original design doc listed this function.
     * This method is called when a mouse button is pressed down on a component.
     * I don't see the usage of this function in this project. Therefore, I will not implement this function.
     * public void mousePressed(MouseEvent e);
     */
}
