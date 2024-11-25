package com.project.thechompgame;

import java.awt.event.MouseEvent;

public interface MouseListener {
    /**
     * This method is invoked when a mouse button is clicked (pressed and released) on a component.
     */
    public void mouseClicked(MouseEvent e);

    /**
     * This method is called when a mouse button is pressed down on a component.
     */
    public void mousePressed(MouseEvent e);
}
