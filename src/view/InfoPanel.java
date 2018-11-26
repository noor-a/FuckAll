package view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controller;

public class InfoPanel extends JPanel
{
	private JLabel sunflowerCost;
	private JLabel doublesunflowerCost;
	private JLabel peaShooterCost;
	private JLabel currentSunAmountLabel;
	private JLabel zombieCountLabel;
	private JLabel wavesRemainingLabel;
	private JLabel turnDescriptionLabel; 
	
	
	private JTextArea currentSunAmountTextArea;
	private JTextArea zombieCount;
	private JTextArea wavesRemaining; 
	private JTextArea turnDescription;
	
	private JScrollPane scrollPane;
	
	private JLabel turnOverLabel;
	private JButton nextTurnButton;
	private JButton startLevelButton;
	private JButton UndoButton;
	private Controller controller;
	
	
	 public InfoPanel() 
	{
		UndoButton= new JButton("Undo");
		sunflowerCost = new JLabel("Sunflower cost: 50 Sun");
		doublesunflowerCost= new JLabel("Double sunflower cost: 100 Sun");
		peaShooterCost = new JLabel("Peashooter cost: 100 Sun");
		zombieCountLabel = new JLabel("Current Zombie Count:");
		currentSunAmountLabel = new JLabel("Current Sun Amount:");
		wavesRemainingLabel = new JLabel("Zombie waves remaining: ");
		turnDescriptionLabel = new JLabel("Turn Description: ");
		
		
		wavesRemaining = new JTextArea(2,10);
		currentSunAmountTextArea = new JTextArea(2,10);
		zombieCount = new JTextArea(2,10);
		wavesRemaining = new JTextArea(2,10);
		turnDescription = new JTextArea(15,30);
		
		scrollPane = new JScrollPane(turnDescription);
		
		
		controller = new Controller();
		
		currentSunAmountTextArea.setEditable(false);
		nextTurnButton = new JButton("Next Turn");
		startLevelButton = new JButton("Start Level");
		
		startLevelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Start level");
				currentSunAmountTextArea.setText(Integer.toString(controller.getCurrentPlayer().getSunAmount()));
			}});
		
		nextTurnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("Next Turn");				
			}
		});
		layoutComponents();		
	}
	 
	 public void layoutComponents() 
	 {
		 setLayout(new GridBagLayout());
		 GridBagConstraints gc = new GridBagConstraints();
		 
		////////////////////////////////////first row///////////////////////////////////////
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(sunflowerCost, gc);
		////////////////////////////////////next row///////////////////////////////////////
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(doublesunflowerCost,gc);
		
		
		////////////////////////////////////next row///////////////////////////////////////
		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(peaShooterCost, gc);
		
		
		////////////////////////////////////next row///////////////////////////////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0; 
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(currentSunAmountLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(currentSunAmountTextArea, gc);
		
		////////////////////////////////////next row///////////////////////////////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0; 
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(zombieCountLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(zombieCount, gc);
		
		////////////////////////////////////next row///////////////////////////////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0; 
		gc.insets = new Insets(0,0,0,5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(turnDescriptionLabel, gc);
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0,0,0,5);
		add(scrollPane, gc);

		
		////////////////////////////////////next row///////////////////////////////////////
		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(startLevelButton, gc);
		
		
		////////////////////////////////////next row///////////////////////////////////////
		gc.gridy++;
		gc.gridx = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(nextTurnButton, gc);
		
		/////////////////////////////////next row////////////////////////////////////////////#
		
		gc.gridy++;
		gc.gridx=0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(UndoButton, gc);
		
	 }

	public JLabel getSunflowerCost() {
		return sunflowerCost;
	}

	public JLabel getdoublesunflowerCost(){
		return doublesunflowerCost;
	}

	public void setSunflowerCost(JLabel sunflowerCost) {
		this.sunflowerCost = sunflowerCost;
	}
	public void setdoublesunflowerCost(JLabel doublesunflowerCost){
		this.doublesunflowerCost=doublesunflowerCost;
	}

	public JLabel getPeaShooterCost() {
		return peaShooterCost;
	}

	public void setPeaShooterCost(JLabel peaShooterCost) {
		this.peaShooterCost = peaShooterCost;
	}

	public JLabel getCurrentSunAmountLabel() {
		return currentSunAmountLabel;
	}

	public void setCurrentSunAmountLabel(JLabel currentSunAmountLabel) {
		this.currentSunAmountLabel = currentSunAmountLabel;
	}

	public JLabel getZombieCountLabel() {
		return zombieCountLabel;
	}

	public void setZombieCountLabel(JLabel zombieCountLabel) {
		this.zombieCountLabel = zombieCountLabel;
	}

	public JLabel getWavesRemainingLabel() {
		return wavesRemainingLabel;
	}

	public void setWavesRemainingLabel(JLabel wavesRemainingLabel) {
		this.wavesRemainingLabel = wavesRemainingLabel;
	}

	public JLabel getTurnDescriptionLabel() {
		return turnDescriptionLabel;
	}

	public void setTurnDescriptionLabel(JLabel turnDescriptionLabel) {
		this.turnDescriptionLabel = turnDescriptionLabel;
	}

	public JTextArea getCurrentSunAmountTextArea() {
		return currentSunAmountTextArea;
	}

	public void setCurrentSunAmountTextArea(JTextArea currentSunAmountTextArea) {
		this.currentSunAmountTextArea = currentSunAmountTextArea;
	}

	public JTextArea getZombieCount() {
		return zombieCount;
	}

	public void setZombieCount(JTextArea zombieCount) {
		this.zombieCount = zombieCount;
	}

	public JTextArea getWavesRemaining() {
		return wavesRemaining;
	}

	public void setWavesRemaining(JTextArea wavesRemaining) {
		this.wavesRemaining = wavesRemaining;
	}

	public JTextArea getTurnDescription() {
		return turnDescription;
	}

	public void setTurnDescription(JTextArea turnDescription) {
		this.turnDescription = turnDescription;
	}

	public JLabel getTurnOverLabel() {
		return turnOverLabel;
	}

	public void setTurnOverLabel(JLabel turnOverLabel) {
		this.turnOverLabel = turnOverLabel;
	}

	public JButton getNextTurnButton() {
		return nextTurnButton;
	}

	public void setNextTurnButton(JButton nextTurnButton) {
		this.nextTurnButton = nextTurnButton;
	}

	public JButton getStartLevelButton() {
		return startLevelButton;
	}

	public void setStartLevelButton(JButton startLevelButton) {
		this.startLevelButton = startLevelButton;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}

