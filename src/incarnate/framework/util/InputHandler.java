/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.framework.util;

import incarnate.game.state.State;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Vicki
 */
public class InputHandler implements KeyListener, MouseListener {
    
    private final Set<Character> pressed = new HashSet<Character>();
    
    private State currentState;
    
    public void setCurrentState(State currentState)
    {
        this.currentState = currentState;
    }
    
    public void mouseClicked(MouseEvent e)
    {
        currentState.onClick(e);
    }

public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
		
}

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
		
    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
		
    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    
    public void keyPressed(KeyEvent e)
    {
        currentState.onKeyPress(e);
        
        if (pressed.size() > 1)
        {
            pressed.add(e.getKeyChar());
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        currentState.onKeyRelease(e);
        pressed.remove(e.getKeyChar());
    }
    
    public void keyTyped(KeyEvent e)
    {
        // TODO Auto-generated method stub
    }
}
