package model;

/***
 * Class of a zombie that has double the attack points of a normal zombie, but it its health
 * is below 30, explodes and kills plant infront of it.
 * 
 * @author Noor
 *
 */
@SuppressWarnings("unused")
public class ExplosiveZombie extends Zombie {

	private int health; 
	private int attackDamage = 20;
	private boolean atPlant;
	private boolean attacking;
	private Spot currentSpot; 
	private Board gameBoard;
	private boolean alive;
	public  String turnDescriptionZombie = "";
	
	public ExplosiveZombie(int health, Spot currentSpot, Board gameBoard) { 
		super(health, currentSpot, gameBoard);	
		this.alive = true;
		this.currentSpot = currentSpot;
		this.atPlant = false;
		this.attacking = false;
		this.gameBoard = gameBoard;
	}
	
	/**
	 * Checks the health of the zombie and explodes if needed
	 */
	public void explode() {
		int frontSpotId = currentSpot.getSpotId() - 1;
		Spot frontSpot = gameBoard.spotAt(frontSpotId);
		if (frontSpot.isHasSunflower()) {
			frontSpot.getSpotSunflower().setAlive(false);
			frontSpot.setHasSunflower(false);
			frontSpot.setFilled(false);
			turnDescriptionZombie += "Explosive Zombie killed sunflower at spotId: "
					+ String.valueOf(frontSpot.getSpotId());
			
		}else if(frontSpot.isHasPea()) {
			frontSpot.getSpotPeaShooter().setAlive(false);
			frontSpot.setHasPea(false);
			frontSpot.setFilled(false);
			turnDescriptionZombie += "Explosive Zombie killed pea shooter at spotId: "
					+ String.valueOf(frontSpot.getSpotId());
		}
		turnDescriptionZombie += "Zombie has Exploded at spotId: " + String.valueOf(frontSpot.getSpotId());
		currentSpot.getSpotZombies().remove(this); //Removes zombie from list
		this.alive = false;		
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
				turnDescriptionZombie += "Explosive Zombie moved from SpotId: " + String.valueOf(currentSpot.getSpotId())
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
			
			/****
			 * The zombie explodes if the is health reaches a certain point
			 */
			if(this.health <= 30) {
				explode();
			}
			
			else if (currentSpot.isHasSunflower()) {
				int currentHealth = currentSpot.getSpotSunflower().getHealth();
				turnDescriptionZombie += "Sunflower current health: " + String.valueOf(currentHealth) + "\n"
						+ "Explosive Zombie attacks sunfower at SpotId: " + String.valueOf(currentSpot.getSpotId()) + "\n";
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
