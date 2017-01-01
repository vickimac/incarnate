/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.model;

import java.awt.Rectangle;

/**
 * Non-Playable Character. Similar properties to Player, but the character itself
 * cannot be played. Any custom actions will either be reactions to the player's
 * actions, timed events, or AI (maybe).
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class NPC implements Character {
    
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle rect;
    
    /**
     * Sets up the NPC and created a rectangle box to contain it.
     * 
     * @param x         Starting x position (may change).
     * @param y         Starting y position (may change).
     * @param width     Starting width value (may change).
     * @param height    Starting height value (may change).
     */
    public NPC(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        rect = new Rectangle();
        updateRects();
    }
    
    /**
     * Updates the rectangles. No other actions that require updating yet.
     * 
     * @param delta     Time of delta
     *                  ((updateDurationMillis + sleepDurationMillis) / 1000f)
     *                   
     */
    public void update(float delta)
    {
        updateRects();
    }
    
    /**
     * Updates the rectangle that the NPC is contained in based on the current X
     * and Y values, as well as the width and height.
     */
    public void updateRects()
    {
        rect.setBounds((int) x, (int) y, width, height);
    }
    
    // GETS
        /**
         * Returns the current X of the NPC.
         * 
         * @return  X value
         */
        public float getX()
        {
            return x;
        }

        /**
         * Returns the current Y of the NPC.
         * 
         * @return  Y value
         */
        public float getY()
        {
            return y;
        }

        /**
         * Returns the width of the NPC.
         * 
         * @return  width value
         */
        public int getWidth()
        {
            return width;
        }

        /**
         * Returns the height of the NPC.
         * 
         * @return  height value
         */
        public int getHeight()
        {
            return height;
        }

        /**
         * Returns the rectangle that the NPC is contained in
         * 
         * @return  rectangle
         */
        public Rectangle getRect()
        {
            return rect;
        }
    
    //CHANGE
        /**
         * Changes the character's current x position.
         * 
         * @param newX  New x position to be changed to.
         */
        public void changeX(float newX)
        {
            x = newX;
        }

         /**
         * Changes the character's current y position.
         * 
         * @param newY  New y position to be changed to.
         */
        public void changeY(float newY)
        {
            y = newY;
        }
        
}
