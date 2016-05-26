package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Credits extends BasicGameState{
	Image creditImage;

	public Credits(int state){
		
	}
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		creditImage = new Image("res/backgrounds/credits.png");
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}

	public int getID() {
		return 2;
	}

}
