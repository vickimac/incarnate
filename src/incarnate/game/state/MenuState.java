/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import incarnate.game.main.GameMain;
import incarnate.game.main.Resources;
import incarnate.game.zone.TestZone;
/**
 *
 * @author Vicki
 */
public class MenuState extends State {
    
    private int currentSelection = 0;
    private Font font;
    private Color selectedOption = Color.GREEN;
    private Color otherOption = Color.WHITE;
    
    @Override
    public void init() {}
    
    @Override
    public void update(float delta) {}
    
    @Override
    public void render(Graphics g)
    {
        int squareStart = GameMain.GAME_WIDTH / 2 - (470 / 2);
        int textStart = squareStart + (470 / 2) - 75;
        
        g.drawImage(Resources.menuBG, 0, 0, null);
        g.drawImage(Resources.menuLogo, squareStart, GameMain.GAME_HEIGHT / 10, null);
        g.setColor(Resources.halfBlack);
        g.fillRect(squareStart, 200, 470, 213);
       
        g.setFont(font = new Font("Tahoma", font.PLAIN, 45));
        if (currentSelection == 0) { g.setColor(selectedOption); } else { g.setColor(otherOption); }
            //g.drawString("Play", 450, 590);
            g.drawString("Play", textStart + 30, 260);
        if (currentSelection == 1) { g.setColor(selectedOption); } else { g.setColor(otherOption); }
            g.drawString("Options", textStart, 317);
            
        if (currentSelection == 2) { g.setColor(selectedOption); } else { g.setColor(otherOption); }
            g.drawString("Exit", textStart + 30, 374);
        }

    @Override
    public void onClick(MouseEvent e){}
    
    @Override
    public void onKeyPress(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            Resources.menuSelect.play();
            
            if(currentSelection == 0)
            {
                Resources.menuIntro.stop();
                setCurrentState(new TestZone());
            }
            else if (currentSelection == 1)
            {
                setCurrentState(new Options());
            }
            else if (currentSelection == 2)
            {
                Resources.menuIntro.stop();
                GameMain.sGame.exit();
            }
        }
        else if (e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP)
        {
            if (currentSelection > 0)
            {
                Resources.menuBeep.play();
                currentSelection--;
            }
        }
        else if (e.getKeyChar() == 's' || e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(currentSelection < 2)
            {
                Resources.menuBeep.play();
                currentSelection++;
            }
        }
    }
    
    @Override
    public void onKeyRelease(KeyEvent e){}
}
