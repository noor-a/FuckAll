package model;

public class Zombie {
	private int health;
	private int attackDamage = 10;
	private boolean atPlant;
	private boolean attacking;
	private Spot currentSpot;
	private Board gameBoard;
	private boolean alive;
	public String turnDescriptionZombie = "";

	/** Empty consturctor to help create other zombies **/
	public Zombie() {

	}

	public Zombie(int health, Spot currentSpot, Board gameBoard) {

		this.health = health;
		// this.attackDamage = attackDamage;
		this.atPlant = false;
		this.attacking = false;
		this.currentSpot = currentSpot;
		this.gameBoard = gameBoard;
		this.alive = true;
	}

	public boolean isAttacking() {
		return attacking;
	}

	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}

	public Spot getCurrentSpot() {
		return currentSpot;
	}

	public void setCurrentSpot(Spot currentSpot) {
		this.currentSpot = currentSpot;
	}

	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void moveZombie() {
		turnDescriptionZombie = "\n";
		if (!currentSpot.isFilled()) {
			int futureSpotId = currentSpot.getSpotId() - 1;
			if ((futureSpotId != -1) && (futureSpotId != 9) && (futureSpotId != 19) && (futureSpotId != 29)
					&& (futureSpotId != 39)) {
				Spot futureSpot = gameBoard.spotAt(futureSpotId);
				currentSpot.getSpotZombies().remove(this);
				futureSpot.addSpotZombie(this);
				futureSpot.setHasZombie(true);
				turnDescriptionZombie += "Zombie moved from SpotId: " + String.valueOf(currentSpot.getSpotId())
						+ " to SpotID: " + String.valueOf(futureSpotId) + "\n";
				currentSpot = futureSpot;

			} else if (futureSpotId == -1 || futureSpotId == 9 || futureSpotId == 19 || futureSpotId == 29
					|| futureSpotId == 39) {
				System.out.println("You lose Zombie ate your brains");
				gameBoard.setGameOver();
			}

		} else {
			this.attacking = true;
			if (currentSpot.isHasSunflower()) {
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

			}
			else if (currentSpot.isHasDSunflower()) {
				int currentHealth = currentSpot.getSpotDSunflower().getHealth();
				turnDescriptionZombie += " Double Sunflower current health: " + String.valueOf(currentHealth) + "\n"
						+ "Zombie attacks the double sunflower at SpotId: " + String.valueOf(currentSpot.getSpotId())
						+ "\n";
				currentSpot.getSpotDSunflower().setHealth(currentHealth - attackDamage);
				;
				turnDescriptionZombie += "Double sunflower lost" + String.valueOf(attackDamage) + " Current health: "
						+ String.valueOf(currentHealth - attackDamage) + "\n";

				if (currentSpot.getSpotDSunflower().getHealth() <= 0) {
					currentSpot.getSpotDSunflower().setAlive(false);
					currentSpot.setHasDSunflower(false);
					currentSpot.setFilled(false);
					turnDescriptionZombie += "Zombie killed the double sunflower at spotID : "
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

	public String getTurnDescriptionZombie() {
		return turnDescriptionZombie;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public boolean isAtPlant() {
		return atPlant;
	}

	public void setAtPlant(boolean atPlant) {
		this.atPlant = atPlant;
	}
}
