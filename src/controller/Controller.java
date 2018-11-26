package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;
import model.Spot;
import model.Wave;
import model.Zombie;

public class Controller {

	private Player currentPlayer = new Player(300);
	private Board gameBoard = new Board(currentPlayer);
	private Wave wave = null;
	private final int NumZombies = 3;

	public Controller() {

	}

	public void nextTurn() {
		for (Spot s : gameBoard.getGrid()) {
			if (s.isHasSunflower()) {
				s.getSpotSunflower().addSunToPlayer();
			}
		}
		for (Spot s : gameBoard.getGrid()) {
			if (s.isHasDSunflower()) {
				s.getSpotDSunflower().addDSunToPlayer();
			}
		}

		for (Spot s : gameBoard.getGrid()) {
			if (s.isHasZombie()) {
				if (s.getSpotZombies() != null) {
					for (Zombie z : s.getSpotZombies()) {
						z.moveZombie();
					}
				}
			}
		}

		for (Spot s : gameBoard.getGrid()) {
			if (s.isHasPea()) {
				s.getSpotPeaShooter().attackZombie();
			}
		}

		System.out.println(Integer.toString(wave.getNumberOfZombies()) + " Zombies remain!\n");
		if (wave.getNumberOfZombies() == 0) {
			System.out.println("Congrats you have defeated this wave of zombies!\nYou Win!\n");
			wave.setOngoing(false);
		}
	}

	public Spot spotAt(int spotId) {
		return gameBoard.spotAt(spotId);
	}

	public int getSpotXCord(Spot spot) {
		return spot.getxCord();
	}

	public int getSpotYCord(Spot spot) {
		return spot.getyCord();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public Wave getWave() {
		return wave;
	}

	public ArrayList<Integer> getZombieSpotIds() {
		ArrayList<Integer> spotIds = new ArrayList<Integer>();

		for (Spot s : gameBoard.getGrid()) {
			if (s.isHasZombie()) {
				spotIds.add(s.getSpotId());
			}
		}
		return spotIds;
	}

	public void startWave() {
		wave = new Wave(NumZombies, gameBoard);
	}

	public int getZombieCount() {
		int count = 0;
		for (Spot s : gameBoard.getGrid()) {
			if (s.isHasZombie()) {
				count += s.getSpotZombies().size();
			}
		}
		return count;
	}

	public int getCurrentSunAmount() {

		return currentPlayer.getSunAmount();
	}

	public String getTurnDescription() {
		String turnDescription = "";
		for (Spot s : gameBoard.getGrid()) {
			if (s.getSpotZombies().size() != 0) {
				for (Zombie z : s.getSpotZombies()) {
					turnDescription += z.getTurnDescriptionZombie();
				}
			}
		}
		for (Spot s : gameBoard.getGrid()) {
			if (s.isFilled()) {
				if (s.isHasSunflower()) {
					turnDescription += s.getSpotSunflower().getTurnDescriptionSunflower();
				} else if (s.isHasDSunflower()) {
					turnDescription += s.getSpotDSunflower().getTurnDescriptionDSunflower();
				} else if (s.isHasPea()) {
					turnDescription += s.getSpotPeaShooter().getPeaShooterTurnDescription();
				}else if (s.isHasPotatoe()) {
					turnDescription += s.getSpotPotatoe().getTurnDescriptionPotatoe();
				}
			}
		}
		return turnDescription;
	}

	public boolean checkGameOver() {
		return gameBoard.isGameOver();
	}
}
