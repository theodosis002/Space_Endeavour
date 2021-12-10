package gui;

import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Lives {
	int maxlives;
	int lives;
	static ImageIcon liveimg = new ImageIcon("./Resources/images/live.png");
	static ImageIcon noliveimg = new ImageIcon("./Resources/images/nolive.png");
	LinkedList<ImageIcon> livelist = new LinkedList<ImageIcon>();

	public Lives(int maxlives, int lives) {
		this.maxlives = maxlives;
		this.lives = lives;
		loadlifes(lives);
	}

	public void loadlifes(int lives) {
		if (maxlives == lives) {
			for (int i = 0; i < maxlives; i++) {
				livelist.add(liveimg);
			}
		} else {
			int i;
			for (i = lives; i < maxlives; i++) {
				livelist.set(i, noliveimg);
			}
		}

	}

}
