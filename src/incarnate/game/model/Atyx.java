package incarnate.game.model;

/**
 * Atyx subclass of Player. Currently no custom actions.
 * 
 * Subclassed to allow future expansion. May have different characters with 
 * different abilities, run speeds, jump height, etc. May also allow player to
 * control different units such as vehicles that need to move differently.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class Atyx extends Player {
    
    public Atyx(float x, float y, int width, int height, int zoneWidth, int zoneHeight) {
        super(x, y, width, height, zoneWidth, zoneHeight);
    }
    
}
