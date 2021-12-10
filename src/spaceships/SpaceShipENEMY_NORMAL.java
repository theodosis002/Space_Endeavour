package spaceships;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class SpaceShipENEMY_NORMAL extends SpaceShipENEMY {

	public static ImageIcon img = new ImageIcon("./Resources/images/ENEMY.png");
	
	public SpaceShipENEMY_NORMAL() {
		
		super(15, "ENEMY", Color.YELLOW, set_image(img),20,100,100,2);

	}
	public static ImageIcon set_image(ImageIcon img) {
		Image image = img.getImage();
		img = new ImageIcon(image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH));
		return img;
	}

}