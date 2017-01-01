package incarnate.game.model;

import java.awt.Rectangle;

/**
 * Interface for a platform
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public interface Platform {
    
    /**
     * Updates the position and/or size of the rectangle that the Platform is 
     * contained in. Allows for hit detection, as well as preventing characters
     * from falling through it.
     */
    public abstract void updateRects();
    
    // GETS
        /**
         * Returns the current X of the Platform.
         * 
         * @return  int     X value
         */
        public abstract float getX();

        /**
         * Returns the current Y of the Platform.
         * 
         * @return  int     Y value
         */
        public abstract float getY();

        /**
         * Returns the width of the Platform.
         * 
         * @return  int     width value
         */
        public abstract int getWidth();

        /**
         * Returns the height of the Platform.
         * 
         * @return  int     height value
         */
        public abstract int getHeight();

        /**
         * Returns the rectangle that the Platform is contained in
         * 
         * @return  rectangle
         */
        public abstract Rectangle getRect();
    
}
