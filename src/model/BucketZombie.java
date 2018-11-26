package model;
/****
 * Creates a class for a zombie that had double the health of a normal zombie
 * @author Noor
 *
 */
public class BucketZombie extends Zombie {

	private int health;
	private int attackDamage = 20;
	private boolean atPlant;
	private boolean attacking;
	private Spot currentSpot;
	private Board gameBoard;
	private boolean alive;
	public String turnDescriptionZombie = "";
	public final int bucketFactor = 2;

	public BucketZombie(int health, Spot currentSpot, Board gameBoard) {
		super(health, currentSpot, gameBoard);
		this.health = (bucketFactor * health);
		// this.attackDamage = attackDamage;
		this.atPlant = false;
		this.attacking = false;
		this.currentSpot = currentSpot;
		this.gameBoard = gameBoard;
		this.alive = true;
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
				turnDescriptionZombie += "Bucket Zombie moved from SpotId: " + String.valueOf(currentSpot.getSpotId())
						+ " to SpotID: " + String.valueOf(futureSpotId) + "\n";
				currentSpot = futureSpot;

			} else if (futureSpotId == -1 || futureSpotId == 9 || futureSpotId == 19 || futureSpotId == 29
					|| futureSpotId == 39) {
				System.out.println("You lose Zombie ate your brains");
				gameBoard.setGameOver();
			}

		} else {
			this.attacking = true;
			
			if (currentSpot.isHasDSunflower()) {
				int currentHealth = currentSpot.getSpotDSunflower().getHealth();
				turnDescriptionZombie += " Double Sunflower current health: " + String.valueOf(currentHealth) + "\n"
						+ "Bucket Zombie attacks the double sunflower at SpotId: " + String.valueOf(currentSpot.getSpotId())
						+ "\n";
				currentSpot.getSpotDSunflower().setHealth(currentHealth - attackDamage);
				;
				turnDescriptionZombie += "Double sunflower lost" + String.valueOf(attackDamage) + " Current health: "
						+ String.valueOf(currentHealth - attackDamage) + "\n";

				if (currentSpot.getSpotDSunflower().getHealth() <= 0) {
					currentSpot.getSpotDSunflower().setAlive(false);
					currentSpot.setHasDSunflower(false);
					currentSpot.setFilled(false);
					turnDescriptionZombie += "Bucket Zombie killed the double sunflower at spotID : "
							+ String.valueOf(currentSpot.getSpotId());
				}
			}

			else if (currentSpot.isHasSunflower()) {
				int currentHealth = currentSpot.getSpotSunflower().getHealth();
				turnDescriptionZombie += "Sunflower current health: " + String.valueOf(currentHealth) + "\n"
						+ "Bucket Zombie attacks sunfower at SpotId: " + String.valueOf(currentSpot.getSpotId()) + "\n";
				currentSpot.getSpotSunflower().setHealth(currentHealth - attackDamage);
				turnDescriptionZombie += "Sunflower lost " + String.valueOf(attackDamage) + " Current health: "
						+ String.valueOf(currentHealth - attackDamage) + "\n";

				if (currentSpot.getSpotSunflower().getHealth() <= 0) {
					currentSpot.getSpotSunflower().setAlive(false);
					currentSpot.setHasSunflower(false);
					currentSpot.setFilled(false);
					turnDescriptionZombie += "Bucket Zombie killed sunflower at spotId: "
							+ String.valueOf(currentSpot.getSpotId());

				}

			} else if (currentSpot.isHasPea()) {
				int currentHealth = currentSpot.getSpotPeaShooter().getHealth();
				turnDescriptionZombie += "PeaShooter current health: " + String.valueOf(currentHealth) + "\n"
						+ "Bucket Zombie attacks sunfower at SpotId: " + String.valueOf(currentSpot);
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
