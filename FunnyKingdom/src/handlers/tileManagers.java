package handlers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import objects.tile;

public class tileManagers {
	
	public tile Grass, Water, Tree, Road;
	public BufferedImage atlas;
	public ArrayList<tile> tiles = new ArrayList<>();
	
	public tileManagers() {		
		loadAtlas();
		creatingTile();		
	}

	private void creatingTile() {
		tiles.add(Grass = new tile(getSprite(19,0)));		
		tiles.add(Water = new tile(getSprite(19,13)));	
		tiles.add(Tree = new tile(getSprite(10,12)));	
		tiles.add(Road = new tile(getSprite(14,12)));	
	}

	private void loadAtlas() {}
	
	public BufferedImage getSprite(int id) {
		return tiles.get(id).getSprite();
	}
	
	private BufferedImage getSprite(int x, int y) {
		return atlas.getSubimage(x*16, y*16, 16, 16);
	}

}
