package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.MainClass;
import spaceships.SpaceShip;
import spaceships.SpaceShipENEMY;
import spaceships.SpaceShipENEMY_MINION;
import spaceships.SpaceShipENEMY_MINION_2;
import spaceships.SpaceShipENEMY_MINION_3;
import spaceships.SpaceShipENEMY_NORMAL;
import spaceships_laserguns.Laser;

public class GamePlayScreen extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private SpaceShip userSpaceShip;
	private LinkedList<SpaceShipENEMY> enemylist = new LinkedList<SpaceShipENEMY>();
	private Explosion explist;
	private Lives lives;
	private ImageIcon endimage = null;
	private boolean repaintable = true;

	GamePlayScreen() {
		addKeyListener(this);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		createDeamon();

	}

	public void paintComponent(Graphics g) {
		if (repaintable) {
			super.paintComponent(g);
			userSpaceShip.getSpaceShipImageIcon().paintIcon(this, g, userSpaceShip.getXcoord(),
					userSpaceShip.getYcoord());
			for (int i = 0; i < enemylist.size(); i++) {
				enemylist.get(i).huntUsrSpaceShip(userSpaceShip);

				enemylist.get(i).getSpaceShipImageIcon().paintIcon(this, g, enemylist.get(i).getXcoord(),
						enemylist.get(i).getYcoord());

			}
			if (explist != null) {
				explist.expimg.paintIcon(this, g, explist.getX(), explist.getY());
			}
			for (int i = 0; i < lives.livelist.size(); i++) {
				lives.livelist.get(i).paintIcon(this, g, 20 + 60 * i, (int) MainClass.cosmosHeight - 80);
			}
			if (endimage != null) {
				endimage.paintIcon(this, g, (int) MainClass.cosmosWidth / 2 - 350,
						(int) MainClass.cosmosHeight / 2 - 99);
			}

			ShowLaserShot(g);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP)
			userSpaceShip.moveUP();
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			userSpaceShip.moveDOWN();
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			userSpaceShip.moveLEFT();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			userSpaceShip.moveRIGHT();
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			userSpaceShip.shoot();
		if (e.getKeyCode() == KeyEvent.VK_B) {
			repaintable = false;
			SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
			SpaceFrame.selectSpaceShipScreen.setFocusable(true);
			SpaceFrame.selectSpaceShipScreen.requestFocus();
			resetGame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	void setUserSpaceShip(SpaceShip usel) {
		userSpaceShip = usel;
		System.out.println(userSpaceShip.getLive());
		lives = new Lives(userSpaceShip.getMaxLive(), userSpaceShip.getLive());
		enemylist.add(new SpaceShipENEMY_NORMAL());
		enemylist.add(new SpaceShipENEMY_MINION());
		enemylist.add(new SpaceShipENEMY_MINION_2());
		enemylist.add(new SpaceShipENEMY_MINION_3());
	}

	private void createDeamon() {
		Timer timer = new Timer();
		TimerTask task = new monitorDeamonGame();
		timer.schedule(task, 41, 41);
	}

	class monitorDeamonGame extends TimerTask {
		public void run() {
			repaint();

		}
	}

	private void ShowLaserShot(Graphics g) {

		for (int i = 0; i < userSpaceShip.gun.lasershooterlst.size(); i++) {
			Laser tmp = userSpaceShip.gun.lasershooterlst.get(i);
			g.setColor(userSpaceShip.gun.LaserColor);
			g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y - 15);
			tmp.y = tmp.y - userSpaceShip.getLaserSpeed();
			if (tmp.y < 0)
				userSpaceShip.gun.lasershooterlst.remove(i);
			if (checkForDmage(tmp.x, tmp.y)) {
				userSpaceShip.gun.lasershooterlst.remove(i);
			}
		}
		for (int i = 0; i < enemylist.size(); i++) {
			for (int j = 0; j < enemylist.get(i).gun.lasershooterlst.size(); j++) {
				Laser tmp = enemylist.get(i).gun.lasershooterlst.get(j);
				g.setColor(enemylist.get(i).gun.LaserColor);
				g.drawLine(tmp.x, tmp.y, tmp.x, tmp.y - 15);
				tmp.y = tmp.y + enemylist.get(i).getLaserSpeed();
				if (checkForPlayerDmage(tmp.x, tmp.y)) {
					enemylist.get(i).gun.lasershooterlst.remove(j);

				}
				if (tmp.y > MainClass.cosmosHeight)
					enemylist.get(i).gun.lasershooterlst.remove(j);

			}

		}

	}

	private boolean checkForDmage(int x, int y) {
		int des;
		for (des = 0; des < enemylist.size(); des++) {
			if (enemylist.get(des).isHitable()) {

				if (x >= enemylist.get(des).getXcoord()
						&& x <= enemylist.get(des).getXcoord() + enemylist.get(des).spaceShipWidth
						&& y <= enemylist.get(des).getYcoord() + enemylist.get(des).spaceShipHeight) {
					if (enemylist.get(des).getLive() <= 1) {
						enemylist.get(des).setHitable(false);
						explist = new Explosion(enemylist.get(des).getXcoord(), enemylist.get(des).getYcoord());
						enemylist.remove(des);
					} else {
						enemylist.get(des).setLive(enemylist.get(des).getLive() - 1);
					}

					if (enemylist.size() == 0) {
						createEnsSceen(true);
						userSpaceShip.setMoveable(false);
					}

					return true;
				}
			}
		}
		return false;

	}

	private boolean checkForPlayerDmage(int x, int y) {
		if (x >= userSpaceShip.getXcoord() && x <= userSpaceShip.getXcoord() + userSpaceShip.spaceShipWidth
				&& y >= userSpaceShip.getYcoord() + userSpaceShip.spaceShipHeight && userSpaceShip.isHitable()) {
			if (userSpaceShip.getLive() > 1) {
				userSpaceShip.setLive(userSpaceShip.getLive() - 1);
				lives.loadlifes(userSpaceShip.getLive());
			} else {
				userSpaceShip.setHitable(false);
				userSpaceShip.setLive(userSpaceShip.getLive() - 1);
				lives.loadlifes(userSpaceShip.getLive());
				userSpaceShip.setMoveable(false);
				for (int i = 0; i < enemylist.size(); i++) {
					enemylist.get(i).setMoveable(false);
				}
				createEnsSceen(false);
			}

			return true;

		}
		return false;

	}

	private void createEnsSceen(boolean result) {
		if (result) {
			endimage = new ImageIcon("./Resources/images/win.png");
		} else {
			endimage = new ImageIcon("./Resources/images/loose.png");
		}

	}

	private void resetGame() {
		userSpaceShip = null;
		enemylist.clear();
		explist = null;
		lives = null;
		repaintable = true;
		endimage = null;
		userSpaceShip.gun.lasershooterlst.clear();
	}

}
