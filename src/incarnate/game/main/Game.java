package incarnate.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import incarnate.framework.util.InputHandler;
import incarnate.game.state.LoadState;
import incarnate.game.state.State;

/**
 * Sets up everything required for the game to play. This includes the window,
 * JPanel, update and render loops, input, and game image and thread. Mainly a
 * collection of technical details that allow the game to run.
 * 
 *  * Referenced from:
 *      Cho, J. (2014) The Beginner's Guide to Android Game Development.
 * 
 * @author Victoria Maciver
 * @version 0.1
 */
public class Game extends JPanel implements Runnable {
    
    private int gameWidth;
    private int gameHeight;
    private Image gameImage;
    
    private Thread gameThread;
    private volatile boolean running;
    private volatile State currentState;
    
    private InputHandler inputHandler;
    
    /**
     * Sets up window with specified width and height.
     * 
     * @param gameWidth     Width of the window and game.
     * @param gameHeight    Height of the window and games.
     */
    public Game(int gameWidth, int gameHeight)
    {
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        setPreferredSize(new Dimension(gameWidth, gameHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
    }
    
    /**
     * Allows for the current running state to be changed.
     * 
     * @param newState  State to be changed to.
     */
    public void setCurrentState(State newState)
    {
        System.gc();
        newState.init();
        currentState = newState;
        inputHandler.setCurrentState(currentState);
    }
    
    /**
     * Initialises everything.
     */
    @Override
    public void addNotify()
    {
        super.addNotify();
        initInput();
        setCurrentState(new LoadState());
        initGame();
    }
    
    /**
     * Initialises the game - sets it to running and starts the game thread.
     */
    private void initGame()
    {
        running = true;
        gameThread = new Thread(this, "Game Thread");
        gameThread.start();
    }
    
    /**
     * Running loop. Handles the delta time (required for all update and render
     * loops throughout the program).
     */
    public void run()
    {
        // These variables should sum up to 17 on every iteration.
        long updateDurationMillis = 0; // Measures both update AND render.
        long sleepDurationMillis = 0; // Measures sleep.
        
        while (running)
        {
            long beforeUpdateRender = System.nanoTime();
            long deltaMillis = updateDurationMillis + sleepDurationMillis;
            
            updateAndRender(deltaMillis);
            
            updateDurationMillis = (System.nanoTime() - beforeUpdateRender) / 1000000L;
            sleepDurationMillis = Math.max(2, 17 - updateDurationMillis);
            
            try
            {
                Thread.sleep(sleepDurationMillis);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        // End game immediately before running becomes false.
        System.exit(0);
    }
    
    /**
     * Updates and renders the current state.
     * 
     * @param deltaMillis   updateDurationMillis + sleepDurationMillis
     */
    private void updateAndRender(long deltaMillis)
    {
        currentState.update(deltaMillis / 1000f);
        prepareGameImage();
        currentState.render(gameImage.getGraphics());
        renderGameImage(getGraphics());
    }
    
    /**
     * Sets and draws the game image inside the window.
     */
    private void prepareGameImage()
    {
        if (gameImage == null)
        {
            gameImage = createImage(gameWidth, gameHeight);
        }
        Graphics g = gameImage.getGraphics();
        g.clearRect(0, 0, gameWidth, gameHeight);
    }
    
    /**
     * Sets running to false, which stops all update and render loops and should
     * automatically close the program.
     */
    public void exit()
    {
        running = false;
    }
    
    /**
     * Draws the game image to the window.
     * 
     * @param g     Graphics
     */
    private void renderGameImage(Graphics g)
    {
        if (gameImage != null)
        {
            g.drawImage(gameImage, 0, 0, null);
        }
        g.dispose();
    }
    
    /**
     * Initialises the input by setting up the InputHandler and assigning key
     * and mouse listeners to it.
     */
    private void initInput()
    {
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
    }
}
