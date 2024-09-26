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
		tiles.add(Grass = new tile(getSprite(19,0), id++, "Grass"));		
		tiles.add(Water = new tile(getSprite(19,13),id++, "Water"));	
		tiles.add(Tree = new tile(getSprite(10,12),id++, "Tree"));	
		tiles.add(Road = new tile(getSprite(14,12),id++, "Road"));	
	}

	private void loadAtlas() {
		atlas = loadSave.getSpiritAtlas(); 
	}
	
	public BufferedImage getSprite(int id) {
		return tiles.get(id).getSprite();
	}
	//Change depend on developer
	private BufferedImage getSprite(int x, int y) {
		return atlas.getSubimage(x*16, y*16, 16, 16);
	}

}
