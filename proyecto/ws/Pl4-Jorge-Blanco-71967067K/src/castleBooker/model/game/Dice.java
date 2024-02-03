package castleBooker.model.game;

import java.util.Random;

public class Dice {
	
	public static final int  MAX_VALUE=2;
	
	public static int lanzar() {
		Random rd = new Random();
		return rd.nextInt(MAX_VALUE)+1;
	}

}
