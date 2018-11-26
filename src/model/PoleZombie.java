package model;

/***
 * A class for the Pole Zombie, that is able to jump over a plant infront oof it
 * once
 * 
 * @author Noor
 *
 */
@SuppressWarnings("unused")
public class PoleZombie extends Zombie {

	private int health;
	private int attackDamage = 20;
	private boolean atPlant;
	private boolean attacking;
	private Spot currentSpot;
	private Board gameBoard;
	private boolean alive;
	private boolean jumped; // variable to check if the zombie has already jumped
	public String turnDescriptionZombie = "";

	public PoleZombie(int health, Spot currentSpot, Board gameBoard) {
		super(health, currentSpot, gameBoard);
		this.currentSpot = currentSpot;
		this.atPlant = false;
		this.attacking = false;
		this.gameBoard = gameBoard;
		this.alive = true;
		this.jumped = false;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public boolean getJumped() {
		return jumped;
	}

	public void moveZombie() {
		if (!currentSpot.isFilled()) {
			int futureSpotId = currentSpot.getSpotId() - 1;
			if ((futureSpotId != -1) && (futureSpotId != 9) && (futureSpotId != 19) && (futureSpotId != 29)
					&& (futureSpotId != 39)) {
				Spot futureSpot = gameBoard.spotAt(futureSpotId);
				currentSpot.getSpotZombies().remove(this);
				futureSpot.addSpotZombie(this);
				futureSpot.setHasZombie(true);
				turnDescriptionZombie += "Pole Zombie moved from SpotId: " + String.valueOf(currentSpot.getSpotId())
						+ " to SpotID: " + String.valueOf(futureSpotId) + "\n";
				currentSpot = futureSpot;

			} else if (futureSpotId == -1 || futureSpotId == 9 || futureSpotId == 19 || futureSpotId == 29
					|| futureSpotId == 39) {
				System.out.println("You lose Zombie ate your brains");
				gameBoard.setGameOver();
				// System.exit(1);

			}

		} else {
			this.attacking = true;
			
			//Jumps if it has not already, and there is a plant infront of it
			if (!jumped && (currentSpot.isHasSunflower() || currentSpot.isHasPea())) {
				int futureSpotId = currentSpot.getSpotId() - 2;
				if ((futureSpotId != -1) && (futureSpotId != 9) && (futureSpotId != 19) && (futureSpotId != 29)
						&& (futureSpotId != 39)) {
					Spot futureSpot = gameBoard.spotAt(futureSpotId);
					currentSpot.getSpotZombies().remove(this);
					futureSpot.addSpotZombie(this);
					futureSpot.setHasZombie(true);
					turnDescriptionZombie += "Pole Zombie moved from SpotId: " + String.valueOf(currentSpot.getSpotId())
							+ " to SpotID: " + String.valueOf(futureSpotId) + "\n";
					currentSpot = futureSpot;
				}else if (futureSpotId == -1 || futureSpotId == 9 || futureSpotId == 19 || futureSpotId == 29
						|| futureSpotId == 39) {
					System.out.println("You lose Zombie ate your brains");
					gameBoard.setGameOver();
				}
				jumped = true;
			}

			else if (currentSpot.isHasSunflower()) {
				int currentHealth = currentSpot.getSpotSunflower().getHealth();
				turnDescriptionZombie += "Sunflower current health: " + String.valueOf(currentHealth) + "\n"
						+ "Zombie attacks sunfower at SpotId: " + String.valueOf(currentSpot.getSpotId()) + "\n";
				currentSpot.getSpotSunflower().setHealth(currentHealth - attackDamage);
				turnDescriptionZombie += "Sunflower lost " + String.valueOf(attackDamage) + " Current health: "
						+ String.valueOf(currentHealth - attackDamage) + "\n";

				if (currentSpot.getSpotSunflower().getHealth() <= 0) {
					currentSpot.getSpotSunflower().setAlive(false);
					currentSpot.setHasSunflower(false);
					currentSpot.setFilled(false);
					turnDescriptionZombie += "Zombie killed sunflower at spotId: "
							+ String.valueOf(currentSpot.getSpotId());

				}

			} else if (currentSpot.isHasPea()) {
				int currentHealth = currentSpot.getSpotPeaShooter().getHealth();
				turnDescriptionZombie += "PeaShooter current health: " + String.valueOf(currentHealth) + "\n"
						+ "Zombie attacks sunfower at SpotId: " + String.valueOf(currentSpot);
				currentSpot.getSpotPeaShooter().setHealth(currentHealth - attackDamage);
				turnDescriptionZombie += "PeaShooter lost " + String.valueOf(attackDamage) + " Current health: "
						+ String.valueOf(currentHealth - attackDamage);

				if (currentSpot.getSpotPeaShooter().getHealth() <= 0) {
					currentSpot.getSpotPeaShooter().setAlive(false);
					currentSpot.setHasPea(false);
					currentSpot.setFilled(false);
				}
			}
		}
	}

}
