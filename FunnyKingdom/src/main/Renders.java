package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Renders {
	
	Game game;
	public Renders (Game game) {
		this.game = game;
	}
	
    
	//RENDER IMAGE 
	public void renders(Graphics g) {
		
		switch(GameStates.gameStates) {
		case MENU:
			game.getMenu().render(g);	       
			break;
		case PLAYING:
			game.getPlaying().render(g);
			break;
		case SETTING:
			game.getSetting().render(g);
			break;
		}		
	}
}
