package objects;

import java.awt.image.BufferedImage;

public class tile {
	
	private BufferedImage sprites; // Hình ảnh (sprite) của ô gạch
	private int id; // ID của ô gạch
	private String name; // Tên của ô gạch
	
	// Constructor: Khởi tạo ô gạch với sprite, ID, và tên
	public tile(BufferedImage sprites, int id, String name) {
		this.sprites = sprites;
		this.id = id;
		this.name = name;
	}

	// Trả về sprite của ô gạch
	public BufferedImage getSprites() {
		return sprites;
	}
	
	// Trả về ID của ô gạch
	public int getID() {
		return id;
	}
	
	// Trả về tên của ô gạch
	public String getName() {
		return name;
	}
}
