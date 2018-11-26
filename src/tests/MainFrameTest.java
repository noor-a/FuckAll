/**
 * @author johanwesteinde
 * Test class ensuring all elements get set in MainFrame class
 */
package tests;

import junit.framework.TestCase;
import view.MainFrame;

public class MainFrameTest extends TestCase {

	MainFrame frame = new MainFrame();
	
	//set up a new MainFrame
	protected void setUp() {
		frame = new MainFrame();
	}
	
	protected void tearDown() {
		frame = null;
	}
	
	//ensure that all elements on the InfoPanel are not null
	public void testNotNull() {
		assertNotNull(frame.getInfoPanel());
		assertNotNull(frame.getGridButtonPanel());
	}
}
