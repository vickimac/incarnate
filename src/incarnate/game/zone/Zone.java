/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.zone;

import incarnate.game.main.GameMain;
import incarnate.game.main.Resources;
import incarnate.game.model.Atyx;
import incarnate.game.model.Platform;
import incarnate.game.model.SmallPlatform;
import incarnate.game.state.State;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

/**
 *
 * @author Vicki
 */
public class Zone extends State {
    
    protected Atyx atyx;
        public String atyxFacing = "right";
        protected final static int ATYX_WIDTH = 72*2;
        protected final static int ATYX_HEIGHT = 43*2;
        
    protected Platform pfInvisible;
    
    protected HashMap<Character, Boolean> keyChars = new HashMap<Character, Boolean>();
    protected HashMap<Integer, Boolean> keyCodes = new HashMap<Integer, Boolean>();
    
    // zone constants
        protected static final int ZONE_WIDTH = 1024;
        protected static final int ZONE_HEIGHT = 768;
    
    // camera
        protected int offsetMaxX = ZONE_WIDTH - GameMain.GAME_WIDTH;
        protected int offsetMaxY = ZONE_HEIGHT - GameMain.GAME_HEIGHT - 50;
        protected int offsetMinX = 0;
        protected int offsetMinY = ZONE_HEIGHT - GameMain.GAME_HEIGHT - 50;
        
        protected int camX;
        protected int camY;
        
    @Override
    public void init()
    {
        pfInvisible = new SmallPlatform(0, 610, ZONE_WIDTH, 150);
        atyx = new Atyx(160, (int) pfInvisible.getY() + ((int) pfInvisible.getHeight() / 2), ATYX_WIDTH, ATYX_HEIGHT, ZONE_WIDTH, ZONE_HEIGHT);
        
    }
    
    @Override
    public void update(float delta)
    {
        Resources.atyx_ridleAnim.update(delta);
        Resources.atyx_lidleAnim.update(delta);
        atyx.update(delta);
        
        updatePlatforms(delta);
        updateKeyBindings(delta);
        updateCamera(delta);
    }
    
    public void updatePlatforms(float delta)
    {
        if (atyx.getVelY() >= 0)
        {
            if(atyx.getRect().intersects(pfInvisible.getRect()))
            {
                atyx.changeY(pfInvisible.getY() - (ATYX_HEIGHT - 1));
                atyx.jumpStop();
            }
            else
            {
                atyx.falling();
            }
        }
    }
    
    public void updateKeyBindings(float delta)
    {
        if ((keyChars.containsKey('d') && keyChars.get('d')) || (keyCodes.containsKey(KeyEvent.VK_RIGHT) && keyCodes.get(KeyEvent.VK_RIGHT)))
        {
            atyxFacing = "right";
            if(!atyx.getJumping())
            {
                Resources.atyx_rrunAnim.update(delta);
            }
            atyx.move(KeyEvent.VK_RIGHT);
        }
        else if (keyChars.containsKey('a') && keyChars.get('a') || (keyCodes.containsKey(KeyEvent.VK_LEFT) && keyCodes.get(KeyEvent.VK_LEFT)))
        {
            atyxFacing = "left";
            if(!atyx.getJumping())
            {
                Resources.atyx_lrunAnim.update(delta);
            }
            atyx.move(KeyEvent.VK_LEFT);
        }
        else
        {
            atyx.stop();
            if(atyxFacing == "right")
            {
                Resources.atyx_ridleAnim.update(delta);
            }
            else if (atyxFacing == "left")
            {
                Resources.atyx_lidleAnim.update(delta);
            }
        }
        
        if(keyCodes.containsKey(KeyEvent.VK_UP) && keyCodes.get(KeyEvent.VK_UP) || keyChars.containsKey('w') && keyChars.get('w'))
        {
            if(!atyx.getJumping())
            {
                atyx.jump();
                Resources.jumpSound.play();
            }
        }
                
    }
    
    public void updateCamera(float delta)
    {
        //CAMERA
        camX = (int) (atyx.getX() - GameMain.GAME_WIDTH / 2);
        camY = (int) (atyx.getY() - GameMain.GAME_HEIGHT / 2);
        
        if (camX > offsetMaxX)
        {
            camX = offsetMaxX;
        }
        else if (camX < offsetMinX)
        {
            camX = offsetMinX;
        }
        
        if(camY > offsetMaxY)
        {
            camY = offsetMaxY;
        }
        else if (camY < offsetMinY)
        {
            camY = offsetMinY;
        }
    }
    
    @Override
    public void render(Graphics g)
    {
        g.translate(-camX, -camY);
        renderAtyx(g);
    }
    public void renderAtyx(Graphics g)
    {
                if(atyx.getJumping())
        {
            if (atyxFacing == "right")
            {
                if(atyx.getVelY() < 0)
                {
                    Resources.atyx_rjumpAnim1.render(g, (int) atyx.getX(), (int) atyx.getY(), (63*2), (58*2));
                }
                else
                {
                    Resources.atyx_rjumpAnim2.render(g, (int) atyx.getX(), (int) atyx.getY(), atyx.getWidth(), atyx.getHeight());
                }
            }
            else if (atyxFacing == "left")
            {
                if(atyx.getVelY() < 0)
                {
                    Resources.atyx_ljumpAnim1.render(g, (int) atyx.getX(), (int) atyx.getY(), (63*2), (58*2));
                }
                else
                {
                    Resources.atyx_ljumpAnim2.render(g, (int) atyx.getX(), (int) atyx.getY(), atyx.getWidth(), atyx.getHeight());
                }
            }
        }
        else
        {
            if((keyChars.containsKey('d') && keyChars.get('d') || (keyCodes.containsKey(KeyEvent.VK_RIGHT) && keyCodes.get(KeyEvent.VK_RIGHT))))
            {
                Resources.atyx_rrunAnim.render(g, (int) atyx.getX(), (int) atyx.getY(), atyx.getWidth(), atyx.getHeight());
            }
            else if ((keyChars.containsKey('a') && keyChars.get('a') || (keyCodes.containsKey(KeyEvent.VK_LEFT) && keyCodes.get(KeyEvent.VK_LEFT))))
            {
                Resources.atyx_lrunAnim.render(g, (int) atyx.getX(), (int) atyx.getY(), atyx.getWidth(), atyx.getHeight());
            }
            else
            {
                if(atyxFacing == "right")
                {
                    Resources.atyx_ridleAnim.render(g, (int) atyx.getX(), (int) atyx.getY(), atyx.getWidth(), atyx.getHeight());
                }
                else if (atyxFacing == "left")
                {
                     Resources.atyx_lidleAnim.render(g, (int) atyx.getX(), (int) atyx.getY(), atyx.getWidth(), atyx.getHeight());
                }
            }
        }
    }
    
    @Override
    public void onClick(MouseEvent e) {}
    
    @Override 
    public void onKeyPress(KeyEvent e)
    {
        keyChars.remove(e.getKeyChar());
        keyChars.put(e.getKeyChar(), true);
        keyCodes.remove(e.getKeyCode());
        keyCodes.put(e.getKeyCode(), true);
    }
    
    @Override
    public void onKeyRelease(KeyEvent e)
    {
        keyChars.remove(e.getKeyChar());
        keyChars.put(e.getKeyChar(), false);
        keyCodes.remove(e.getKeyChar());
        keyCodes.put(e.getKeyCode(), false);
    }
}
