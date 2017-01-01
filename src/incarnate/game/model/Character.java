package incarnate.game.model;

import java.awt.Rectangle;
import java.awt.event.*;
/**
 * Interface for a character in the game. May be playable or not.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public interface Character {
    
    /**
     * Updates the animations and anything else that is relevant. Keeps the rest
     * of the program up-to-date with the Character object.
     * 
     * @param delta     Time of delta
     *                  ((updateDurationMillis + sleepDurationMillis) / 1000f)
     */
    public abstract void update(float delta);
    
    /**
     * Updates the position and/or size of the rectangle that the Character is 
     * contained in. Allows for hit detection, as well as preventing the character
     * from falling through platforms.
     */
    public abstract void updateRects();
    
    // GETS
        /**
         * Returns the current X of the Character.
         * 
         * @return  X value
         */
        public abstract float getX();

        /**
         * Returns the current Y of the Character.
         * 
         * @return  Y value
         */
        public abstract float getY();

        /**
         * Returns the width of the Character.
         * 
         * @return  width value
         */
        public abstract int getWidth();

        /**
         * Returns the height of the Character.
         * 
         * @return  height value
         */
        public abstract int getHeight();

        /**
         * Returns the rectangle that the Character is contained in
         * 
         * @return  rectangle
         */
        public abstract Rectangle getRect();
    
    
    //CHANGE
        /**
         * Changes the character's current x position.
         * 
         * @param newX  New x position to be changed to.
         */
        public abstract void changeX(float newX);

         /**
         * Changes the character's current y position.
         * 
         * @param newY  New y position to be changed to.
         */
        public abstract void changeY(float newY);
}
