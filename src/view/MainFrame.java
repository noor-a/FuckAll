package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;
import model.*;

public class MainFrame extends JFrame {
	private InfoPanel infoPanel;
	private GridButtonPanel gridButtonPanel;
	private Controller controller;

	public MainFrame() {
		super("Plants vs. Zombies");
		controller = new Controller();
		gridButtonPanel = new GridButtonPanel();
		infoPanel = new InfoPanel();

		infoPanel.getStartLevelButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Start level");
				gridButtonPanel.enableGridButtons();
				infoPanel.getCurrentSunAmountTextArea()
						.setText(Integer.toString(controller.getCurrentPlayer().getSunAmount()));
				controller.startWave();
				ArrayList<Integer> zombieSpotIds = new ArrayList<Integer>();
				ArrayList<SpotButton> gridButtons = new ArrayList<SpotButton>();
				gridButtons = gridButtonPanel.getGridButtons();
				infoPanel.getZombieCount().setText(String.valueOf(controller.getZombieCount()));
				for (SpotButton sb : gridButtons) {
					if (controller.spotAt(sb.getSpotButtonID()).isHasZombie()) {
						sb.addZombie();
					} else if (controller.spotAt(sb.getSpotButtonID()).isHasEZombie()) {
						sb.addExplodeZombie();
					} else if (controller.spotAt(sb.getSpotButtonID()).isHasBZombie()) {
						sb.addBucketZombie();
					}

					// if(controller.spotAt(sb.getSpotButtonID()).is)
				}
				infoPanel.getStartLevelButton().setEnabled(false);
				infoPanel.getTurnDescription().setText(controller.getWave().getTurnDescriptionWave());

			}

		});

		infoPanel.getNextTurnButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				controller.nextTurn();
				updateZombies();
				updateCurrentSunAmount();
				updateTurnDescription();
				checkGameOver();
				infoPanel.getZombieCount().setText(String.valueOf(controller.getZombieCount()));
				checkWaveOver();
				gridButtonPanel.enableGridButtons();
			}
		});

		makeSpotButtonsFunctional();
		setLayout(new BorderLayout());

		add(gridButtonPanel, BorderLayout.EAST);
		add(infoPanel, BorderLayout.WEST);
		setJMenuBar(createMenuBar());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
	}

	public InfoPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(InfoPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public GridButtonPanel getGridButtonPanel() {
		return gridButtonPanel;
	}

	public void setGridButtonPanel(GridButtonPanel gridButtonPanel) {
		this.gridButtonPanel = gridButtonPanel;
	}

	private JMenuBar createMenuBar() {
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");

		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		menubar.add(fileMenu);
		menubar.add(windowMenu);

		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int action = JOptionPane.showConfirmDialog(MainFrame.this,
						"Do you really want to exit the application?", "Confirm exit", JOptionPane.OK_CANCEL_OPTION);

				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});

		return menubar;
	}

	public void makeSpotButtonsFunctional() {

		for (SpotButton sb : gridButtonPanel.getGridButtons()) {
			if (sb != null) {
				sb.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						SpotButton buttonClicked = (SpotButton) e.getSource();
						int firstClickedId = buttonClicked.getSpotButtonID();
						Spot clickedSpot = controller.spotAt(firstClickedId);
						JOptionPane.showMessageDialog(null, clickedSpot.toString());

						if (!clickedSpot.isFilled()) {
							String[] options = new String[] { "Sunflower", "Double Sunflower", "Pea shooter","Potatoe" };
							int response = JOptionPane.showOptionDialog(null, "Choose plant for spot",
									"Plant Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
									options, options[0]);

							if (response == 0) {
								if (controller.getCurrentPlayer().getSunAmount() >= 50) {
									buttonClicked.addSunflower();
									int clickedId = buttonClicked.getSpotButtonID();

									controller.spotAt(clickedId).setFilled(true);
									controller.spotAt(clickedId)
											.setSpotSunflower(new Sunflower(controller.spotAt(clickedId).getSpotId(),
													controller.spotAt(clickedId).getxCord(),
													controller.spotAt(clickedId).getyCord(),
													controller.getCurrentPlayer()));
									controller.spotAt(clickedId).setHasSunflower(true);
									controller.getCurrentPlayer()
											.setSunAmount(controller.getCurrentPlayer().getSunAmount() - 50);
									updateCurrentSunAmount();
									infoPanel.getTurnDescription().setText("Sunflower placed at spotId: "
											+ String.valueOf(controller.spotAt(clickedId).getSpotId()) + "\n");
									for (SpotButton sb : gridButtonPanel.getGridButtons()) {
										sb.setEnabled(false);
									}
								} else {
									JOptionPane.showMessageDialog(null, "Not enough sun to purchase!");
								}

							} else if (response == 1) {
								if (controller.getCurrentPlayer().getSunAmount() >= 100) {
									buttonClicked.addDSunflower();
									int clickedId = buttonClicked.getSpotButtonID();

									controller.spotAt(clickedId).setFilled(true);
									controller.spotAt(clickedId).setSpotDSunflower(new Doublesunflower(
											controller.spotAt(clickedId).getSpotId(),
											controller.spotAt(clickedId).getxCord(),
											controller.spotAt(clickedId).getyCord(), controller.getCurrentPlayer()));
									controller.spotAt(clickedId).setHasDSunflower(true);
									controller.getCurrentPlayer()
											.setSunAmount(controller.getCurrentPlayer().getSunAmount() - 100);
									updateCurrentSunAmount();
									infoPanel.getTurnDescription().setText("Double Sunflower placed at spotId: "
											+ String.valueOf(controller.spotAt(clickedId).getSpotId()) + "\n");
									for (SpotButton sb : gridButtonPanel.getGridButtons()) {
										sb.setEnabled(false);
									}
								} else {
									JOptionPane.showMessageDialog(null, "Not enough sun to purchase");
								}
							} else if (response == 2) {
								if (controller.getCurrentPlayer().getSunAmount() >= 100) {
									buttonClicked.addPeashooter();
									int clickedId = buttonClicked.getSpotButtonID();

									controller.spotAt(clickedId).setHasPea(true);
									controller.spotAt(clickedId).setFilled(true);
									controller.spotAt(clickedId)
											.setSpotPeaShooter(new PeaShooter(controller.spotAt(clickedId).getxCord(),
													controller.spotAt(clickedId).getyCord(), 25,
													controller.spotAt(clickedId), controller.getGameBoard(),
													controller.getWave()));
									controller.getCurrentPlayer()
											.setSunAmount(controller.getCurrentPlayer().getSunAmount() - 100);
									updateCurrentSunAmount();
									infoPanel.getTurnDescription().setText("Peashooter placed at spotId: "
											+ String.valueOf(controller.spotAt(clickedId).getSpotId()) + "\n");
									for (SpotButton sb : gridButtonPanel.getGridButtons()) {
										sb.setEnabled(false);
									}
								} else {
									JOptionPane.showMessageDialog(null, "Not enough sun to purchase!");
								}
							}
							// Potatoe Selected
							else if (response == 3) {
								if (controller.getCurrentPlayer().getSunAmount() >= Potatoe.COST) {
									buttonClicked.addPotatoe();
									int clickedId = buttonClicked.getSpotButtonID();

									controller.spotAt(clickedId).setHasPotatoe(true);
									controller.spotAt(clickedId).setFilled(true);
									controller.spotAt(clickedId)
											.setSpotPotatoe(new Potatoe(controller.spotAt(clickedId).getSpotId(),
													controller.spotAt(clickedId).getxCord(),
													controller.spotAt(clickedId).getyCord(),
													controller.getCurrentPlayer()));
									controller.getCurrentPlayer()
											.setSunAmount(controller.getCurrentPlayer().getSunAmount() - Potatoe.COST);
									updateCurrentSunAmount();
									infoPanel.getTurnDescription().setText("Potatoe placed at spotId: "
											+ String.valueOf(controller.spotAt(clickedId).getSpotId()) + "\n");
									for (SpotButton sb : gridButtonPanel.getGridButtons()) {
										sb.setEnabled(false);
									}
								} else {
									JOptionPane.showMessageDialog(null, "Not enough sun to purchase!");
								}
							}
						}
					}
				});
			}
		}
	}

	public void updateZombies() {
		for (SpotButton sb : gridButtonPanel.getGridButtons()) {
			for (Spot s : controller.getGameBoard().getGrid()) {
				if (sb.getSpotButtonID() == s.getSpotId()) {
					if (!s.isFilled()) {
						if (s.isHasZombie()) {

							sb.addZombie();
						}
						if(s.isHasBZombie()) {
							sb.addBucketZombie();
						}
						if(s.isHasEZombie()) {
							sb.addExplodeZombie();
						}
						if (s.getSpotZombies().size() == 0) {
							sb.setIcon(null);
						}
					}

				}

			}
		}
	}

	public void updateCurrentSunAmount() {
		int currentSunAmount = controller.getCurrentSunAmount();
		infoPanel.getCurrentSunAmountTextArea().setText(String.valueOf(currentSunAmount));
	}

	public void updateTurnDescription() {
		String turnDescription = controller.getTurnDescription();

		infoPanel.getTurnDescription().setText(turnDescription);
	}

	public void checkGameOver() {
		if (controller.checkGameOver()) {
			JOptionPane.showMessageDialog(null, "A Zombie has eaten your brains...\nGame Over!");
			System.exit(1);
		}
	}

	public void checkWaveOver() {
		if (controller.getZombieCount() == 0) {
			JOptionPane.showMessageDialog(null, "You win!\nThanks for playing!");
			System.exit(1);
		}

	}
}