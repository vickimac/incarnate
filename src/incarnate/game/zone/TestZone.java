package incarnate.game.zone;

import incarnate.framework.util.DialogText;
import incarnate.game.main.Resources;
import incarnate.game.model.Atyx;
import incarnate.game.model.Platform;
import incarnate.game.model.SmallPlatform;
import static incarnate.game.zone.Zone.ATYX_WIDTH;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Test Zone. Subclass of Zone. There is a lot of room for improvement,
 * especially with the design of the zone classes. This is just a Test Zone for
 * development, and will not make it into the actual game.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class TestZone extends Zone{
    
    DialogText dia = new DialogText();
    
    private Platform grassPlat1;
    
    /**
     * Initialises the zone. Plays the zone's music and creates platforms and
     * characters (including the player).
     */
    @Override
    public void init()
    {
        Resources.fireFlies.play();
        
        pfInvisible = new SmallPlatform(0, 610, ZONE_WIDTH, 150);
         atyx = new Atyx(160, (int) pfInvisible.getY() + ((int) pfInvisible.getHeight() / 2), ATYX_WIDTH, ATYX_HEIGHT, ZONE_WIDTH, ZONE_HEIGHT);
         
         grassPlat1 = new SmallPlatform(725, 500, 50, 10);
         
        try {
            dia.openDialog("test", "dialogbox", "0001");
        } catch (IOException ex) {
            Logger.getLogger(TestZone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Prevents the player from falling through platforms that are surfaces. May
     * change this in the future by creating a surface decorator for platforms.
     * 
     * @param delta     Time of delta
     *                  ((updateDurationMillis + sleepDurationMillis) / 1000f)
     */
    @Override
    public void updatePlatforms(float delta)
    {
        if (atyx.getVelY() >= 0)
        {
            if(atyx.getRect().intersects(pfInvisible.getRect()) || atyx.getRect().intersects(grassPlat1.getRect()))
            {
                if(atyx.getRect().intersects(pfInvisible.getRect()))
                {
                    atyx.changeY(pfInvisible.getY() - (ATYX_HEIGHT - 1));
                    atyx.jumpStop();
                }
                
                if(atyx.getRect().intersects(grassPlat1.getRect()))
                {
                    atyx.changeY(grassPlat1.getY() - (ATYX_HEIGHT - 1));
                    atyx.jumpStop();
                }
            }
            else
            {
                atyx.falling();
            }
        }
    }
    
    /**
     * Renders camera, zone and player.
     * 
     * @param g     Graphics
     */
    @Override
    public void render(Graphics g)
    {
        g.translate(-camX, -camY);
        renderZone(g);
        renderAtyx(g);
    }
    
    /**
     * Renders the graphics required for this specific zone.
     * 
     * @param g     Graphics
     */
    public void renderZone(Graphics g)
    {
        g.drawImage(Resources.cloudsBG, 0, 0, ZONE_WIDTH, ZONE_HEIGHT, null);
        g.drawImage(Resources.grassPlatform1, 700, 480, 101, 58, null);
    }
}
