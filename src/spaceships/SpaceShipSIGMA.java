package spaceships;

import javax.swing.ImageIcon;
import java.awt.Color;

public class SpaceShipSIGMA extends SpaceShip {

	public static ImageIcon img = new ImageIcon("./Resources/images/SIGMA.png");

	public SpaceShipSIGMA() {
		super(45, "SIGMA",Color.ORANGE,img,50,100,100,4);
	}
}
