/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.state;

import incarnate.game.main.GameMain;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import incarnate.game.main.GameMain;
/**
 *
 * @author Vicki
 */
public abstract class State {
    
    public abstract void init();
    
    public abstract void update(float delta);
    
    public abstract void render(Graphics g);
    
    public abstract void onClick(MouseEvent e);
    
    public abstract void onKeyPress(KeyEvent e);
    
    public abstract void onKeyRelease(KeyEvent e);
    
    public void setCurrentState(State newState)
    {
        GameMain.sGame.setCurrentState(newState);
    }
}
