package incarnate.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import incarnate.framework.animation.Animation;
import incarnate.framework.animation.Frame;

public class Resources {
	
	public static BufferedImage atyx_lidle1, atyx_lidle2, atyx_lidle3, atyx_lidle4, atyx_lidle5,
								atyx_ridle1, atyx_ridle2, atyx_ridle3, atyx_ridle4, atyx_ridle5,
								atyx_lrun1, atyx_lrun2, atyx_lrun3, atyx_lrun4,
								atyx_rrun1, atyx_rrun2, atyx_rrun3, atyx_rrun4,
								atyx_ljump1, atyx_ljump2,
								atyx_rjump1, atyx_rjump2,
								menuBG, menuLogo,
								cloudsBG,
								grassPlatform1,
								hector_right, hector_left;
	
	public static AudioClip menuIntro, cellAfraid, songMarket, songWest,
							menuBeep, menuSelect,
							jumpSound;
	
	public static Color halfBlack;
	
	public static Animation atyx_lidleAnim, atyx_ridleAnim,
							atyx_lrunAnim, atyx_rrunAnim,
							atyx_rjumpAnim1, atyx_rjumpAnim2, atyx_ljumpAnim1, atyx_ljumpAnim2;
	
	public static void load()
	{
		// MENU RESOURCES
		menuIntro = loadSound("sounds/Intro.wav");
		cellAfraid = loadSound("sounds/Afraid.wav");
		songMarket = loadSound("sounds/Market.wav");
		songWest = loadSound("sounds/West.wav");
		
		menuBeep = loadSound("sounds/MenuBeep2.wav");
		menuSelect = loadSound("sounds/MenuBeep1.wav");
		
		menuBG = loadImage("graphics/menu_bg.png");
		menuLogo = loadImage("graphics/menu_logo.png");
		
		// ATYX RESOURCES
		
		jumpSound = loadSound("sounds/atyx_jump.wav");
			// Idle Right Animation
			atyx_ridle1 = loadImage("atyx/atyx_idle1.png");
			atyx_ridle2 = loadImage("atyx/atyx_idle2.png");
			atyx_ridle3 = loadImage("atyx/atyx_idle3.png");
			atyx_ridle4 = loadImage("atyx/atyx_idle4.png");
			atyx_ridle5 = loadImage("atyx/atyx_idle5.png");
			Frame ridleF1 = new Frame(atyx_ridle1, .2f);
			Frame ridleF2 = new Frame(atyx_ridle2, .2f);
			Frame ridleF3 = new Frame(atyx_ridle3, .2f);
			Frame ridleF4 = new Frame(atyx_ridle4, .2f);
			Frame ridleF5 = new Frame(atyx_ridle5, .2f);
			atyx_ridleAnim = new Animation(ridleF1, ridleF2, ridleF3, ridleF4, ridleF5);
			
			// Run Right Animation
			atyx_rrun1 = loadImage("atyx/atyx_run1.png");
			atyx_rrun2 = loadImage("atyx/atyx_run2.png");
			atyx_rrun3 = loadImage("atyx/atyx_run3.png");
			atyx_rrun4 = loadImage("atyx/atyx_run4.png");
			Frame rrunF1 = new Frame(atyx_rrun1, .1f);
			Frame rrunF2 = new Frame(atyx_rrun2, .1f);
			Frame rrunF3 = new Frame(atyx_rrun3, .1f);
			Frame rrunF4 = new Frame(atyx_rrun4, .1f);
			atyx_rrunAnim = new Animation(rrunF1, rrunF2, rrunF3, rrunF4);
			
			// Jump Right Animation
			atyx_rjump1 = loadImage("atyx/atyx_jump1.png");
			Frame rjump1 = new Frame(atyx_rjump1, .5f);
			atyx_rjumpAnim1 = new Animation(rjump1);
			atyx_rjump2 = loadImage("atyx/atyx_jump2.png");
			Frame rjump2 = new Frame(atyx_rjump2, .5f);
			atyx_rjumpAnim2 = new Animation(rjump2);
			
			// Idle Left Animation
			atyx_lidle1 = loadImage("atyx/atyx_lidle1.png");
			atyx_lidle2 = loadImage("atyx/atyx_lidle2.png");
			atyx_lidle3 = loadImage("atyx/atyx_lidle3.png");
			atyx_lidle4 = loadImage("atyx/atyx_lidle4.png");
			atyx_lidle5 = loadImage("atyx/atyx_lidle5.png");
			Frame lidleF1 = new Frame(atyx_lidle1, .2f);
			Frame lidleF2 = new Frame(atyx_lidle2, .2f);
			Frame lidleF3 = new Frame(atyx_lidle3, .2f);
			Frame lidleF4 = new Frame(atyx_lidle4, .2f);
			Frame lidleF5 = new Frame(atyx_lidle5, .2f);
			atyx_lidleAnim = new Animation(lidleF1, lidleF2, lidleF3, lidleF4, lidleF5);
			
			// Run Left Animation
			atyx_lrun1 = loadImage("atyx/atyx_lrun1.png");
			atyx_lrun2 = loadImage("atyx/atyx_lrun2.png");
			atyx_lrun3 = loadImage("atyx/atyx_lrun3.png");
			atyx_lrun4 = loadImage("atyx/atyx_lrun4.png");
			Frame lrunF1 = new Frame(atyx_lrun1, .1f);
			Frame lrunF2 = new Frame(atyx_lrun2, .1f);
			Frame lrunF3 = new Frame(atyx_lrun3, .1f);
			Frame lrunF4 = new Frame(atyx_lrun4, .1f);
			atyx_lrunAnim = new Animation(lrunF1, lrunF2, lrunF3, lrunF4);
			
			// Jump Left Animation
			atyx_ljump1 = loadImage("atyx/atyx_ljump1.png");
			Frame ljump1 = new Frame(atyx_ljump1, .5f);
			atyx_ljumpAnim1 = new Animation(ljump1);
			atyx_ljump2 = loadImage("atyx/atyx_ljump2.png");
			Frame ljump2 = new Frame(atyx_ljump2, .5f);
			atyx_ljumpAnim2 = new Animation(ljump2);
		
		// NPC RESOURCES
			// HECTOR
			hector_left = loadImage("npc/hector_left.png");
			hector_right = loadImage("npc/hector_right.png");
			
			
		// COLOUR RESOURCES
		halfBlack = new Color(0, 0, 0, 192);
		
		//LEVEL RESOURCES
		cloudsBG = loadImage("graphics/clouds_bg.png");
		
		grassPlatform1 = loadImage("graphics/grassPlatform1.png");
	}
	 
	private static AudioClip loadSound(String filename)
	{
		URL fileURL = Resources.class.getResource("/resources/" + filename);
		return Applet.newAudioClip(fileURL);
	}
	
	private static BufferedImage loadImage(String filename)
	{
		BufferedImage img = null;
		try {
			img = ImageIO.read(Resources.class.getResourceAsStream("/resources/" + filename));
		} catch (IOException e) {
			System.out.println("Error while reading: " + filename);
			e.printStackTrace();
		}
		return img;
	}

}
