package model;

import java.util.ArrayList;
import java.util.Random;

public class Wave {
	private int numberOfZombies;
	private Board gameBoard;
	private boolean ongoing;
	private String turnDescriptionWave = "";
	private ArrayList<Zombie> zombies;

	public Wave(int numberOfZombies, Board gameBoard) {
		this.ongoing = true;
		this.numberOfZombies = numberOfZombies;
		zombies = new ArrayList<Zombie>();

		ArrayList<Integer> placeableSpotIds = new ArrayList<Integer>();
		placeableSpotIds.add(9);
		placeableSpotIds.add(19);
		placeableSpotIds.add(29);
		placeableSpotIds.add(39);
		placeableSpotIds.add(49);

		for (int i = 0; i < numberOfZombies; i++) {
			Random rand = new Random();
			int random = rand.nextInt(5);

			// Makes 3 normal zombies
			if (i == 0) {
				Zombie newZombie = new Zombie(100, gameBoard.spotAt(placeableSpotIds.get(random)), gameBoard);
				int Id = placeableSpotIds.get(random);
				Spot placedSpot = gameBoard.spotAt(Id);
				if ((newZombie != null) && (placedSpot != null)) {
					placedSpot.addSpotZombie(newZombie);
					placedSpot.setHasZombie(true);
					zombies.add(newZombie);
					turnDescriptionWave += "Zombie has been place at spotId: " + String.valueOf(placedSpot.getSpotId())
							+ "\n";
					System.out.println("Zombie has been placed at spotId: " + String.valueOf(placedSpot.getSpotId()));
				}
			}

			// Makes 1 explosive zombie
			else if (i == numberOfZombies - 2) {
				Zombie newZombie = new ExplosiveZombie(100, gameBoard.spotAt(placeableSpotIds.get(random)), gameBoard);
				Spot placedSpot = gameBoard.spotAt(placeableSpotIds.get(random));
				if ((newZombie != null) && (placedSpot != null)) {
					placedSpot.addSpotZombie(newZombie);
					placedSpot.setHasEZombie(true);
					zombies.add(newZombie);
					turnDescriptionWave += "Explosive Zombie has been place at spotId: "
							+ String.valueOf(placedSpot.getSpotId()) + "\n";
					System.out.println(
							"Explosive Zombie has been placed at spotId: " + String.valueOf(placedSpot.getSpotId()));
				}
			}
			// Makes 1 bucket zombie
			else if (i == numberOfZombies - 1) {
				Zombie newZombie = new BucketZombie(250, gameBoard.spotAt(placeableSpotIds.get(random)), gameBoard);
				Spot placedSpot = gameBoard.spotAt(placeableSpotIds.get(random));
				if ((newZombie != null) && (placedSpot != null)) {
					placedSpot.addSpotZombie(newZombie);
					placedSpot.setHasBZombie(true);
					zombies.add(newZombie);
					turnDescriptionWave += "Bucket Zombie has been place at spotId: "
							+ String.valueOf(placedSpot.getSpotId()) + "\n";
					System.out.println(
							"Bucket Zombie has been placed at spotId: " + String.valueOf(placedSpot.getSpotId()));
				}
			}
		}
	}

	public String getTurnDescriptionWave() {
		return turnDescriptionWave;
	}

	public int getNumberOfZombies() {
		return numberOfZombies;
	}

	public void setNumberOfZombies(int numberOfZombies) {
		this.numberOfZombies = numberOfZombies;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public boolean isOngoing() {
		return ongoing;
	}

	public void setOngoing(boolean ongoing) {
		this.ongoing = ongoing;
	}

	public ArrayList<Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(ArrayList<Zombie> zombies) {
		this.zombies = zombies;
	}
}
