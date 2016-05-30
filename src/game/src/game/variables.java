package game;

import org.newdawn.slick.*;
import org.newdawn.slick.openal.Audio;

public class variables {
	//Animation durations
	public static int [] duration = {200,200};
	public static int [] sprintDuration = {100,100};
	public static int [] antoninaDuration = {400,400};
	
	public static Audio onClick, onHover;
	public static float menuPositionX = 2000;
	public static int lastKeyPressed;
	public static float menuPositionY = 2000;
	public static float penaiPosX = 0;
	public static float penaiPosY = 0;
	public static float antoninaPosX = penaiPosX + 420;
	public static float antoninaPosY = penaiPosY + 410;
	public static Animation penai, movingUp, movingDown, movingLeft, movingRight, penaisFront, penaisBack, penaisLeft, penaisRight;
	public static Animation sprintingUp, sprintingDown, sprintingLeft, sprintingRight;
}
