package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play1 extends BasicGameState {

	Animation penai, movingUp, movingDown, movingLeft, movingRight;
	Image lvlOneMap;
	int [] duration = {200,200};
	float penaiPosX = 0;
	float penaiPosY = 0;
	float shiftX = penaiPosX + 270;
	float shiftY = penaiPosY + 180;
	
	public Play1(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}

	public int getID() {
		return 4;
	}
}
