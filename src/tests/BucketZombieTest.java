/**
 * @author johanwesteinde
 * Test class for testing BucketZombie's methods (other than setters and getters)
 */

package tests;

import junit.framework.TestCase;

import model.*;

public class BucketZombieTest extends TestCase {

	private Player player;
	private Board board;
	private BucketZombie zombie;
	private Spot spot;
	
	
	protected void setUp() {
		player = new Player(200);
		board = new Board(player);
		spot = new Spot(9, 9, 0, false);
		zombie = new BucketZombie(100, spot, board);
	}
	
	protected void tearDown() {
		player = null;
		board = null;
		spot = null;
		zombie = null;
	}
	
	/*
	 * Test moving the zombie one spot when no other zombies on the board
	 */
	public void testMoveZombieWithNoPlants() {
		int nextSpotId = spot.getSpotId() - 1;
		zombie.moveZombie();
		assertEquals(8, nextSpotId);
	}
	
	public void testMoveZombieWithPlant() {
		//zombie should not move, so next spot is the same spot
		int nextSpotId = spot.getSpotId();
		Sunflower sf = new Sunflower(8, 8, 0, player);
		zombie.moveZombie();
		assertEquals(9, nextSpotId);
	}
	
	public void testGameOver() {
		//if a zombie gets to the other side of the board, game is over
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		zombie.moveZombie();
		assertTrue(board.isGameOver());
	}
}
