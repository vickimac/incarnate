package incarnate.game.state;

import incarnate.game.main.Resources;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * The Options screen. Currently just an Under Construction message, but may
 * change variables such as sound volume in the future. Possibly will save options
 * in a file.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class Options extends State{
    
    private int currentSelection = 0;
    private Font font;
    
    @Override
    public void init() { }
    
    @Override
    public void update(float delta){}
    
    /**
     * Renders the options screen, which is similar to the main menu but just
     * shows an "Under Construction" message.
     * 
     * @param g     Graphics
     */
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
    
    /**
     * Goes back to Main Menu when the option is selected.
     * 
     * @param e     Key pressed
     */
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
