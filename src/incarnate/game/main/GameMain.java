/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incarnate.game.main;

import javax.swing.JFrame;

import incarnate.game.main.Resources;
/**
 *
 * @author Vicki
 */
public class GameMain {
    
    private static final String GAME_TITLE = "Incarnate";
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 500;
    public static Game sGame;
    
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
