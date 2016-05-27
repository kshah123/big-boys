package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import game.functions;

public class Play1 extends BasicGameState {

	Animation antonina, penai, antoninaRight, antoninaLeft, movingUp, movingDown, movingLeft, movingRight,  penaisFront, penaisBack, penaisLeft, penaisRight;
	Image lvlOneMap;
	Animation movingdog = new Animation();
	int [] duration = {200,200};
	int [] antoninaDuration = {400,400};
	int antoninaMovementCounter = 0;
	boolean movingright = true;
	float penaiPosX = 0;
	float penaiPosY = 0;
	float antoninaPosX = penaiPosX + 420;
	float antoninaPosY = penaiPosY +410;
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
		Image[] antoninaRightImg = {new Image("res/sprites/antoninasRight1.png"), new Image("res/sprites/antoninasRight2.png")};
		Image[] antoninaLeftImg = {new Image("res/sprites/antoninasLeft1.png"), new Image("res/sprites/antoninasLeft2.png")};
		penaisFront = new Animation(front, 100);
		penaisBack = new Animation(back, 100);
		penaisLeft = new Animation(left, 100);
		penaisRight = new Animation(right, 100);
		movingUp = new Animation(walkUp, duration);
		movingDown = new Animation(walkDown, duration);
		movingLeft = new Animation(walkLeft, duration);
		movingRight = new Animation(walkRight, duration);
		antoninaRight = new Animation(antoninaRightImg, antoninaDuration);
		antoninaLeft = new Animation(antoninaLeftImg, antoninaDuration);
		penai = penaisFront;
		antonina = antoninaRight;

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
		lvlOneMap.draw(penaiPosX-41, penaiPosY+28);
		penai.draw(shiftX, shiftY);
		antonina.draw(antoninaPosX, antoninaPosY);
		gfx.drawString("X: "+ penaiPosX + "\nY: " + penaiPosY, 450, 20);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		//code for antonina bot
		if(movingright == true){
			antonina = antoninaRight;
			antoninaPosX += delta *.05f;
			antoninaMovementCounter++;
			if(antoninaMovementCounter > 1500){
				movingright = false;
			} 
		}
		if(movingright == false){
			antonina = antoninaLeft;
			antoninaPosX -= delta * .05f;
			antoninaMovementCounter--;
			if(antoninaMovementCounter < 0){
				movingright = true;
			}
		}
		// code for movement
		Input input = gc.getInput();
		//up
		if(input.isKeyDown(Input.KEY_W)){
		penai = movingUp;
			if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_A))
				penaiPosY += delta * .15f * .75;
			else
				penaiPosY += delta * .15f;
			if(input.isKeyDown(Input.KEY_B))
				penaiPosY += delta * .15f * .6;
			antoninaPosY += delta * .15f;
			lastKeyPressed = Input.KEY_W;
			//top wall
			if(penaiPosY > 245){
				penaiPosY -= delta* .15f;
			}

			//bottom of bed
			if(penaiPosX < 110 && penaiPosX > 10 && penaiPosY > 120){
				penaiPosY -= delta* .15f;
			}
			//bottom of table
			if(penaiPosX < 483 && penaiPosX > 335 && penaiPosY < 35 && penaiPosY > -92){
				penaiPosY -= delta * .15f * 1.2;
				if(input.isKeyDown(Input.KEY_B))
					penaiPosY -= delta * .15f * .6 * 1.2;
			}
		}
		if(lastKeyPressed == Input.KEY_W && !(input.isKeyDown(Input.KEY_W))) penai = penaisBack;
		//down
		if(input.isKeyDown(Input.KEY_S)){
			penai = movingDown;
			if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_A))
				penaiPosY -= delta * .15f * .75;
			else
				penaiPosY -= delta * .15f;
			if(input.isKeyDown(Input.KEY_B))
				penaiPosY -= delta * .15f * .6;
			antoninaPosY -= delta *.15f;
			//top of table
			if(penaiPosX < 483 && penaiPosX > 335 && penaiPosY < 35 && penaiPosY > -92){
				penaiPosY += delta * .15f * 1.2;
				if(input.isKeyDown(Input.KEY_B))
					penaiPosY += delta * .15f * .6 * 1.2;
			}
		}
		if(lastKeyPressed == Input.KEY_S && !(input.isKeyDown(Input.KEY_S))) penai = penaisFront;
		//left
		if(input.isKeyDown(Input.KEY_A)){
			penai = movingLeft;
			if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_A))
				penaiPosX += delta * .15f * .75 * 1.2;
			else
				penaiPosX += delta * .15f * 1.2;
			if(input.isKeyDown(Input.KEY_B))
				penaiPosX += delta * .15f * .6 * 1.2;
			antoninaPosX += delta * .15f;
			lastKeyPressed = Input.KEY_A;
			//right side of table
			if(penaiPosX < 483 && penaiPosX > 335 && penaiPosY < 35 && penaiPosY > -92){
				penaiPosX -= delta * .15f * 1.2;
				if(input.isKeyDown(Input.KEY_B))
					penaiPosX -= delta * .15f * .6 * 1.2;
			}
			//right side of bed
			if(penaiPosY > 136 && penaiPosY < 260 && penaiPosX > -4 && penaiPosX < 136){
				penaiPosX -= delta * .15f * 1.2;
			}
		}
		if(lastKeyPressed == Input.KEY_A && !(input.isKeyDown(Input.KEY_A))) penai = penaisLeft;
		//right
		if(input.isKeyDown(Input.KEY_D)){
						penai = movingRight;
			if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_A))
				penaiPosX -= delta * .15f * .75 * 1.2;
			else
				penaiPosX -= delta * .15f * 1.2;
			if(input.isKeyDown(Input.KEY_B))
				penaiPosX -= delta * .15f * .6 * 1.2;
			antoninaPosX -= delta * .15f;
			lastKeyPressed = Input.KEY_D;
			//left side of bed
			if(penaiPosY > 124 && penaiPosY < 260 && penaiPosX < 136 && penaiPosX >133){
				penaiPosX += delta * .15f * 1.2;
			}
			// right side wall
			if(penaiPosY > 0 && penaiPosY < 235 && penaiPosX < -75){
				penaiPosX += delta * .15f * 1.2;
			}
			//left side of table
			if(penaiPosX < 483 && penaiPosX > 335 && penaiPosY < 35 && penaiPosY > -92){
				penaiPosX += delta * .15f * 1.2;
				if(input.isKeyDown(Input.KEY_B))
					penaiPosX += delta * .15f * .6 * 1.2;
			}
		}
		if(lastKeyPressed == Input.KEY_D && !(input.isKeyDown(Input.KEY_D))) penai = penaisRight;
		//pause menu
		if(input.isKeyPressed(Input.KEY_ESCAPE)){
			
		}
	}

	public int getID() {
		return 4;
	}
}
