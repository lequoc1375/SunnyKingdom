package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import UI.Button;
import main.Game;
import main.GameStates;

import static main.GameStates.*;

public class Menu extends GameScenes implements SceneMethod  {
	
	private final int tileScreen = 32;
    private Random random;
    private BufferedImage Image;    
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Button Playing, Quit,Setting;

	public Menu(Game game) {
		super(game);
        random = new Random();
        loadImage(); 
		loadSprites();
		initButtons();
		
	}

	private void initButtons() {
		Playing = new Button(0,320,320,30,"PLAY GAME");
		Setting = new Button(0,420,320,30,"SETTING");
		Quit	= new Button(0,520,320,30,"QUIT");
		
	}

	@Override
	public void render(Graphics g) {
		drawButton(g);
	}
	
	private void drawButton(Graphics g) {
		Playing.draw(g);
		Setting.draw(g);
		Quit.draw(g);
		
	}

	//GET IMAGE ADDRESS
	//Change depend on developer
    private void loadImage() {              
        InputStream is = getClass().getResourceAsStream("/ground/GRASS+.png");        
        try {
            Image = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
	//Change depend on developer
	private void loadSprites() {
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 25; j++) {
                sprites.add(Image.getSubimage(j * 16, i * 16, 16, 16));
            }
        }
    }
	//Change depend on developer
    private int getRndInt() {
        return random.nextInt(25 * 14);
    }

	@Override
	public void mouseClicked(int x, int y) {
		if(Playing.rectangleCheck().contains(x,y)) {
			setGameState(PLAYING);
		}
		else if(Setting.rectangleCheck().contains(x,y)) {
			setGameState(SETTING);
		}
		else if(Quit.rectangleCheck().contains(x,y)) {
			System.exit(0);
		}
		
		
	}

	@Override
	public void mouseMoved(int x, int y) {
		Playing.setHovered(Playing.rectangleCheck().contains(x, y));
		Setting.setHovered(Setting.rectangleCheck().contains(x, y));
		Quit.setHovered(Quit.rectangleCheck().contains(x, y));		
		
	}

	@Override
	public void mousePressed(int x, int y) {
		Playing.setMousePressed(Playing.rectangleCheck().contains(x,y));
		Setting.setMousePressed(Setting.rectangleCheck().contains(x,y));
		Quit.setMousePressed(Quit.rectangleCheck().contains(x,y));
	}

	private void checkButtonReleased(Button button, GameStates state, int x, int y) {
	    if (button.rectangleCheck().contains(x, y)) {
	        setGameState(state);
	    }
	    button.resetButton();
	}

	@Override
	public void mouseReleased(int x, int y) {
	    checkButtonReleased(Playing, PLAYING,x,y);
	    checkButtonReleased(Setting, SETTING,x,y);
	    checkButtonReleased(Quit, MENU,x,y);
	}




}
