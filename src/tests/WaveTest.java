/**
 * @author johanwesteinde
 * Test class for testing Wave's methods (other than setters and getters)
 */

package tests;

import junit.framework.TestCase;
import model.*;

public class WaveTest extends TestCase {

	private Player player;
	private Board board;
	private Wave wave;
	private Zombie zombie;
	
	
	protected void setUp() {
		//create a new 5X10 board and create a new wave with one zombie
		player = new Player(200);
		board = new Board(player);
		wave = new Wave(1, board);
		zombie = wave.getZombies().get(0);
	}
	
	protected void tearDown() {
		player = null;
		board = null;
		wave = null;
		zombie = null;
	}
	
	public void testZombiesList() {
		//ensure that the correct zombie was added to the wave
		assertEquals(1, wave.getNumberOfZombies());
		assertEquals(zombie, wave.getZombies().get(0));
	}
	
	public void testMoveZombieWithNoDamage() {
		int startSpotId = zombie.getCurrentSpot().getSpotId();
		
		//move the zombie and make sure its current spot gets updated correctly
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), startSpotId - 1);
		
		zombie.moveZombie();
		assertEquals(zombie.getCurrentSpot().getSpotId(), startSpotId - 2);
		
		//set zombie spot back to xcord = 9
		Spot startSpot = new Spot(startSpotId, Board.xSize - 1, zombie.getCurrentSpot().getyCord(), false);
		zombie.setCurrentSpot(startSpot);
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
