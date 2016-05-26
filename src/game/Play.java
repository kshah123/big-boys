package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.*;

public class Play extends BasicGameState{
	
	int menuX = 1000;
	int menuY = 1000;
	
	public Play(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
			gfx.drawRect(menuX, menuY, 100, 100);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			if(menuX == 1000 && menuY == 1000){
				menuX = 100;
				menuY = 100;
			} else if(menuX == 100 && menuY == 100){
				menuX = 1000;
				menuY = 1000;
			}
		}
	}

	public int getID() {
		return 1;
	}

}
