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
		background = new Image("res/backgrounds/background.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(startButton, 360, 50);
		g.drawImage(creditsButton, 360, 140);
		g.drawImage(exitButton, 360, 230);
		g.drawString("Big Boys: Penai, the Zone and the Plate", 50, 100);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		//Check if user clicks exit button
		if(ypos > 90 && ypos < 140 && xpos >360 && xpos < 510){
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}
		//Check if user clicks credits button
		if(ypos > 180 && ypos < 230 && xpos > 360 && xpos < 510){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(2);
			}
		}
		//Check if user clicks play button
		if(ypos > 270 && ypos < 320 && xpos > 360 && xpos < 510){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(4);
			}
		}
	}

	public int getID() {
		return 0;
	}

}
