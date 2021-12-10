package gui;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import sounds.ExplosionSound;

public class Explosion {
	private int x, y;
	ImageIcon expimg = new ImageIcon("./Resources/images/exp_1.png");

	public Explosion(int x, int y) {
		this.x = x;
		this.y = y;
		new ExplosionSound();

		Timer timer2 = new Timer();
		TimerTask task2 = new explosion_2();
		timer2.schedule(task2, 164);

		Timer timer3 = new Timer();
		TimerTask task3 = new delete();
		timer3.schedule(task3, 164 * 2);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	class explosion_2 extends TimerTask {

		public void run() {
			expimg = new ImageIcon("./Resources/images/exp_2.png");
		}

	}

	class delete extends TimerTask {

		public void run() {
			expimg = new ImageIcon("./Resources/images/exp_3.png");
			expimg = new ImageIcon();
		}

	}
}
