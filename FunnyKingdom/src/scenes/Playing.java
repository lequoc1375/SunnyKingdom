package scenes;

import static main.GameStates.PLAYING;
import static main.GameStates.*;

import java.awt.Graphics;

import UI.BottomBar;
import UI.Button;
import handlers.tileManagers;
import helper.LevelBuilder;
import main.Game;

public class Playing extends GameScenes implements SceneMethod {
    private int[][] lv1;
    private tileManagers tileManager;    
    private BottomBar bottomBar;
    private Button Menus;
    public Playing(Game game) {
        super(game);
        lv1 = LevelBuilder.getLevelData();
        tileManager = new tileManagers();
        
        // Initialize the Menus button
         // Adjust the position and size as needed
        bottomBar = new BottomBar(0,640,960,100,this);
    }

    @Override
    public void render(Graphics g) {
        // Draw the level
        for (int i = 0; i < lv1.length; i++) {
            for (int j = 0; j < lv1[i].length; j++) {
                int id = lv1[i][j];
                g.drawImage(tileManager.getSprite(id), j * 32, i * 32, null); // Note: Changed indices for x and y
            }
        }
        bottomBar.draw(g);

    }
    
    public tileManagers gettileManager() {
		return tileManager;
	}

    @Override
    public void mouseClicked(int x, int y) {
    	if(y >= 640) {
    		bottomBar.mouseClicked(x,y);
    	}
    }
    
    @Override
    public void mouseMoved(int x, int y) {
    	if(y >= 640) {
    		bottomBar.mouseMoved(x,y);
    	}
    }

    @Override
    public void mousePressed(int x, int y) {
    	if(y >= 640) {
    		bottomBar.mousePressed(x,y);
    	}
    }

    @Override
    public void mouseReleased(int x, int y) {
    		bottomBar.mouseReleased(x,y);
    	}
}
