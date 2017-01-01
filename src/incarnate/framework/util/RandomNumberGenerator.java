package incarnate.framework.util;

import java.util.Random;
/**
 * Generates a random number. Much more efficient to use this than the standard
 * Java method. Can also create custom methods if required.
 * 
 *  * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 * 
 * @author Victoria Maciver
 * @version 0.1
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
