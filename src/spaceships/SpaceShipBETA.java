package spaceships;

import javax.swing.ImageIcon;
import java.awt.Color;
public class SpaceShipBETA extends SpaceShip {
	
	public static ImageIcon img = new ImageIcon("./Resources/images/BETA.png");
	public SpaceShipBETA() {
		super(20, "BETA",Color.RED,img,25,100,100,2);
	}

}
