package spaceships;

import java.awt.Color;

import javax.swing.ImageIcon;

public class SpaceShipENEMY_MINION extends SpaceShipENEMY {

	public static ImageIcon img = new ImageIcon("./Resources/images/enemy_1.png");
	
	public SpaceShipENEMY_MINION() {
		
		super(10, "ENEMY", Color.YELLOW, img,15,45,45,1);

	}

}