package incarnate.game.model;

import java.awt.Rectangle;

/**
 * A generic platform that can be jumped on.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class SmallPlatform implements Platform {
    
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle rect;
    
    /**
     * Sets up the platform.
     * 
     * @param x         Starting x position
     * @param y         Staring y position
     * @param width     Starting width value
     * @param height    Starting height value
     */
    public SmallPlatform(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        rect = new Rectangle();
        updateRects();
    }
    
    /**
     * Updates the position and/or size of the rectangle that the Platform is 
     * contained in. Allows for hit detection, as well as preventing characters
     * from falling through it.
     */
    public void updateRects()
    {
        rect.setBounds((int) x, (int) y, width, height);
    }
    
    //GETS
        /**
         * Returns the current X of the Platform.
         * 
         * @return  int     X value
         */
        public float getX()
        {
            return x;
        }

        /**
         * Returns the current Y of the Platform.
         * 
         * @return  int     Y value
         */
        public float getY()
        {
            return y;
        }

        /**
         * Returns the width of the Platform.
         * 
         * @return  int     width value
         */
        public int getWidth()
        {
            return width;
        }

        /**
         * Returns the height of the Platform.
         * 
         * @return  int     height value
         */
        public int getHeight()
        {
            return height;
        }

        /**
         * Returns the rectangle that the Platform is contained in
         * 
         * @return  rectangle
         */
        public Rectangle getRect()
        {
            return rect;
        }
}
