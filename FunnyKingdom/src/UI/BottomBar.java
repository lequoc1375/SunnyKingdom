package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import UI.Button;
import handlers.tileManagers;
import objects.tile;
import scenes.Playing;

import static main.GameStates.*;


public class BottomBar {
	private int x, y, Width, Height;
	private Button Menus; // Declare the Menus button
	private Playing playing;
	private ArrayList<Button> tileButton = new ArrayList<>();
	public BottomBar(int x, int y, int Width, int Height, Playing playing) {
		this.x = x;
		this.y = y;
		this.Width	= Width;
		this.Height = Height;
		this.playing = playing; 
		initButton();
	}
	 
	
	public void initButton() {
		Menus = new Button(0, 640, 100, 100, "MENU");
		int width  = 50;
		int height = 50;
		int xCor = 120;
		int yCor = 640;
		int xChange = (int) (width * 1.1f);
		int i = 0;
		for(tile tile : playing.gettileManager().tiles) {
			tileButton.add(new Button(xCor + xChange*(i++),yCor,width,height,tile.getName()));
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(220,123,15));
		g.fillRect(x, y, Width, Height);
		drawButton(g);
	}
	
	public void drawButton(Graphics g) {
        Menus.draw(g);
        for(Button buttons : tileButton) {
        	buttons.draw(g);
        }
	}

    public void mouseClicked(int x, int y) {
        if (Menus.rectangleCheck().contains(x, y)) {
            setGameState(MENU);
        }
    }

    public void mouseMoved(int x, int y) {
        Menus.setHovered(Menus.rectangleCheck().contains(x, y));
    }


    public void mousePressed(int x, int y) {
        Menus.setMousePressed(Menus.rectangleCheck().contains(x, y));
    }


    public void mouseReleased(int x, int y) {
        Menus.resetButton(); // Reset the button state
    }
}
