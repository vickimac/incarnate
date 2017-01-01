package incarnate.framework.animation;

import java.awt.Image;
/**
 * An individual frame for an animation.
 * 
 *  * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class Frame {
    
    private Image image;
    private double duration;
    
    /**
     * Sets the image for the frame and its duration to the Frame object.
     * 
     * @param image     Image to be assigned to the frame.
     * @param duration  Duration of the frame in the animation.
     */
    public Frame(Image image, double duration)
    {
        this.image = image;
        this.duration = duration;
    }
    
    /**
     * Returns the duration of the individual frame.
     * 
     * @return  duration    Duration of the frame.
     */
    public double getDuration()
    {
        return duration;
    }
    
    /**
     * Returns the image of the individual frame.
     * @return  image       Image assigned to the frame.
     */
    public Image getImage()
    {
        return image;
    }
}
