package scenes;

import static main.GameStates.PLAYING;
import static main.GameStates.*;

import java.awt.Graphics;

import UI.BottomBar;
import UI.Button;
import handlers.tileManagers;
import helper.LevelBuilder;
import helper.loadSave;
import main.Game;
import objects.tile;

public class Playing extends GameScenes implements SceneMethod {
    private int[][] lvl;
    private tileManagers tileManager;    
    private BottomBar bottomBar;
    private Button Menus;
	private tile selectedTile;	
	private int mouseX, mouseY;
	private boolean AllowPosSelectedImg;
	private int lastTileX,lastTileY,lastTileID;
    public Playing(Game game) {
        super(game);
        lvl = LevelBuilder.getLevelData();
        tileManager = new tileManagers();        
         // Adjust the position and size as needed
        bottomBar = new BottomBar(0,640,960,100,this);
        //loadSave.createFile();
        //loadSave.writeToFile();
        
        //loadSave.ReadFile();
        
        createDefaultLevelMap();
        loadDefaultMap();
        
    }
    


	private void createDefaultLevelMap() {
		int[] arr = new int[30*20];
		for (int i = 0; i < arr.length ; i++) {
			arr[i] = 0;
		}
		loadSave.creatNewLevel("NewDefaultLevel", arr);
		
	}
    	

    private void loadDefaultMap() {
		lvl = loadSave.GetLevelData("NewDefaultLevel"); 
		
	}
    
	public void saveLevel() {
		loadSave.SaveLevel("NewDefaultLevel", lvl);
		
	}

	@Override
    public void render(Graphics g) {
        // Draw the level
        for (int i = 0; i < lvl.length; i++) {
            for (int j = 0; j < lvl[i].length; j++) {
                int id = lvl[i][j];
                g.drawImage(tileManager.getSprite(id), j * 32, i * 32, null);
            }
        }
        bottomBar.draw(g);
        drawFolowingSelectedTile(g);
        
        
    }
    
    private void drawFolowingSelectedTile(Graphics g) {
		if(selectedTile != null && AllowPosSelectedImg == true) {
			g.drawImage(selectedTile.getSprites(), mouseX , mouseY, 32, 32 ,null);
		}
		
	}
    //Connect to the BottomBar to take the selectedImage from class BottomBar.
    public void setSelectedTile(tile tiles) {
    	this.selectedTile = tiles;
    	AllowPosSelectedImg = true;
    }

	public tileManagers gettileManager() {
		return tileManager;
	}

    @Override
    public void mouseClicked(int x, int y) {
    	if(y >= 640) {
    		bottomBar.mouseClicked(x,y);
    	}
    	else {
    		changeTileDrawOnMap(mouseX,mouseY);
    	}
    }
    
    private void changeTileDrawOnMap(int x, int y) {
        if (selectedTile != null) {
            int tileX = x / 32;
            int tileY = y / 32;

            // Ensure indices are within bounds before accessing array
            if (tileX < 0 || tileX >= lvl[0].length || tileY < 0 || tileY >= lvl.length) {
                return;
            }

            // Avoid placing the same tile again
            if (lastTileX == x && lastTileY == y && lastTileID == selectedTile.getID()) {
                return;
            }

            lastTileX = tileX;
            lastTileY = tileY;
            lastTileID = selectedTile.getID();

            lvl[tileY][tileX] = selectedTile.getID();
        }
    }


	@Override
    public void mouseMoved(int x, int y) {
    	if(y >= 640) {
    		bottomBar.mouseMoved(x,y);
    		AllowPosSelectedImg = false;
    	}
    	else {
    		AllowPosSelectedImg = true;
    		mouseX = (x/32)*32;
    		mouseY = (y/32)*32;
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
    
    public void mouseDragged(int x, int y) {
    	if(y < 640 && x < 960 && y > 0) {
    		changeTileDrawOnMap(x,y);
    	}
    }

	
}
