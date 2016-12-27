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
public interface Character {
    
    public abstract void update(float delta);
    
    public abstract void updateRects();
    
    // GETS
    public abstract float getX();
    
    public abstract float getY();
    
    public abstract int getWidth();
    
    public abstract int getHeight();

    public abstract Rectangle getRect();
    
    
    //CHANGE
    public abstract void changeX(float newX);
    
    public abstract void changeY(float newY);
}
