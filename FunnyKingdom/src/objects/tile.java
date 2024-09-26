package objects;

import java.awt.image.BufferedImage;

public class tile {
	
	private BufferedImage sprites;
	private int id;

	private String name;
	
	public tile(BufferedImage sprites, int id, String name) {
		this.sprites = sprites;
		this.id = id;
		this.name = name;
		
	}
	

	public BufferedImage getSprite() {
		return sprites;
	}
	
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}
	
	
}
