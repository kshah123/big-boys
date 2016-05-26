package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Game extends StateBasedGame{
	
	public static final String gameName = "Big Boys Video Game";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int credits = 2;
	public static final int help = 3;
	public static final int settings = 4;
	
	public Game(String gameName) throws SlickException{
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Credits(credits));
		this.addState(new Help(help));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(credits).init(gc, this);
		this.getState(help).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		AppGameContainer appGC;
		try {
			appGC = new AppGameContainer(new Game(gameName));
			appGC.setDisplayMode(540, 360, false);;
			appGC.start();
		} catch(SlickException e){
			e.printStackTrace();
		}
	}
}
