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
 * The Menu screen that the user sees when the game is loaded. Currently has
 * Play (loads the first Zone, which is the Test Zone), Options (just an "Under
 * Construction" message), and Exit (closes the game). Plays a sound when the
 * user changes currently selected option with the arrow / WS keys.
 * 
 * @author Victoria Maciver
 * @version 0.1
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
    
    /**
     * Renders the menu screen. This includes:
     *  - Menu background image
     *  - Menu logo image
     *  - Half-black rectangle behind options
     *  - Options and their colours (currently selected is different colour)
     * 
     * @param g     Graphics
     */
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
    
    /**
     * Changes the current option that is selected based on the key press. Also
     * performs the action needed if spacebar or enter are pressed depending on
     * the current selection (e.g. Play will load the level)
     * 
     * @param e     Key press
     */
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
