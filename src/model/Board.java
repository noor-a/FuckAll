package model;

import java.util.ArrayList;

public class Board 
{
	public static int xSize = 10;
	protected static int ySize = 5;
	private ArrayList<Spot> grid;
	private Player player;
	private boolean gameOver = false;
	
	public Board(Player player) 
	{
		this.player = player;
		int count = 0;
		
		grid = new ArrayList<Spot>();
		for(int i = 0; i < ySize; i++) 
		{
			for(int j = 0; j < xSize; j++) 
			{
				Spot s = new Spot(count, j, i, false);
				grid.add(s);
				count++;
			}
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getxSize() 
	{
		return xSize;
	}

	
	public int getySize() 
	{
		return ySize;
	}
	
	
	public Spot spotAt(int x, int y) 
	{
		for(Spot s : this.getGrid()) 
		{
			if(s.getxCord() == x) 
			{
				if(s.getyCord() == y) 
				{
					return s; 
				}
			}
		}
		return null;
	}
	
	public Spot spotAt(int spotId) 
	{
		for(Spot s: this.getGrid()) 
		{
			if(s.getSpotId() == spotId) 
			{
				return s;
			}
		}
		return null;
	}


	public ArrayList<Spot> getGrid() {
		return grid;
	}

	public void setGrid(ArrayList<Spot> grid) {
		this.grid = grid;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public void setySize(int ySize)
	{
		this.ySize = ySize;
	}
	
	public void setGameOver() 
	{
		this.gameOver = true;
	}
	
	public boolean isGameOver() 
	{
		return this.gameOver;
	}
}
