package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.GameStates;
import main.Game;

public class Mouse implements MouseListener, MouseMotionListener {
	private Game game;
	public Mouse(Game game) {
		this.game = game;		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
			switch(GameStates.gameStates){
			case MENU:
				game.getMenu().mouseMoved(e.getX(),e.getY());	
				break;
			case PLAYING:
				game.getPlaying().mouseMoved(e.getX(),e.getY());
				break;
			case SETTING:
				game.getSetting().mouseMoved(e.getX(), e.getY());
				break;
			default:
				break;
				
			}
			
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			switch(GameStates.gameStates){
			case MENU:
				game.getMenu().mouseClicked(e.getX(),e.getY());				
				break;
			case PLAYING:
				game.getPlaying().mouseClicked(e.getX(),e.getY());
				break;
			case SETTING:
				game.getSetting().mouseClicked(e.getX(),e.getY());
				break;
			default:
				break;
				
			}
			System.out.println("Left mouse position" + e.getX() + ": " + e.getY());
			
		}
		else if(e.getButton() == MouseEvent.BUTTON3) {
			
			System.out.println("Right mouse position" + e.getX() + ": " + e.getY());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(GameStates.gameStates){
		case MENU:
			game.getMenu().mousePressed(e.getX(),e.getY());	
			break;
		case PLAYING:
			game.getPlaying().mousePressed(e.getX(),e.getY());	
			break;
		case SETTING:
			game.getSetting().mousePressed(e.getX(),e.getY());	
			break;
		default:
			break;
			
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(GameStates.gameStates){
		case MENU:
			game.getMenu().mouseReleased(e.getX(),e.getY());	
			break;
		case PLAYING:
			game.getPlaying().mouseReleased(e.getX(),e.getY());	
			break;
		case SETTING:
			game.getSetting().mouseReleased(e.getX(),e.getY());	
			break;
		default:
			break;
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
