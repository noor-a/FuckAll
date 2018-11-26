package tests;

import junit.framework.TestCase;
import model.*;

public class DoubleSunflowerTest extends TestCase {

	private Player player;
	private Doublesunflower dsf;
	
	protected void setUp() {
		//initialize player with 200 sun and sunflower at (0, 0)
		int startAmount = 200;
		player = new Player(startAmount);
		dsf = new Doublesunflower(0, 0, 0, player);
	}
	
	protected void tearDown() {
		player = null;
		dsf = null;
	}
	
	public void testAddSun() {
		//ensure 10 sun is added for each time method called
		dsf.addDSunToPlayer();
		assertEquals(220, player.getSunAmount());
		
		dsf.addDSunToPlayer();
		assertEquals(240, player.getSunAmount());
	}
}
