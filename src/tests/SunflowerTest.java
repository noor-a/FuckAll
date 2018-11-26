/**
 * @author johanwesteinde
 * Test class for testing Sunflower's methods (other than setters and getters)
 */

package tests;

import junit.framework.TestCase;
import model.Player;
import model.Sunflower;

public class SunflowerTest extends TestCase {

	private Player player;
	private Sunflower sf;
	
	protected void setUp() {
		//initialize player with 200 sun and sunflower at (0, 0)
		int startAmount = 200;
		player = new Player(startAmount);
		sf = new Sunflower(0, 0, 0, player);
	}
	
	protected void tearDown() {
		player = null;
		sf = null;
	}
	
	public void testAddSun() {
		//ensure 10 sun is added for each time method called
		sf.addSunToPlayer();
		assertEquals(210, player.getSunAmount());
		
		sf.addSunToPlayer();
		assertEquals(220, player.getSunAmount());
	}
}
