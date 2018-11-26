/**
 * @author johanwesteinde
 * Test class for testing Player's methods (other than setters and getters)
 */

package tests;

import junit.framework.TestCase;
import model.Player;

public class PlayerTest extends TestCase {

	private int sun;
	private Player player;
	
	protected void setUp() {
		sun = 100;
		player = new Player(sun);
	}
	
	protected void tearDown() {
		player = null;
	}
	
	public void testAddSun() {
		//ensure that adding sun adds correct amount of sun points
		player.addSun();
		assertEquals(10 + sun, player.getSunAmount());
	}
}
