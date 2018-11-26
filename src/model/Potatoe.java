package model;

public class Potatoe extends Plant{
	private int spotId;
	private int xCordinate;
	private int yCordinate;
	private Player player;
	private String turnDescriptionPotatoe = "";
	public static final int COST=200;
	
	public Potatoe(int spotId, int xCordinate, int yCordinate, Player player) 
	{
		super(120, COST);
		this.spotId = spotId;
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.player = player;
	}
	
	public Potatoe(int xCordinate, int yCordinate, Player player) {
		super(600, COST);
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
		this.player = player;
	}
	
	public String getTurnDescriptionPotatoe() 
	{
		return turnDescriptionPotatoe;
	}
}