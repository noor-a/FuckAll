/**
 * @author johanwesteinde
 * Test class for testing BucketZombie's methods (other than setters and getters)
 */

package tests;

import junit.framework.TestCase;
import model.*;

public class ZombieTest extends TestCase {

	private Player player;
	private Board board;
	private Wave wave;
	private Spot spot;
	private Zombie zombie;
	
	protected void setUp() {
		player = new Player(200);
		board = new Board(player);
		wave = new Wave(1, board);
		spot = new Spot(9, 9, 0, false);
		zombie = new Zombie(100, spot, board);
	}
	
	protected void tearDown() {
		player = null;
		board = null;
		wave = null;
		zombie = null;
	}
	
	public void testMoveZombie() {
		int currentSpotId = zombie.getCurrentSpot().getSpotId();
		zombie.moveZombie();
		assertEquals(currentSpotId - 1, zombie.getCurrentSpot().getSpotId());
		//set zombie back to original spot
		zombie.setCurrentSpot(new Spot(9, 9, 0, false));
	}
	
	public void testMoveZombieWithDamage() {
		int spotId = zombie.getCurrentSpot().getSpotId();
		int yspot = zombie.getCurrentSpot().getyCord();
		
		//plant a peashooter in the same row as the zombie
		Spot psSpot = new Spot(yspot*board.getxSize(), 0, yspot, false);
		PeaShooter ps = new PeaShooter(0, yspot, 50, psSpot, board, wave);
		
		//move zombie and attack with peashooter (zombie doesn't die)
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), spotId - 1);
		ps.attackZombie();
		assertEquals(50, zombie.getHealth());
		
		//move zombie and attack with peashooter (zombie dies)
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), spotId - 2);
		ps.attackZombie();
		assertEquals(0, zombie.getHealth());
		assertFalse(zombie.isAlive());
	}
}
