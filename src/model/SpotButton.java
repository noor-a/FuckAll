package model;
import javax.swing.*;

import java.awt.Image;
import javax.swing.ImageIcon;
public class SpotButton extends JButton 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int count =0;
	private int spotButtonID = 0;

	
	public SpotButton() 
	{
		super();
		spotButtonID = count++;
	}

	public  int getSpotButtonID() 
	{
		return spotButtonID;
	}

	//// contained in the classpath
	//URL url = getClass().getResource("/path/to/image.jpg");
	//Image image = new ImageIcon(url).getImage();
	public void addZombie() 
	{
		try {
			ImageIcon zombieIcon = new ImageIcon("resources/zombie.png");
			Image zombieImage = zombieIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(zombieImage));
			setDisabledIcon(new ImageIcon(zombieImage));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void addBucketZombie() {
		try {
			ImageIcon zombieIcon = new ImageIcon("resources/BucketZombie.png");
			Image zombieImage = zombieIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(zombieImage));
			setDisabledIcon(new ImageIcon(zombieImage));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void addExplodeZombie() {
		try {
			ImageIcon zombieIcon = new ImageIcon("resources/ExplodeZombie.png");
			Image zombieImage = zombieIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(zombieImage));
			setDisabledIcon(new ImageIcon(zombieImage));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void addSunflower() 
	{
		try {
			ImageIcon sunflowerIcon = new ImageIcon("resources/sunflower.png");
			Image sunflowerImage = sunflowerIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(sunflowerImage));
			setDisabledIcon(new ImageIcon(sunflowerImage));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void addDSunflower(){
		try{
			ImageIcon doublesunflowerIcon= new ImageIcon("resources/Dsunflower.png");
			Image doublesunflowerImage= doublesunflowerIcon.getImage().getScaledInstance(25,25,Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(doublesunflowerImage));
			setDisabledIcon(new ImageIcon(doublesunflowerImage));
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void addPeashooter() 
	{
		try {
			ImageIcon peashooterIcon = new ImageIcon("resources/peashooter.png");
			Image peashooterImage = peashooterIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(peashooterImage));
			//Image won't lose colour when button is disabled
			setDisabledIcon(new ImageIcon(peashooterImage));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}	
	
	public void addPotatoe() 
	{
		try {
			ImageIcon peashooterIcon = new ImageIcon("resources/potatoe.png");
			Image peashooterImage = peashooterIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(peashooterImage));
			//Image won't lose colour when button is disabled
			setDisabledIcon(new ImageIcon(peashooterImage));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
