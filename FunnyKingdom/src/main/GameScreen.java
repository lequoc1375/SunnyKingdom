package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class GameScreen extends JPanel {

    private Dimension size;
    
    private int NumberofImageCol = 30;
    private int NumberofImageRow = 20;
    

    private final int scale = 1;
    private final int maxScreenHeight =  NumberofImageRow * scale * 32;
    private final int maxScreenWidth =  NumberofImageCol *scale * 32;


    private Game game;

    public GameScreen(Game game) {
    	this.game = game;
        SetSizeScreen();
    }

    private void SetSizeScreen() {
    	size = new Dimension(maxScreenWidth,maxScreenHeight);
    	setMinimumSize(size);
    	setMaximumSize(size);
    	setPreferredSize(size);
	}



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        game.getRender().renders(g);
    }


}
