package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
	Image startButton;
	Image creditsButton;
	Image helpButton;
	Image exitButton;
	Image background;
	int xpos;
	int ypos;
	
	public Menu(int state) throws SlickException{

	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		startButton = new Image("res/btn/startButton.png");
		creditsButton = new Image("res/btn/creditsButton.png");
		helpButton = new Image("res/btn/helpButton.png");
		exitButton = new Image("res/btn/exitButton.png");
		background = new Image("res/background.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(startButton, 180, 60);
		g.drawImage(creditsButton, 180, 150);
		g.drawImage(exitButton, 180, 240);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		//Check if user clicks exit button
		if(ypos > 60 && ypos < 120 && xpos >180 && xpos < 360){
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}
		//Check if user clicks credits button
		if(ypos > 150 && ypos < 210 && xpos > 180 && xpos < 360){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(2);
			}
		}
		//Check if user clicks play button
		if(ypos > 240 && ypos < 300 && xpos > 180 && xpos < 360){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(1);
			}
		}
	}

	public int getID() {
		return 0;
	}

}
