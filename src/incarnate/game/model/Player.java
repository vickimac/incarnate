/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.model;

import java.awt.Rectangle;
import java.awt.event.*;
/**
 *
 * @author Vicki
 */
public class Player implements Character {
    protected float x;
    protected float y;
    protected int width, height, velX, velY, zoneWidth, zoneHeight;
    protected Rectangle rect;
    protected int last_direction;
    
    protected float startJumpY;
    protected final static float GRAVITY = 1f;
    protected final static float TERMINAL_VELOCITY = 100;
    
    protected boolean jumping = false;
    protected Integer jump_count;
    
    protected final static int MOVE_SPEED = 7;
    protected final static int JUMP_COUNTER_THRESH = 3;
    
    public Player(float x, float y, int width, int height, int zoneWidth, int zoneHeight)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.zoneWidth = zoneWidth;
        this.zoneHeight = zoneHeight;
        
        rect = new Rectangle();
        updateRects();
    }
    
    public void update(float delta)
    {
        x += velX;
        y += velY;
        
        if(jumping)
        {
            velY += GRAVITY;
         }
        
        if (x < 0)
        {
            x = 0;
        }
        else if (x + width > zoneWidth)
        {
            x = zoneWidth - width;
        }
        
        if (y < 0)
        {
            y = 0;
        }
        else if (y > zoneHeight)
        {
            y = zoneHeight;
        }
        
        updateRects();
    }
    
    public void updateRects()
    {
        rect.setBounds((int) x, (int) y, width, height);
    }
    
    public void move(int last_direction)
    {
        if(last_direction == KeyEvent.VK_LEFT)
        {
            velX = -MOVE_SPEED;
        }
        else if (last_direction == KeyEvent.VK_RIGHT)
        {
            velX = MOVE_SPEED;
        }
    }
    
    public void stop()
    {
        velX = 0;
    }
    
    public void jump()
    {
        this.jumping = true;
        velY = -19;
    }
    
    public void falling()
    {
        this.jumping = true;
    }
    
    public void jumpStop()
    {
        this.jumping = false;
        velY = 0;
    }
    
    // GETS
    public float getX()
    {
        return x;
    }
    
    public float getY()
    {
        return y;
    }
    
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getVelX()
    {
        return velX;
    }
    
    public int getVelY()
    {
        return velY;
    }
    
    public Rectangle getRect()
    {
        return rect;
    }
    
    public boolean getJumping()
    {
        return jumping;
    }
    
    //CHANGE
    public void changeX(float newX)
    {
        x = newX;
    }
    
    public void changeY(float newY)
    {
        y = newY;
    }
}
