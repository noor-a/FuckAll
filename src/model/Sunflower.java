package model;

public class Sunflower extends Plant
{
	private int spotId;
	private int xCordinate;
	private int yCordinate;
	private Player player;
	private String turnDescriptionSunflower = "";
	
	public Sunflower(int spotId, int xCordinate, int yCordinate, Player player) 
	{
		super(100, 50);
		this.spotId = spotId;
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.player = player;
	}
	
	public Sunflower(int xCordinate, int yCordinate, Player player) {
		super(100, 50);
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.player = player;
	}

	public void addSunToPlayer() 
	{
		player.addSun();
		turnDescriptionSunflower = "Sunflower at spotId: " + String.valueOf(spotId) + " added 10 sun to the player!\n"
														   + "Player's current sun balance is: " + String.valueOf(player.getSunAmount() + "\n");
	}

	public String getTurnDescriptionSunflower() 
	{
		return turnDescriptionSunflower;
	}
	
	
}