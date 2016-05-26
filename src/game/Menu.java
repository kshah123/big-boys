package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
	Image startButton;
	Image creditsButton;
	Image helpButton;
	Image settingsButton;
	Image exitButton;
	
	public Menu(int state) throws SlickException{

	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		startButton = new Image("res/btn/startButton.png");
		creditsButton = new Image("res/btn/creditsButton.png");
		helpButton = new Image("res/btn/helpButton.png");
		exitButton = new Image("res/btn/exitButton.jpg");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

	}

	public int getID() {
		return 0;
	}

}
