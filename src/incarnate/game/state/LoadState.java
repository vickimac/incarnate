/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import incarnate.game.main.Resources;
/**
 *
 * @author Vicki
 */
public class LoadState extends State {
    
    @Override
    public void init()
    {
        Resources.load();
        System.out.println("Loaded successfully!");
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
