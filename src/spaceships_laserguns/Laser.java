package spaceships_laserguns;

import sounds.LaserSound;

public class Laser {
	public int x;
	public int y;

	public Laser(int x, int y, int width) {
		this.x = x + width / 2;
		this.y = y;
		new LaserSound();
	}
}
