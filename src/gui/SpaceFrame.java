package gui;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sounds.GameAudioPlayer;

public class SpaceFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	static int width, height;
	static SelectSpaceShipScreen selectSpaceShipScreen = new SelectSpaceShipScreen();
	static GamePlayScreen gamePlayScreen = new GamePlayScreen();
	static CardLayout cardLayout = new CardLayout();
	static JPanel spaceFramePanel = new JPanel();

	public SpaceFrame(int width, int height) {
		SpaceFrame.width = width;
		SpaceFrame.height = height;
		new GameAudioPlayer();
		//this.setUndecorated(true);
		ImageIcon img = new ImageIcon("./Resources/images/ICON.png");
		this.setIconImage(img.getImage());
		this.setSize(width, height);
		this.setTitle("Space Endeavour");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setFocusable(true);
		setupMasterPanel();
		setResizable(false);
		this.setVisible(true);
		



		

	}

	void setupMasterPanel() {
		spaceFramePanel.setLayout(cardLayout);
		spaceFramePanel.add(selectSpaceShipScreen);
		spaceFramePanel.add(gamePlayScreen);
		this.add(spaceFramePanel);
	}



}
