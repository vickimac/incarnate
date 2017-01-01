package incarnate.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import incarnate.game.main.Resources;

/**
 * First state of the game, loading all resources into the game. Then sets the
 * current state to the Menu.
 * 
 * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 *
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class LoadState extends State {
    
    @Override
    public void init()
    {
        Resources.load();
    }
    
    @Override
    public void update(float delta)
    {
        setCurrentState(new MenuState());
    }
    
    @Override
    public void render(Graphics g) {}
    
    @Override
    public void onClick(MouseEvent e){}
    
    @Override
    public void onKeyPress(KeyEvent e){}
    
    @Override
    public void onKeyRelease(KeyEvent e){}
}
