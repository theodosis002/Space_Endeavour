package spaceships;

import java.awt.Color;

import javax.swing.ImageIcon;

public class SpaceShipENEMY_MINION_2 extends SpaceShipENEMY {

	public static ImageIcon img = new ImageIcon("./Resources/images/enemy_2.png");
	
	public SpaceShipENEMY_MINION_2() {
		
		super(20, "ENEMY", Color.YELLOW, img,20,45,45,1);

	}

}