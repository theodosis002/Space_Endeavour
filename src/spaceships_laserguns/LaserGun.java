package spaceships_laserguns;

import java.awt.Color;
import java.util.LinkedList;

public class LaserGun {
	public Color LaserColor;
	public LinkedList<Laser> lasershooterlst = new LinkedList<Laser>();

	public LaserGun(Color LaserColor) {
		this.LaserColor = LaserColor;
	}

	public void fire(int x, int y, int width) {

		lasershooterlst.add(lasershooterlst.size(), new Laser(x, y, width));
	}
}
