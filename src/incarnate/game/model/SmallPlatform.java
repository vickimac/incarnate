/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.model;

import java.awt.Rectangle;

/**
 *
 * @author Vicki
 */
public class SmallPlatform implements Platform {
    
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle rect;
    
    public SmallPlatform(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        rect = new Rectangle();
        updateRects();
    }
    
    public void updateRects()
    {
        rect.setBounds((int) x, (int) y, width, height);
    }
    
    //GETS
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
    
    public Rectangle getRect()
    {
        return rect;
    }
}
