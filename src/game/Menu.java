package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState{
	
	Image logo, background, menuBar;
	int xpos;
	int ypos;
	
	public Menu(int state) throws SlickException{

	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		background = new Image("res/backgrounds/background.png");
		menuBar = new Image("res/backgrounds/menuBar.png");
		logo = new Image("res/backgrounds/logo.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(background, 0, 0);
		g.drawImage(menuBar, 0, 0);
		g.drawImage(logo, 800, 40);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		xpos = Mouse.getX();
		ypos = Mouse.getY();
		//Check if user clicks help button
		if(ypos > 5 && ypos < 82 && xpos > 590 && xpos < 820){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(3);
			}
		}
		//Check if user clicks exit button
		if(ypos > 5 && ypos < 82 && xpos >830 && xpos < 1045){
			if(Mouse.isButtonDown(0)){
				System.exit(0);
			}
		}
		//Check if user clicks credits button
		if(ypos > 5 && ypos < 82 && xpos > 278 && xpos < 562){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(2);
			}
		}
		//Check if user clicks play button
		if(ypos > 5 && ypos < 82 && xpos > 40 && xpos < 260){
			if(Mouse.isButtonDown(0)){
				sbg.enterState(4, new EmptyTransition(), new HorizontalSplitTransition());
			}
		}
	}

	public int getID() {
		return 0;
	}

}
