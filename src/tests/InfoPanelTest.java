/**
 * @author johanwesteinde
 * Test class ensuring all elements get set in InfoPanel class
 */
package tests;

import junit.framework.TestCase;
import view.InfoPanel;

public class InfoPanelTest extends TestCase{

private InfoPanel panel;
	
	//set up a new InfoPanel
	protected void setUp() {
		panel = new InfoPanel();
	}
	
	protected void tearDown() {
		panel = null;
	}
	
	//ensure that all elements on the InfoPanel are not null
	public void testNotNull() {
		assertNotNull(panel.getSunflowerCost());
		assertNotNull(panel.getdoublesunflowerCost());
		assertNotNull(panel.getPeaShooterCost());
		assertNotNull(panel.getCurrentSunAmountLabel());
		assertNotNull(panel.getZombieCountLabel());
		assertNotNull(panel.getWavesRemainingLabel());
		assertNotNull(panel.getTurnDescriptionLabel());
		
		assertNotNull(panel.getCurrentSunAmountTextArea());
		assertNotNull(panel.getZombieCount());
		assertNotNull(panel.getWavesRemaining());
		assertNotNull(panel.getTurnDescription());
		
		assertNotNull(panel.getNextTurnButton());
		assertNotNull(panel.getStartLevelButton());
		assertNotNull(panel.getController());
	}
}
