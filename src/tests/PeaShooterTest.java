/**
 * @author johanwesteinde
 * Test class for testing PeaShooter's methods (other than setters and getters)
 */

package tests;

import junit.framework.TestCase;
import model.*;

public class PeaShooterTest extends TestCase {

	private Player player;
	private Zombie zombie;
	private Spot psSpot;
	private Board board;
	private Wave wave;
	private PeaShooter ps;
	
	protected void setUp() {
		//set up the board so one zombie is coming in the same row as a planted peashooter
		player = new Player(200);
		board = new Board(player);
		wave = new Wave(1, board);
		zombie = wave.getZombies().get(0);
		
		//plant a peashooter at x=0 in same y-cord as zombie
		int yspot = zombie.getCurrentSpot().getyCord();
		//spotId = (10 * y) + x
		psSpot = new Spot(Board.xSize * yspot, 0, yspot, false);
		
		//create a new peashooter with damage 50 (2 shots kill zombie)
		ps = new PeaShooter(0, yspot, 50, psSpot, board, wave);
	}

	protected void tearDown() {
		player = null;
		board = null;
		wave = null;
		psSpot = null;
		ps = null;
	}
	
	
	public void testAttackZombie() {
		//attack zombie once, ensure zombie gets 50 health removed and is still alive
		ps.attackZombie();
		assertEquals(50, zombie.getHealth());
		assertTrue(zombie.isAlive());
		assertEquals(1, wave.getNumberOfZombies());
		
		//attack zombie again, ensure zombie dies
		ps.attackZombie();
		assertFalse(zombie.isAlive());
		assertEquals(0, wave.getNumberOfZombies());
	}
	
	//TODO make tests that enforce turn over after one attack, zombie moves forward
}
