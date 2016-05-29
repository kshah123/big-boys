package game;

import org.newdawn.slick.*;
// A class for usefull funtions that will definitely be used many times
public class functions {
	//movement function
	public static void movement(int delta, Input input){
		
		if(input.isKeyDown(Input.KEY_W)){
			game.variables.lastKeyPressed = Input.KEY_W;
			game.variables.penai = game.variables.movingUp;
			game.variables.penaiPosY += delta * .2f;
			game.variables.antoninaPosY += delta * .2f;
			if(input.isKeyDown(Input.KEY_A)){
				game.variables.penaiPosY -= delta * .05f;
				game.variables.penaiPosX -= delta * .05f;
				game.variables.antoninaPosX -= delta * .05f;
				game.variables.antoninaPosY -= delta * .05f;
			}
			if(input.isKeyDown(Input.KEY_D)){
				game.variables.penaiPosY -= delta * .05f;
				game.variables.penaiPosX += delta * .05f;
				game.variables.antoninaPosX += delta * .05f;
				game.variables.antoninaPosY -= delta * .05f;				
			}
			if(input.isKeyDown(Input.KEY_B)){
				game.variables.penaiPosY += delta * .2f;
				game.variables.antoninaPosY += delta * .2f;
				if(input.isKeyDown(Input.KEY_A)){
					game.variables.penaiPosY -= delta * .15f;
					game.variables.penaiPosX -= delta * .15f;
					game.variables.antoninaPosX -= delta * .15f;
					game.variables.antoninaPosY -= delta * .15f;
				}
				if(input.isKeyDown(Input.KEY_D)){
					game.variables.penaiPosY -= delta * .15f;
					game.variables.penaiPosX += delta * .15f;
					game.variables.antoninaPosX += delta * .15f;
					game.variables.antoninaPosY -= delta * .15f;				
				}
			}
		}
		if(game.variables.lastKeyPressed == Input.KEY_W && !(input.isKeyDown(Input.KEY_W)))game.variables.penai = game.variables.penaisBack;
		if(input.isKeyDown(Input.KEY_S)){
			game.variables.lastKeyPressed = Input.KEY_S;
			game.variables.penai = game.variables.movingDown;
			game.variables.penaiPosY -= delta * .2f;
			game.variables.antoninaPosY -= delta * .2f;
			if(input.isKeyDown(Input.KEY_A)){
				game.variables.penaiPosY += delta * .05f;
				game.variables.penaiPosX -= delta * .05f;
				game.variables.antoninaPosX -= delta * .05f;
				game.variables.antoninaPosY += delta * .05f;
			}
			if(input.isKeyDown(Input.KEY_D)){
				game.variables.penaiPosY += delta * .05f;
				game.variables.penaiPosX += delta * .05f;
				game.variables.antoninaPosX += delta * .05f;
				game.variables.antoninaPosY += delta * .05f;				
			}
			if(input.isKeyDown(Input.KEY_B)){
				game.variables.penaiPosY -= delta * .2f;
				game.variables.antoninaPosY -= delta * .2f;
				if(input.isKeyDown(Input.KEY_A)){
					game.variables.penaiPosY += delta * .1f;
					game.variables.penaiPosX -= delta * .1f;
					game.variables.antoninaPosX -= delta * .1f;
					game.variables.antoninaPosY += delta * .1f;
				}
				if(input.isKeyDown(Input.KEY_D)){
					game.variables.penaiPosY += delta * .1f;
					game.variables.penaiPosX += delta * .1f;
					game.variables.antoninaPosX += delta * .1f;
					game.variables.antoninaPosY += delta * .1f;				
				}
			}
		}
		if(game.variables.lastKeyPressed == Input.KEY_S && !(input.isKeyDown(Input.KEY_S)))game.variables.penai = game.variables.penaisFront;
		if(input.isKeyDown(Input.KEY_A)){
			game.variables.lastKeyPressed = Input.KEY_A;
			game.variables.penai = game.variables.movingLeft;
			game.variables.penaiPosX += delta * .2f;
			game.variables.antoninaPosX += delta * .2f;
			if(input.isKeyDown(Input.KEY_B)){
				game.variables.penaiPosX += delta * .2f;
				game.variables.antoninaPosX += delta * .2f;
			}
		}
		if(game.variables.lastKeyPressed == Input.KEY_A && !(input.isKeyDown(Input.KEY_A)))game.variables.penai = game.variables.penaisLeft;
		if(input.isKeyDown(Input.KEY_D)){
			game.variables.lastKeyPressed = Input.KEY_D;
			game.variables.penai = game.variables.movingRight;
			game.variables.penaiPosX -= delta * .2f;
			game.variables.antoninaPosX -= delta * .2f;
			if(input.isKeyDown(Input.KEY_B)){
				game.variables.penaiPosX -= delta * .2f;
				game.variables.antoninaPosX -= delta * .2f;
			}
		}
		if(game.variables.lastKeyPressed == Input.KEY_D && !(input.isKeyDown(Input.KEY_D)))game.variables.penai = game.variables.penaisRight;
	}
	//menuBar
	public static void menu(Input i){
		if(i.isKeyPressed(Input.KEY_ESCAPE) && game.variables.menuPositionX == 5000 && game.variables.menuPositionY == 5000){
			game.variables.menuPositionX = 20;
			game.variables.menuPositionY = 20;
		} else if(i.isKeyPressed(Input.KEY_ESCAPE) && game.variables.menuPositionX == 20 && game.variables.menuPositionY == 20){
			game.variables.menuPositionX = 5000;
			game.variables.menuPositionY = 5000;
		}
	}
	//setting collisions
	//direction can be: "up", "down", "left", or "right"
public static void setCollision(Input i, int delta, int xInitial, int xFinal, int yInitial, int yFinal, String direction){
		if(direction.equals("up")){
			if(game.variables.penaiPosX < xFinal && game.variables.penaiPosX > xInitial && game.variables.penaiPosY > yInitial &&game.variables.penaiPosY <yFinal){
				game.variables.penaiPosY -= .2f * delta;
				game.variables.antoninaPosY -= .2f * delta;
				if(i.isKeyDown(Input.KEY_B)){
					game.variables.penaiPosY -= .2f * delta;
					game.variables.antoninaPosY -= .2f * delta;
				}
			}
		}	
		if(direction.equals("down")){
			if(game.variables.penaiPosX < xFinal && game.variables.penaiPosX > xInitial && game.variables.penaiPosY > yInitial && game.variables.penaiPosY < yFinal){
				game.variables.penaiPosY += .2f * delta;
				game.variables.antoninaPosY += .2f * delta;
				if(i.isKeyDown(Input.KEY_B)){
					game.variables.penaiPosY += .2f * delta;
					game.variables.antoninaPosY += .2f * delta;
				}
			}
		}
		if(direction.equals("left")){
			if(game.variables.penaiPosX < xFinal && game.variables.penaiPosX > xInitial && game.variables.penaiPosY > yInitial && game.variables.penaiPosY < yFinal){
				game.variables.penaiPosX -= .2f * delta;
				game.variables.antoninaPosX -= .2f * delta;
				if(i.isKeyDown(Input.KEY_B)){
					game.variables.penaiPosX -= .2f * delta;
					game.variables.antoninaPosX -= .2f * delta;
				}
			}
		}
		if(direction.equals("right")){
			if(game.variables.penaiPosX < xFinal && game.variables.penaiPosX > xInitial && game.variables.penaiPosY > yInitial && game.variables.penaiPosY < yFinal){
				game.variables.penaiPosX += .2f * delta;
				game.variables.antoninaPosX += .2f * delta;
				if(i.isKeyDown(Input.KEY_B)){
					game.variables.penaiPosX += .2f * delta;
					game.variables.antoninaPosX += .2f * delta;
				}
			}				
		}
	}
}
