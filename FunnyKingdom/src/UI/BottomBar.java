package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
	private tile selectedTile;
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
		int width  = 64;
		int height = 64;
		int xCor = 120;
		int yCor = 640;
		int xChange = (int) (width * 1.1f);
		int i = 0;
		for(tile tile : playing.gettileManager().tiles) {
			tileButton.add(new Button(xCor + xChange*i,yCor,width,height,tile.getName(),i));
			i++;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(new Color(220,123,15));
		g.fillRect(x, y, Width, Height);
		drawButton(g);
	}
	
	public void drawButton(Graphics g) {
        Menus.draw(g);
        drawTileButton(g);
        drawSelectedTile(g);

        
	}

    private void drawSelectedTile(Graphics g) {
		if(selectedTile != null) {
			g.drawImage(selectedTile.getSprites(),800,650,80, 80, null);
			//Border
			g.setColor(Color.BLACK);
			g.drawRect(800,650,80,80);		
		}
		
	}


	private void drawTileButton(Graphics g) {
    	for(Button buttons : tileButton) {
        	g.drawImage(getButtonImage(buttons.getID()), buttons.xCor, buttons.yCor,buttons.Width, buttons.Height, null);
        	
        	//MouseHovered
        	if(buttons.isMouseOver()) {
        		g.setColor(Color.white);
        	}
        	else {
            	g.setColor(Color.BLACK);
        	}
        	//Border
        	g.drawRect(buttons.xCor, buttons.yCor, buttons.Width, buttons.Height);
        	
        	//MousePressed
        	
        	if(buttons.isMousePressed()) {
        		g.drawRect(buttons.xCor+1, buttons.yCor+1, buttons.Width-2, buttons.Height-2);
        		g.drawRect(buttons.xCor+2, buttons.yCor+2, buttons.Width-4, buttons.Height-4);
        	}
        	
        	
        }
		
	}
    
    public BufferedImage getButtonImage(int id) {
    	return playing.gettileManager().getSprite(id);
    }


	public void mouseClicked(int x, int y) {
        if (Menus.rectangleCheck().contains(x, y)) {
            setGameState(MENU);
        }
        else {
        	for(Button buttons : tileButton) {
        		if(buttons.rectangleCheck().contains(x,y)) {
        			selectedTile = playing.gettileManager().getTile(buttons.getID());
        			playing.setSelectedTile(selectedTile);
        			return;
        		}
        	}
        }
        
    }

    public void mouseMoved(int x, int y) {
        Menus.setHovered(Menus.rectangleCheck().contains(x, y)); // Fixed missing semicolon
        if (!Menus.rectangleCheck().contains(x, y)) {
            for (Button button : tileButton) { // Updated variable name for clarity
                button.setHovered(button.rectangleCheck().contains(x, y)); // Check if hovered over each button
            }
        }
    }


    public void mousePressed(int x, int y) {
        Menus.setMousePressed(Menus.rectangleCheck().contains(x, y));
        if (!Menus.rectangleCheck().contains(x, y)) {
            for (Button button : tileButton) {
                button.setMousePressed(button.rectangleCheck().contains(x, y)); // Check if pressed
            }
        }
    }


    public void mouseReleased(int x, int y) {
        Menus.resetButton(); // Reset the button state
        
        for(Button buttons : tileButton) {
        	buttons.resetButton();
        }
    }
}
