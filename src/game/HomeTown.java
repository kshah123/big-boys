package game;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
public class HomeTown extends BasicGameState{
	Image lvlOneMap;
	//Counters
	//Positions
	float shiftX = game.variables.penaiPosX + 540;
	float shiftY = game.variables.penaiPosY + 360;
	
	QuadSpace penaiHouse = new QuadSpace(67,312,-118, 200); //Your house
	QuadSpace kristinaHouse = new QuadSpace(-328,-93,-118,200); //Rival (Kristina) house
	QuadSpace farrellLab = new QuadSpace(-357,-72,-416,-209); // Lab
	QuadSpace fenceSign = new QuadSpace(82,297, -312,-262); //Fence and sign
	public HomeTown(int state){
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		lvlOneMap = new Image("res/levelMap/homeTown.png");

		Image[] walkUp = {new Image("res/sprites/penaisBack1.png"), new Image("res/sprites/penaisBack2.png")};
		Image[] walkDown = {new Image("res/sprites/penaisFront1.png"), new Image("res/sprites/penaisFront2.png")};
		Image[] walkLeft = {new Image("res/sprites/penaisLeft1.png"), new Image("res/sprites/penaisLeft2.png")};
		Image[] walkRight = {new Image("res/sprites/penaisRight1.png"), new Image("res/sprites/penaisRight2.png")};
		Image[] front = {new Image("res/sprites/penaisFront.png")};
		Image[] back = {new Image("res/sprites/penaisBack.png")};
		Image[] left = {new Image("res/sprites/penaisLeft.png")};
		Image[] right = {new Image("res/sprites/penaisRight.png")};
		
		//Animations
		game.variables.penaisFront = new Animation(front, 100);
		game.variables.penaisBack = new Animation(back, 100);
		game.variables.penaisLeft = new Animation(left, 100);
		game.variables.penaisRight = new Animation(right, 100);
		game.variables.movingUp = new Animation(walkUp, game.variables.duration);
		game.variables.movingDown = new Animation(walkDown, game.variables.duration);
		game.variables.movingLeft = new Animation(walkLeft, game.variables.duration);
		game.variables.movingRight = new Animation(walkRight, game.variables.duration);
		game.variables.sprintingDown = new Animation(walkDown, game.variables.sprintDuration);
		game.variables.sprintingUp = new Animation(walkUp, game.variables.sprintDuration);
		game.variables.sprintingLeft = new Animation(walkLeft, game.variables.sprintDuration);
		game.variables.sprintingRight = new Animation(walkRight, game.variables.sprintDuration);
		game.variables.penai = game.variables.penaisFront;
		
		

	}

	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gfx) throws SlickException {
		// TODO Auto-generated method stub
		//Drawing map so that penai is in front of his house
		lvlOneMap.draw(game.variables.penaiPosX+73, game.variables.penaiPosY+200);
		game.variables.penai.draw(shiftX, shiftY);
		// Drawing X and Y Positions
		gfx.drawString("X: "+ game.variables.penaiPosX + "\nY: " + game.variables.penaiPosY, 450, 20);
		

	}

	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();
		game.functions.movement(delta, input);
		//collision functions
		penaiHouse.collide(input, delta);
		kristinaHouse.collide(input, delta);
		farrellLab.collide(input, delta);
		fenceSign.collide(input, delta);
	}

	
	public int getID() {
		// TODO Auto-generated method stub
		return 5;
	}

}
