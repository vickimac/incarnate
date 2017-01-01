package incarnate.framework.util;

import incarnate.game.state.State;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Allows for user input via the keyboard and mouse.
 * 
 *  * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class InputHandler implements KeyListener, MouseListener {
    
    private final Set<Character> pressed = new HashSet<Character>();
    
    private State currentState;
    
    /**
     * Sets the current state. Allows for states to change.
     * 
     * @param currentState  The state to be changed to.
     */
    public void setCurrentState(State currentState)
    {
        this.currentState = currentState;
    }
    
    /**
     * Allows for clicks to be registered within the current state.
     * 
     * @param e     Mouse click
     */
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
    
    /**
     * Adds pressed keys to the pressed HashMap. This allows for multiple keys
     * to be pressed at the same time, which is vital for fluid gameplay in a
     * 2D Platformer.
     * 
     * @param e     Key pressed.
     */
    public void keyPressed(KeyEvent e)
    {
        currentState.onKeyPress(e);
        
        if (pressed.size() > 1)
        {
            pressed.add(e.getKeyChar());
        }
    }
    
    /**
     * Removes released keys from the pressed HashMap. This allows for multiple 
     * keys to be pressed at the same time, which is vital for fluid gameplay in 
     * a 2D Platformer.
     * 
     * @param e     Key released.
     */
    public void keyReleased(KeyEvent e)
    {
        currentState.onKeyRelease(e);
        pressed.remove(e.getKeyChar());
    }
    
    public void keyTyped(KeyEvent e){
        // TODO Auto-generated method stub
    }
}
