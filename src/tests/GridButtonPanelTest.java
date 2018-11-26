/**
 * @author johanwesteinde
 * Test class ensuring all elements get set in GridButtonPanel class
 */
package tests;

import junit.framework.TestCase;
import view.*;

public class GridButtonPanelTest extends TestCase {

	private GridButtonPanel panel;
	
	//set up a new GridButtonPanel
	protected void setUp() {
		panel = new GridButtonPanel();
	}
	
	protected void tearDown() {
		panel = null;
	}
	
	//test to make sure that all elements are not null
	public void testNotNull() {
		assertNotNull(panel.getGridButtons());
		assertNotNull(panel.getController());
	}	
}
