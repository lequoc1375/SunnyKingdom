package scenes;

import static main.GameStates.MENU;
import static main.GameStates.*;

import java.awt.Color;
import java.awt.Graphics;

import UI.Button;
import main.Game;

public class Setting extends GameScenes implements SceneMethod  {
	
	private Button Menus;

	public Setting(Game game) {
		super(game);
		
		//set position and size of Menu
		Menus = new Button(10, 10, 100, 30, "MENU");
		
	}

	@Override
	public void render(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillRect(0,0,960,640);		
			Menus.draw(g);//draw the rectangle contains Menu
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (Menus.rectangleCheck().contains(x, y)) {
            setGameState(MENU);
        }
	}

	@Override
	public void mouseMoved(int x, int y) {
		 Menus.setHovered(Menus.rectangleCheck().contains(x, y));
		
	}

	@Override
	public void mousePressed(int x, int y) {
		Menus.setMousePressed(Menus.rectangleCheck().contains(x, y));
		
	}

	@Override
	public void mouseReleased(int x, int y) {
		Menus.resetButton(); // Reset the button state
		
	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
