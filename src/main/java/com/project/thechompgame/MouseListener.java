package com.project.thechompgame;

import java.awt.event.MouseEvent;

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
