/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.state;

import incarnate.game.main.Resources;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Vicki
 */
public class Options extends State{
    
    private int currentSelection = 0;
    private Font font;
    
    @Override
    public void init() { }
    
    @Override
    public void update(float delta){}
    
    @Override
    public void render(Graphics g)
    {
        g.drawImage(Resources.menuBG, 0, 0, null);
        g.drawImage(Resources.menuLogo, 276, 450, null);
        
        g.setColor(Resources.halfBlack);
        g.fillRect(150, 300, 750, 425);
		
        g.setColor(Color.white);
        g.setFont(font = new Font("Tahoma", Font.BOLD, 54));
        g.drawString("Options", 400, 350);
        g.setFont(font = new Font("Tahoma", Font.PLAIN, 28));
        g.drawString("Under Construction :) Thanx!", 175, 400);
		
        g.setColor(Color.green);
        g.setFont(font = new Font("Tahoma", Font.PLAIN, 30));
        g.drawString("Back to Menu", 400, 500);
    }
    
    @Override
    public void onClick(MouseEvent e) {}
    
    @Override 
    public void onKeyPress(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            Resources.menuSelect.play();
            setCurrentState(new MenuState());
        }
    }
    
    @Override
    public void onKeyRelease(KeyEvent e){}
}
