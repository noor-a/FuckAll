package model;

public class Doublesunflower extends Plant {
	private int spotId;
	private int xCordinate;
	private int yCordinate;
	private Player player;
	private String turnDescriptionDSunflower = "";

	public Doublesunflower(int spotId, int xCordinate, int yCordinate, Player player) {
		super(200, 100);
		this.spotId = spotId;
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.player = player;
	}

	public Doublesunflower(int xCordinate, int yCordinate, Player player) {
		super(100, 50);
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.player = player;
	}

	public void addDSunToPlayer() {
		player.addDSun();
		turnDescriptionDSunflower = "Sunflower at spotId: " + String.valueOf(spotId) + " added 20 sun to the player!\n"
				+ "Player's current sun balance is: " + String.valueOf(player.getSunAmount() + "\n");
	}

	public String getTurnDescriptionDSunflower() {
		return turnDescriptionDSunflower;
	}

}