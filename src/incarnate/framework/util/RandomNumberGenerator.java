/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.framework.util;

import java.util.Random;
/**
 *
 * @author Vicki
 */
public class RandomNumberGenerator {
    
    private static Random rand = new Random();
    
    public static int getRandIntBetween(int lowerBound, int upperBound)
    {
        return rand.nextInt(upperBound - lowerBound) + lowerBound;
    }
    
    public static int getRandInt(int upperBound)
    {
        return rand.nextInt(upperBound);
    }
}
