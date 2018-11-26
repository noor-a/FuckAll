package model;

public class Player {
	private int sunAmount;
	private boolean alive;

	public Player(int startingAmount) {
		this.sunAmount = startingAmount;
		this.alive = true;
	}

	public void die() {
		this.alive = false;
	}

	public void addSun() {
		sunAmount += 10;
	}

	public void addDSun() {
		sunAmount += 20;
	}

	public int getSunAmount() {
		return sunAmount;
	}

	public void setSunAmount(int sunAmount) {
		this.sunAmount = sunAmount;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}