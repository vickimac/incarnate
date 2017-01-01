package incarnate.game.main;

import javax.swing.JFrame;

import incarnate.game.main.Resources;
/**
 * The main of the program. Contains the game-specific values such as the title,
 * width and height. These can be changed if required and the entire program will
 * respond to the change.
 * 
 *  * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class GameMain {
    
    private static final String GAME_TITLE = "Incarnate";
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 500;
    public static Game sGame;
    
    /**
     * Sets up the window and the game. Also plays the menu intro.
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame(GAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        sGame = new Game(GAME_WIDTH, GAME_HEIGHT);
        frame.add(sGame);
        frame.pack();
        frame.setVisible(true);
        Resources.menuIntro.play();
    }
}
