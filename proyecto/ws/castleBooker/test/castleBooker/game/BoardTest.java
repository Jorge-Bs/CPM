package castleBooker.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	private Game game= new Game();
	
	@Test
	public void showBoardTest() {
		System.out.print(game.toString());
		
	}

}
