package castleBooker.game;


import org.junit.jupiter.api.Test;

import castleBooker.model.game.Game;

class BoardTest {

	private Game game= new Game();
	
	@Test
	public void showBoardTest() {
		System.out.print(game.toString());
		
	}

}
