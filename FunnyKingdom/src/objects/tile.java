package objects;

import java.awt.image.BufferedImage;

public class tile {
	
	private BufferedImage sprites;
	
	public tile(BufferedImage sprites) {
		this.sprites = sprites;
		
	}
	
	public BufferedImage getTile() {
		return sprites;
		
	}
	

}
