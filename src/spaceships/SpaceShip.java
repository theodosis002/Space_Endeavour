package spaceships;

import javax.swing.ImageIcon;
import java.awt.Color;
import main.MainClass;
import spaceships_laserguns.LaserGun;

public abstract class SpaceShip implements Navigation {
	static int Yoffset = 100;
	static int Xoffset = 50;// World Parameters

	private String name;
	private Color color;
	public ImageIcon SpaceShipImageIcon; // SpaceShip Values
	private int speed;
	private int Xcoord;
	private int Ycoord;
	public int spaceShipWidth;
	public int spaceShipHeight;
	public LaserGun gun;
	private int laserSpeed;
	private int maxlife;
	private int life;
	private boolean hitable = true;
	private boolean moveable = true;

	public SpaceShip(int speed, String name, Color color, ImageIcon SpaceShipImageIcon, int laserSpeed,
			int spaceShipWidth, int spaceShipHeight, int life) {
		this.speed = speed;
		this.name = name;
		this.color = color;
		this.maxlife = life;
		this.life = life;
		this.spaceShipWidth = spaceShipWidth;
		this.spaceShipHeight = spaceShipHeight;
		this.SpaceShipImageIcon = SpaceShipImageIcon;
		this.gun = new LaserGun(this.color);
		this.laserSpeed = laserSpeed;
		if (name == "ENEMY") {
			this.Xcoord = (int) (MainClass.cosmosWidth) - spaceShipWidth - Xoffset;
			this.Ycoord = Yoffset;
		} else {
			this.Xcoord = (int) (MainClass.cosmosWidth / 2) - spaceShipWidth / 2;
			this.Ycoord = (int) (MainClass.cosmosHeight) - Yoffset - spaceShipHeight;
		}
	}

	public ImageIcon getSpaceShipImageIcon() {
		return SpaceShipImageIcon;
	}

	public ImageIcon setSpaceShipImageIcon(ImageIcon img) {
		return this.SpaceShipImageIcon = img;
	}

	public String getName() {
		return name;
	}

	public int getSpeed() {
		return speed;
	}

	public int getXcoord() {
		return Xcoord;
	}

	public int getYcoord() {
		return Ycoord;
	}

	public Color getColor() {
		return color;
	}

	public int getLaserSpeed() {
		return laserSpeed;
	}

	public boolean isHitable() {
		return hitable;
	}

	public int getLive() {
		return life;
	}

	public void setLive(int life) {
		this.life = life;
	}

	public int getMaxLive() {
		return maxlife;
	}

	public void setHitable(boolean hitable) {
		this.hitable = hitable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}

	public int moveUP() {
		if (moveable) {
			Ycoord -= speed;
			if (Ycoord < Yoffset) {
				Ycoord = Yoffset;
			}

		}
		return Ycoord;
	}

	public int moveDOWN() {
		if (moveable) {
			Ycoord += speed;
			if (Ycoord + spaceShipHeight > MainClass.cosmosHeight - Yoffset) {
				Ycoord = (int) (MainClass.cosmosHeight - Yoffset - spaceShipHeight);
			}
		}

		return Ycoord;
	}

	public int moveLEFT() {
		if (moveable) {
			Xcoord -= speed;
			if (Xcoord < Xoffset) {
				Xcoord = Xoffset;
			}
		}

		return Xcoord;
	}

	public int moveRIGHT() {
		if (moveable) {
			Xcoord += speed;
			if (Xcoord + spaceShipWidth > MainClass.cosmosWidth - Xoffset) {
				Xcoord = (int) (MainClass.cosmosWidth) - Xoffset - spaceShipWidth;
			}
		}

		return Xcoord;
	}

	public void shoot() {
		if (moveable) {
			if (this instanceof SpaceShipENEMY) {
				gun.fire(this.getXcoord(), this.getYcoord() + spaceShipHeight, this.spaceShipWidth);
			} else {
				gun.fire(this.getXcoord(), this.getYcoord(), this.spaceShipWidth);
			}
		}

	}

}
