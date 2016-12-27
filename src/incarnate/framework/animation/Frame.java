/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.framework.animation;

import java.awt.Image;
/**
 *
 * @author Vicki
 */
public class Frame {
    
    private Image image;
    private double duration;
    
    public Frame(Image image, double duration)
    {
        this.image = image;
        this.duration = duration;
    }
    
    public double getDuration()
    {
        return duration;
    }
    
    public Image getImage()
    {
        return image;
    }
}
