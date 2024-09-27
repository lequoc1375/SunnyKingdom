package handlers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helper.loadSave;
import objects.tile;

public class tileManagers {
	
	public tile Grass, Water, Tree, Road;
	public BufferedImage atlas;
	public ArrayList<tile> tiles = new ArrayList<>();
	
	public tileManagers() {		
		loadAtlas();
		creatingTile();		
	}
	//Change depend on developer
	private void creatingTile() {
		int id = 0;
		tiles.add(Water = new tile(getSprite(0,0),	id++, "Water"));	
		tiles.add(Grass = new tile(getSprite(8,1), 	id++, "Grass"));			
		tiles.add(Road = new tile(getSprite(9,0),	id++, "Road"));	
	}
	
	public tile getTile(int id) {
		return tiles.get(id);
	}

	private void loadAtlas() {
		atlas = loadSave.getSpiritAtlas(); 
	}
	
	public BufferedImage getSprite(int id) {
		return tiles.get(id).getSprites();
	}
	//Change depend on developer
	private BufferedImage getSprite(int x, int y) {
		return atlas.getSubimage(x*32, y*32, 32, 32);
	}

}
