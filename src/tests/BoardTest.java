/**
 * @author johanwesteinde
 * Test class for testing Board's methods (other than setters and getters)
 */

package tests;

import java.util.ArrayList;
import junit.framework.TestCase;
import model.*;

public class BoardTest extends TestCase {

	private int x, y;
	private Player player;
	private Board board;
	private ArrayList<Spot> grid;
	
	protected void setUp() {
		//set a board with a player with 200 sun
		player = new Player(200);
		board = new Board(player);
	}
	
	protected void tearDown() {
		player = null;
		board = null;
		grid = null;
	}
			
	public void testFirstSpotAtInt() {
		//ensure spot at x-cord 0 and y-cord 0 is first in the list of spots
		assertEquals(board.spotAt(0, 0), board.getGrid().get(0));
	}
	
	public void testMiddleSpotAtInt() {
		//ensure spot at x-cord = 4, y-cord = 2 is in correct spot in list (24th in 5X10 board)
		assertEquals(board.spotAt(4, 2), board.getGrid().get(24));
	}
	
	public void testFirstSpotAtID() {
		//ensure spot with ID 0 is first in the list of spots
		assertEquals(board.spotAt(0), board.getGrid().get(0));
	}
	
	public void testMiddleSpotAtId() {
		//ensure spot at ID=24 is in the 24th index in the list of spots
		assertEquals(board.spotAt(24), board.getGrid().get(24));
	}
}
