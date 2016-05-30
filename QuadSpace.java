package game;
import org.newdawn.slick.*;
public class QuadSpace {
	int x1; //smaller value
	int x2; //larger value
	int y1; //smaller value
	int y2; // larger value
	public QuadSpace(int xa, int xb, int ya, int yb){
		x1 = xa;
		x2 = xb;
		y1 = ya;
		y2 = yb;
	}
	public  collide(int x, int y, Input i, int delta){
		if(x > x1 && x < x2 && x > y1 && x < y2){
			if(i.isKeyDown(i.KEY_W)){
				y -= .2f * delta;
				if(i.isKeyDown(Input.KEY_B))
					y -= .2f * delta;
			}
			if(i.isKeyDown(i.KEY_S)){
				y += .2f * delta;
				if(i.isKeyDown(Input.KEY_B))
					y += .2f * delta;
			}
			if(i.isKeyDown(i.KEY_A)){
				x -= .2f * delta;
				if(i.isKeyDown(Input.KEY_B))
					x -= .2f * delta;
			}
			if(i.isKeyDown(i.KEY_D)){
				x += .2f * delta;
				if(i.isKeyDown(Input.KEY_B))
					x += .2f * delta;
			}
		}
		game.variables.penaiPosX = x;
		game.variables.penaiPosY = y;
	}
}
