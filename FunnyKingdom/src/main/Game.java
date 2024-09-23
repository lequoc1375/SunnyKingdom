package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Inputs.KeyBoard;
import Inputs.Mouse;
import scenes.Menu;
import scenes.Playing;
import scenes.Setting;

public class Game extends JFrame implements Runnable {
	final int age;
    private final double targetFPS = 60;    
    private final double targetUPS = 60;  

          
    private int updateCount;                
    private long lastCheckTime;            
    private int frameCount;                    
    private Thread gameLoopThread;   
    
    Mouse mouse;
    KeyBoard keyboard;
    
    //Classes
    private Renders render;
    private Menu menu;
    private Playing playing;
    private Setting setting;

    
    public static void main(String[] args) {
        Game game = new Game(); 
        game.initInputs();
        game.start();
    }

    public Game() {                      
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initClasses();
        pack();
        setLocationRelativeTo(null);
        setVisible(true); 
        setResizable(false);
    }
    
    private void initClasses() {
        render = new Renders(this);
        GameScreen gameScreen = new GameScreen(this);
        add(gameScreen);    
        menu = new Menu(this);
        playing = new Playing(this);
        setting = new Setting(this);
		
	}

	

	private void initInputs() {
    	mouse = new Mouse();
    	keyboard = new KeyBoard();
    	addMouseListener(mouse);
    	addMouseMotionListener(mouse);
    	addKeyListener(keyboard);
    	setFocusable(true);
    	requestFocus();
    }
    
    private void start() {
        gameLoopThread = new Thread(this);
        gameLoopThread.start();
    }


    
    private void updateGameLogic() {        

    }

    
    private void showFPSAndUpdates() {      
        if (System.currentTimeMillis() - lastCheckTime >= 1000) {
            System.out.println("FPS: " + frameCount + " | Updates: " + updateCount);
            frameCount = 0;
            updateCount = 0;
            lastCheckTime = System.currentTimeMillis();
        }
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000 / targetFPS; 
        double timePerUpdate = 1000000000 / targetUPS; 
        long lastFrameTime = System.nanoTime();        
        long lastUpdateTime = System.nanoTime();       

        while (true) {
            if (System.nanoTime() - lastFrameTime >= timePerFrame) {
                lastFrameTime = System.nanoTime();
                repaint();
                frameCount++;
            }

            if (System.nanoTime() - lastUpdateTime >= timePerUpdate) {
                lastUpdateTime = System.nanoTime();
                updateGameLogic();                    
                updateCount++;
            }

            showFPSAndUpdates();          
        }
    }
    
    //Getting and setter
    public Renders getRender() {
		return render;    	
    }

	public Menu getMenu() {
		return menu;
	}
	
	public Playing getPlaying() {
		return playing;
	}


	public Setting getSetting() {
		return setting;
	}


}
