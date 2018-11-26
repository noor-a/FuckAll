package model;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Turn {
	private Player player;
	private Board board;
	private Wave wave;

	public Turn(Player player, Board board, Wave wave) {
		this.player = player;
		this.board = board;
		this.wave = wave;

		askToPlant();

	}

	public void finishTurn() {

		for (Spot s : board.getGrid()) {
			if (s.isHasSunflower()) {
				s.getSpotSunflower().addSunToPlayer();
			}
		}

		for (Spot s : board.getGrid()) {
			if (s.isHasZombie()) {
				if (s.getSpotZombies() != null) {
					for (Zombie z : s.getSpotZombies()) {

						z.moveZombie();
					}
				}
			}
		}

		for (Spot s : board.getGrid()) {
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

	public void askToPlant() {
		System.out.print("It is your turn: press P to place a new plant or N for the next turn\n");
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		if (input.equals("P")) {
			askWhichPlant();
		} else if (input.equals("N")) {
			finishTurn();
		} else {
			System.out.println("Invalid Command! \n");
			askToPlant();
		}
	}

	public void askWhichPlant() {
		Scanner sc = new Scanner(System.in);
		System.out.println("What type of plant? Press S for Sunflower or Press P for Pea Shooter\n");
		String whichPlant = sc.next();
		if (whichPlant.equals("S")) {
			if (player.getSunAmount() >= 50) {
				askForXCordinate(true);
			} else {
				System.out.println("Insufficient Sun Balance!\n");
				askWhichPlant();
			}
		} else if (whichPlant.equals("P")) {

			if (player.getSunAmount() >= 100) {
				askForXCordinate(false);
			} else {
				System.out.println("Insufficient Sun Balance!\n");
				askWhichPlant();
			}
		} else {
			askWhichPlant();
		}
	}

	public void askForXCordinate(boolean isSunflower) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an X coordinate: \n");
		String xCord = sc.next();
		int xCordinate = Integer.parseInt(xCord);
		if (xCordinate > -1 && xCordinate < board.getxSize()) {
			askForYCordinate(xCordinate, isSunflower);
		} else {
			System.out.println("Invalid X Coordinate! Please try again. \n");
			askForXCordinate(isSunflower);
		}
	}

	public void askForYCordinate(int xCordinate, boolean isSunflower) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Y coordinate: \n");
		String yCord = sc.next();
		int yCordinate = Integer.parseInt(yCord);
		if (isSunflower) {
			if (!board.spotAt(xCordinate, yCordinate).isFilled()) {
				board.spotAt(xCordinate, yCordinate).setSpotSunflower(new Sunflower(xCordinate, yCordinate, player));
				board.spotAt(xCordinate, yCordinate).setFilled(true);
				board.spotAt(xCordinate, yCordinate).setHasSunflower(true);
				player.setSunAmount(player.getSunAmount() - 50);
				System.out.println("Sunflower placed at coordinates x: " + Integer.toString(xCordinate) + " y: "
						+ Integer.toString(yCordinate) + " \n");
				System.out.println("Player current sun balance is: " + Integer.toString(player.getSunAmount()) + "!\n");
				finishTurn();
			} else {
				System.out.print("Spot is filled choose new Y Cord: \n");
				askForYCordinate(xCordinate, isSunflower);
			}

		} else {
			if (!board.spotAt(xCordinate, yCordinate).isFilled()) {
				board.spotAt(xCordinate, yCordinate).setSpotPeaShooter(
						new PeaShooter(xCordinate, yCordinate, 20, board.spotAt(xCordinate, yCordinate), board, wave));
				board.spotAt(xCordinate, yCordinate).setFilled(true);
				board.spotAt(xCordinate, yCordinate).setHasPea(true);
				player.setSunAmount(player.getSunAmount() - 100);
				System.out.println("Player current sun balance is: " + Integer.toString(player.getSunAmount()) + "!\n");
				System.out.println("PeaShooter placed at coordinates x: " + Integer.toString(xCordinate) + " y: "
						+ Integer.toString(yCordinate) + " \n");
				finishTurn();
			} else {
				System.out.print("Spot is filled choose new Y Cord: \n");
				askForYCordinate(xCordinate, isSunflower);
			}

		}

	}

}