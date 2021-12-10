package spaceships;

import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;

public abstract class SpaceShipENEMY extends SpaceShip {

	public SpaceShipENEMY(int speed, String name, Color color, ImageIcon img, int laseSpeed, int spw, int sph,
			int life) {
		super(speed, name, color, img, laseSpeed, spw, sph, life);
	}

	static Random random = new Random();

	public void huntUsrSpaceShip(SpaceShip usrspaceship) {
		int mv = random.nextInt(20);
		if (mv == 0) {
			this.shoot();
		}
		int ch = random.nextInt(7);
		int ch_c = random.nextInt(7);
		if (ch == ch_c || ch == ch_c - 1 || ch == ch_c + 1) {
			if (usrspaceship.getXcoord() > this.getXcoord()) {
				this.moveRIGHT();
			} else
				this.moveLEFT();
		}

		int res = random.nextInt(8);
		if (res == 2)
			this.moveLEFT();
		if (res == 1)
			this.moveRIGHT();
	}

}
