package spaceships;

import javax.swing.ImageIcon;
import java.awt.Color;

public class SpaceShipZERO extends SpaceShip {

	public static ImageIcon img = new ImageIcon("./Resources/images/ZERO.png");

	public SpaceShipZERO() {
		super(5, "ZERO",Color.PINK,img,10,100,100,2);
	}

}
