package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play1 extends BasicGameState {

	Animation penai, movingUp, movingDown, movingLeft, movingRight,  penaisFront, penaisBack, penaisLeft, penaisRight;
	Image lvlOneMap;
	Animation movingdog = new Animation();
	int [] duration = {200,200};
	float penaiPosX = 40;
	float penaiPosY = 100;
	float shiftX = penaiPosX + 540;
	float shiftY = penaiPosY + 360;
	int lastKeyPressed;
	public Play1(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		lvlOneMap = new Image("res/levelMap/lvlOneMap.png");
		Image[] walkUp = {new Image("res/sprites/penaisBack1.png"), new Image("res/sprites/penaisBack2.png")};
		Image[] walkDown = {new Image("res/sprites/penaisFront1.png"), new Image("res/sprites/penaisFront2.png")};
		Image[] walkLeft = {new Image("res/sprites/penaisLeft1.png"), new Image("res/sprites/penaisLeft2.png")};
		Image[] walkRight = {new Image("res/sprites/penaisRight1.png"), new Image("res/sprites/penaisRight2.png")};
		Image[] front = {new Image("res/sprites/penaisFront.png")};
		Image[] back = {new Image("res/sprites/penaisBack.png")};
		Image[] left = {new Image("res/sprites/penaisLeft.png")};
		Image[] right = {new Image("res/sprites/penaisRight.png")};
		penaisFront = new Animation(front, 100);
		penaisBack = new Animation(back, 100);
		penaisLeft = new Animation(left, 100);
		penaisRight = new Animation(right, 100);
		movingUp = new Animation(walkUp, duration);
		movingDown = new Animation(walkDown, duration);
		movingLeft = new Animation(walkLeft, duration);
		movingRight = new Animation(walkRight, duration);
		penai = penaisFront;

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
		lvlOneMap.draw(penaiPosX - 5 , penaiPosY + 120);
		penai.draw(shiftX, shiftY);
		gfx.drawString("X: "+ penaiPosX + "\nY: " + penaiPosY, 460, 20);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		//up
		if(input.isKeyDown(Input.KEY_W)){
			penai = movingUp;
			penaiPosY += delta * .15f;
			lastKeyPressed = input.KEY_W;
			//top wall left side of bed
			if(penaiPosX < 267 && penaiPosX > 125 && penaiPosY > 224){
				penaiPosY -= delta* .15f;
			}
			//top wall right side of bed
			if(penaiPosX < -3 && penaiPosX > -85 && penaiPosY > 224){
				penaiPosY -= delta* .15f;
			}
		}
		if(lastKeyPressed == Input.KEY_W && !(input.isKeyDown(input.KEY_W))) penai = penaisBack;
		//down
		if(input.isKeyDown(Input.KEY_S)){
			penai = movingDown;
			penaiPosY -= delta *.15f;
			lastKeyPressed = input.KEY_S;
		}
		if(lastKeyPressed == input.KEY_S && !(input.isKeyDown(input.KEY_S))) penai = penaisFront;
		//left
		if(input.isKeyDown(Input.KEY_A)){
			penai = movingLeft;
			penaiPosX += delta * .15f;
			lastKeyPressed = input.KEY_A;
		}
		if(lastKeyPressed == input.KEY_A && !(input.isKeyDown(input.KEY_A))) penai = penaisLeft;
		//right
		if(input.isKeyDown(Input.KEY_D)){
			penai = movingRight;
			penaiPosX -= delta * .15f;
			lastKeyPressed = input.KEY_D;
			//left side of bed
			if(penaiPosY > 136 && penaiPosY < 225 && penaiPosX < 135){
				penaiPosX += delta * .15f;
			}
			// right side wall
			if(penaiPosY > 0 && penaiPosY < 235 && penaiPosX < -75){
				penaiPosX += delta * .15f;
			}
		}
		if(lastKeyPressed == input.KEY_D && !(input.isKeyDown(input.KEY_D))) penai = penaisRight;
	}

	public int getID() {
		return 4;
	}
}
