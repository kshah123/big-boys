package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Game extends StateBasedGame{
	
	// Name of game in title bar
	public static final String gameName = "Big Boys: The Plate";
	
	// List of states:
	public static final int menu = 0;
	public static final int play = 1;
	public static final int credits = 2;
	public static final int help = 3;
	public static final int play1 = 4;
	
	// Creating memory allocation for states
	public Game(String gameName) throws SlickException{
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Credits(credits));
		this.addState(new Help(help));
		this.addState(new Play1(play1));
	}
	
	// Initializing States into game
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(credits).init(gc, this);
		this.getState(help).init(gc, this);
		this.getState(play1).init(gc, this);
		this.enterState(menu);
	}
	
	// Main Game
	public static void main(String[] args) {
		AppGameContainer appGC;
		try {
			appGC = new AppGameContainer(new Game(gameName));
			appGC.setDisplayMode(1080, 720, false);;
			appGC.start();
		} catch(SlickException e){
			e.printStackTrace();
		}
	}
}
