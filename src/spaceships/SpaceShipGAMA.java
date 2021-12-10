package spaceships;

import javax.swing.ImageIcon;
import java.awt.Color;

public class SpaceShipGAMA extends SpaceShip {

	public static ImageIcon img = new ImageIcon("./Resources/images/GAMA.png");

	public SpaceShipGAMA() {
		super(30, "GAMA",Color.GREEN,img,35,100,100,3);
	}

}
