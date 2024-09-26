package main;

import javax.swing.JFrame;
import scenes.Menu;
import scenes.Playing;
import scenes.Setting;

public class Game extends JFrame implements Runnable {

    private final double targetFPS = 60;    
    private final double targetUPS = 60;  

          
    private int updateCount;                
    private long lastCheckTime;            
    private int frameCount;                    
    private Thread gameLoopThread;   
    

    
    //Classes
    private Renders render;
    private Menu menu;
    private Playing playing;
    private Setting setting;

    
    public static void main(String[] args) {
        Game game = new Game(); 
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
