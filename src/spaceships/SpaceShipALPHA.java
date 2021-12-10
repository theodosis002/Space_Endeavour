package spaceships;

import javax.swing.ImageIcon;
import java.awt.Color;
public class SpaceShipALPHA extends SpaceShip {
	public static ImageIcon img = new ImageIcon("./Resources/images/ALPHA.png");

	public SpaceShipALPHA() {
		super(10, "ALPHA",Color.BLUE,img,15,100,100,2);
	}

}
