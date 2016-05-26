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
		lvlOneMap = new Image("res/levelMap/lvlOneMap.png");
		Image[] walkUp = {new Image("res/sprites/penaisBack1.png"), new Image("res/sprites/penaisBack2.png")};
		Image[] walkDown = {new Image("res/sprites/penaisFront1.png"), new Image("res/sprites/penaisFront2.png")};
		Image[] walkLeft = {new Image("res/sprites/penaisLeft1.png"), new Image("res/sprites/penaisLeft2.png")};
		Image[] walkRight = {new Image("res/sprites/penaisRight1.png"), new Image("res/sprites/penaisRight2.png")};

		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		penai = movingDown;

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
		gfx.drawImage(lvlOneMap, 0, 0);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}

	public int getID() {
		return 4;
	}
}
