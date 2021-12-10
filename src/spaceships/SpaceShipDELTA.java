package spaceships;

import javax.swing.ImageIcon;
import java.awt.Color;
public class SpaceShipDELTA extends SpaceShip {
	
	public static ImageIcon img = new ImageIcon("./Resources/images/DELTA.png");
	public SpaceShipDELTA() {
		super(40,"DELTA",Color.GREEN,img,45,100,100,3);
		
	}

}
