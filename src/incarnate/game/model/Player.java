/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.model;

import java.awt.Rectangle;
import java.awt.event.*;
/**
 * Playable character that the user controls. Most likely going to be just one
 * playable character at a time.
 * 
 * @author Victoria Maciver
 * @version 0.1
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
    
    /**
     * Sets up the Player's character. Also takes in the zone size to prevent 
     * the character from going outside of the zone's bounds and off the screen.
     * This may change in the future as it may cause problems when more zones
     * and created, but it works fine for now.
     * 
     * @param x             Starting x position.
     * @param y             Starting y position.
     * @param width         Starting width.
     * @param height        Starting height.
     * @param zoneWidth     Width of the current zone.
     * @param zoneHeight    Height of the current zone.
     */
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
    
    /**
     * Updates the current X and Y positions based on the current velocity,
     * allowing for movement. Also allows jumping by adding the gravity to the 
     * Y velocity.
     * 
    * @param delta     Time of delta
     *                  ((updateDurationMillis + sleepDurationMillis) / 1000f)
     */
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
    
    /**
     * Updates the rectangle that the Player is contained in based on the current 
     * X and Y values, as well as the width and height.
     */
    public void updateRects()
    {
        rect.setBounds((int) x, (int) y, width, height);
    }
    
    /**
     * Moves the character based on the last direction (basically the current
     * key that is being pressed).
     * 
     * @param last_direction    Direction of the last key pressed.
     */
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
    
    /**
     * Sets the x velocity to 0 so the character stops moving. May have a 
     * different reset value on different slopes or surfaces (e.g. ice) in the 
     * future.
     */
    public void stop()
    {
        velX = 0;
    }
    
    /**
     * Sets jumping to true and sets the y velocity to a negative value, which
     * makes the Player ascend. As the saying goes, "What goes up must come back
     * down", and the gravity will pull the player back down (as stated in the
     * update method).
     */
    public void jump()
    {
        this.jumping = true;
        velY = -19;
    }
    
    /**
     * When the player is in the air and needs to fall, but isn't ascending.
     * An example of this is when the player goes beyond the edge of a platform
     * and falls down.
     */
    public void falling()
    {
        this.jumping = true;
    }
    
    /**
     * Stops the jump when the player hits a surface.
     */
    public void jumpStop()
    {
        this.jumping = false;
        velY = 0;
    }
    
    // GETS
        /**
         * Returns the current X of the Player.
         * 
         * @return  int     X value
         */
        public float getX()
        {
            return x;
        }

        /**
         * Returns the current Y of the Player.
         * 
         * @return  int     Y value
         */
        public float getY()
        {
            return y;
        }

        /**
         * Returns the width of the Player.
         * 
         * @return  int     width value
         */
        public int getWidth()
        {
            return width;
        }

        /**
         * Returns the height of the Player.
         * 
         * @return  int     height value
         */
        public int getHeight()
        {
            return height;
        }

        /**
         * Returns the current X velocity of the Player.
         * 
         * @return  int     X velocity value
         */
        public int getVelX()
        {
            return velX;
        }

        /**
         * Returns the current Y velocity of the Player.
         * 
         * @return  int     Y velocity value
         */
        public int getVelY()
        {
            return velY;
        }

        /**
         * Returns the rectangle that the Player is contained in
         * 
         * @return  rectangle   The rectangle that the Player is contained in
         */
        public Rectangle getRect()
        {
            return rect;
        }

        /**
         * Returns whether the character is currently jumping or falling.
         * 
         * @return  boolean     Whether the Player is currently falling
         */
        public boolean getJumping()
        {
            return jumping;
        }
    
    //CHANGE
        /**
         * Changes the Player's current x position.
         * 
         * @param newX  New x position to be changed to.
         */
        public void changeX(float newX)
        {
            x = newX;
        }

         /**
         * Changes the Player's current y position.
         * 
         * @param newY  New y position to be changed to.
         */
        public void changeY(float newY)
        {
            y = newY;
        }
}
