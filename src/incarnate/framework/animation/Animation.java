package incarnate.framework.animation;

import java.awt.Graphics;
/**
 * Allows for animation by sequencing frames by their duration.
 * 
 * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 * 
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class Animation {
    
    private Frame[] frames;
    private double[] frameEndTimes;
    private int currentFrameIndex = 0;
    
    private double totalDuration = 0;
    private double currentTime = 0;
    
    /**
     * Takes all the input frame objects and assigns them to the frames and
     * frameEndTimes arrays.
     * 
     * @param frames    Multiple frames, may be an array, but can also just be
     *                  multiple Frame parameters.
     */
    public Animation(Frame... frames)
    {
        this.frames = frames;
        frameEndTimes = new double[frames.length];
        
        for (int i = 0; i < frames.length; i++)
        {
            Frame f = frames[i];
            totalDuration += f.getDuration();
            frameEndTimes[i] = totalDuration;
        }
    }
    
    /**
     * Called during the game's update loop. Allows for the animation to cycle 
     * through the frames.
     * 
     * @param increment     Time of delta
     *                      ((updateDurationMillis + sleepDurationMillis) / 1000f)                 
     */
    public synchronized void update(float increment)
    {
        currentTime += increment;
        
        if (currentTime > totalDuration)
        {
            wrapAnimation();
        }
        
        while (currentTime > frameEndTimes[currentFrameIndex])
        {
            currentFrameIndex++;
        }
    }
    
    /**
     * Resets the animation back to the start and resets currentTime, but in a
     * way that allows for better animation fluidity.
     */
    private synchronized void wrapAnimation()
    {
        currentFrameIndex = 0;
        currentTime %= totalDuration;
    }
    
    /**
     * Draws each frame.
     * @param g     Graphics
     * @param x     X of the frame (to connect it to it's object)
     * @param y     Y of the frame (to connect it to it's object)
     */
    public synchronized void render(Graphics g, int x, int y)
    {
        g.drawImage(frames[currentFrameIndex].getImage(), x, y, null);
    }
    
    /**
     * Draws each frame.
     * @param g         Graphics
     * @param x         X of the frame (to connect it to it's object)
     * @param y         Y of the frame (to connect it to it's object)
     * @param width     Width of the frame (they may have different sizes)
     * @param height    Height of the frame (they may have different sizes)
     */
    public synchronized void render(Graphics g, int x, int y, int width, int height)
    {
        g.drawImage(frames[currentFrameIndex].getImage(), x, y, width, height, null);
    }
}
