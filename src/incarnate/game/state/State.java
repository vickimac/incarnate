package incarnate.game.state;

import incarnate.game.main.GameMain;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import incarnate.game.main.GameMain;

/**
 * The abstract class for all states.
 * 
 * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 *
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public abstract class State {
    
    public abstract void init();
    
    public abstract void update(float delta);
    
    public abstract void render(Graphics g);
    
    public abstract void onClick(MouseEvent e);
    
    public abstract void onKeyPress(KeyEvent e);
    
    public abstract void onKeyRelease(KeyEvent e);
    
    /**
     * Sets the current state to the specified state.
     * 
     * @param newState  State to be changed to.
     */
    public void setCurrentState(State newState)
    {
        GameMain.sGame.setCurrentState(newState);
    }
}
