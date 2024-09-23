package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;

public class Menu extends GameScenes implements SceneMethod  {
	
	private final int tileScreen = 32;
    private Random random;
    private BufferedImage Image;    
    private ArrayList<BufferedImage> sprites = new ArrayList<>();


	public Menu(Game game) {
		super(game);
        random = new Random();
        loadImage(); 
		loadSprites();
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                g.drawImage(sprites.get(getRndInt()), i * tileScreen, j * tileScreen, null);
            }
        }	
	}
	//GET IMAGE ADDRESS
    private void loadImage() {              
        InputStream is = getClass().getResourceAsStream("/ground/GRASS+.png");        
        try {
            Image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
	
	private void loadSprites() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 25; j++) {
                sprites.add(Image.getSubimage(j * 16, i * 16, 16, 16));
            }
        }
    }
	
    private int getRndInt() {
        return random.nextInt(25 * 14);
    }

}
