package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainClass;
import sounds.ButtonSound;
import spaceships.SpaceShip;
import spaceships.SpaceShipALPHA;
import spaceships.SpaceShipBETA;
import spaceships.SpaceShipDELTA;
import spaceships.SpaceShipENEMY_MINION;
import spaceships.SpaceShipENEMY_MINION_2;
import spaceships.SpaceShipENEMY_MINION_3;
import spaceships.SpaceShipENEMY_NORMAL;
import spaceships.SpaceShipGAMA;
import spaceships.SpaceShipSIGMA;
import spaceships.SpaceShipZERO;

public class SelectSpaceShipScreen extends JPanel {
	private static final long serialVersionUID = 1L;

	SelectSpaceShipScreen() {
		this.setLayout(new BorderLayout());
		this.add(createNorthPanel(), BorderLayout.NORTH);
		this.add(createCenterPanel(), BorderLayout.CENTER);
		this.add(createSouthPanel(), BorderLayout.SOUTH);

	}

	private JPanel createSouthPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridBagLayout());
		panel.setPreferredSize(new Dimension(600, 240));

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(3, 3, 3, 3);

		gbc.weighty = 0.2;

		JLabel label = new JLabel("Info: ");
		label.setForeground(Color.WHITE);
		label.setFont(MainClass.TitleFont2);

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(label, gbc);

		JLabel label2 = new JLabel();
		label2.setIcon(new ImageIcon("./Resources/images/enemy_1.png"));
		label2.setSize(50, 50);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(label2, gbc);

		SpaceShip temp = new SpaceShipENEMY_MINION();
		JLabel labeltxt = new JLabel("HP: " + temp.getMaxLive());
		labeltxt.setForeground(Color.WHITE);
		labeltxt.setFont(MainClass.ButtonFont);

		gbc.gridx = 1;
		gbc.gridy = 2;
		panel.add(labeltxt, gbc);

		JLabel label3 = new JLabel();
		label3.setIcon(new ImageIcon("./Resources/images/enemy_2.png"));
		label3.setSize(50, 50);

		gbc.gridx = 4;
		gbc.gridy = 2;
		panel.add(label3, gbc);

		temp = new SpaceShipENEMY_MINION_2();
		JLabel labeltxt2 = new JLabel("HP: " + +temp.getMaxLive());
		labeltxt2.setForeground(Color.WHITE);
		labeltxt2.setFont(MainClass.ButtonFont);

		gbc.gridx = 6;
		gbc.gridy = 2;
		panel.add(labeltxt2, gbc);

		JLabel label4 = new JLabel();
		label4.setIcon(new ImageIcon("./Resources/images/enemy_3.png"));
		label4.setSize(50, 50);

		gbc.gridx = 8;
		gbc.gridy = 2;
		panel.add(label4, gbc);

		temp = new SpaceShipENEMY_MINION_3();
		JLabel labeltxt3 = new JLabel("HP: " + +temp.getMaxLive());
		labeltxt3.setForeground(Color.WHITE);
		labeltxt3.setFont(MainClass.ButtonFont);

		gbc.gridx = 10;
		gbc.gridy = 2;
		panel.add(labeltxt3, gbc);

		JLabel label5 = new JLabel();
		ImageIcon img = new ImageIcon("./Resources/images/ENEMY.png");
		Image image = img.getImage();
		img = new ImageIcon(image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		label5.setIcon(img);
		label5.setSize(50, 50);

		gbc.gridx = 11;
		gbc.gridy = 2;
		panel.add(label5, gbc);

		temp = new SpaceShipENEMY_NORMAL();
		JLabel labeltxt4 = new JLabel("HP: " + +temp.getMaxLive());
		labeltxt4.setForeground(Color.WHITE);
		labeltxt4.setFont(MainClass.ButtonFont);

		gbc.gridx = 12;
		gbc.gridy = 2;
		panel.add(labeltxt4, gbc);

		return panel;

	}

	private JPanel createNorthPanel() {

		JPanel panel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		panel.setPreferredSize(new Dimension(200, 300));
		panel.setLayout(new GridBagLayout());
		JLabel label = new JLabel("Please choose your Spaceship ");
		JLabel label2 = new JLabel();
		label.setFont(MainClass.TitleFont);
		label.setForeground(Color.WHITE);
		label2.setIcon(new ImageIcon("./Resources/images/SPACE.png"));
		panel.setBackground(Color.BLACK);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(label, gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(label2, gbc);

		return panel;
	}

	private JPanel createCenterPanel() {
		JPanel panel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setPreferredSize(new Dimension(200, 500));
		panel.setLayout(new GridBagLayout());
		panel.setBackground(Color.BLACK);
		JButton btnZERO = new JButton("ZERO");
		JButton btnALPHA = new JButton("ALPHA");
		JButton btnBETA = new JButton("BETA");
		JButton btnDELTA = new JButton("DELTA");
		JButton btnGAMA = new JButton("GAMA");
		JButton btnSIGMA = new JButton("SIGMA");

		btnZERO.addActionListener(new SpaceShipSelectionHandler("SZERO"));
		btnALPHA.addActionListener(new SpaceShipSelectionHandler("SALPHA"));
		btnBETA.addActionListener(new SpaceShipSelectionHandler("SBETA"));
		btnGAMA.addActionListener(new SpaceShipSelectionHandler("SGAMA"));
		btnDELTA.addActionListener(new SpaceShipSelectionHandler("SDELTA"));
		btnSIGMA.addActionListener(new SpaceShipSelectionHandler("SSIGMA"));

		btnZERO.setIcon(SpaceShipZERO.img);
		btnALPHA.setIcon(SpaceShipALPHA.img);
		btnBETA.setIcon(SpaceShipBETA.img);
		btnGAMA.setIcon(SpaceShipGAMA.img);
		btnDELTA.setIcon(SpaceShipDELTA.img);
		btnSIGMA.setIcon(SpaceShipSIGMA.img);

		button_configuration(btnZERO);
		button_configuration(btnALPHA);
		button_configuration(btnBETA);
		button_configuration(btnDELTA);
		button_configuration(btnGAMA);
		button_configuration(btnSIGMA);
		gbc.gridheight = 4;
		gbc.gridx = 0;
		gbc.gridy = 6;
		panel.add(btnZERO, gbc);
		gbc.gridx = 1;
		gbc.gridy = 6;
		panel.add(btnALPHA, gbc);
		gbc.gridx = 2;
		gbc.gridy = 6;
		panel.add(btnBETA, gbc);
		gbc.gridx = 4;
		gbc.gridy = 6;
		panel.add(btnDELTA, gbc);
		gbc.gridx = 3;
		gbc.gridy = 6;
		panel.add(btnGAMA, gbc);
		gbc.gridx = 5;
		gbc.gridy = 6;
		panel.add(btnSIGMA, gbc);
		// panel.add(btnENEMY);
		return panel;

	}

	void button_configuration(JButton button) {
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setFocusable(true);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setForeground(Color.WHITE);
		button.setFont(MainClass.ButtonFont);
		button.addMouseListener(new MouseAdapter() {
			Color color = button.getForeground();
			String temp2 = button.getText();

			public void mouseEntered(MouseEvent me) {
				color = button.getForeground();
				SpaceShip temp = null;
				if (temp2.equals("ZERO"))
					temp = new SpaceShipZERO();

				if (temp2.equals("ALPHA"))
					temp = new SpaceShipALPHA();

				if (temp2.equals("BETA"))
					temp = new SpaceShipBETA();

				if (temp2.equals("GAMA"))
					temp = new SpaceShipGAMA();

				if (temp2.equals("DELTA"))
					temp = new SpaceShipDELTA();

				if (temp2.equals("SIGMA"))
					temp = new SpaceShipSIGMA();

				button.setText("<html>" + "<br>" + "<br>" + "Speed: " + temp.getSpeed() + "<br>" + "<br>" + "Power: "
						+ temp.getLaserSpeed() + "<br>" + "<br>" + "Lives: " + temp.getLive() + "</html>");

			}

			public void mouseExited(MouseEvent me) {
				button.setForeground(color);
				button.setText(temp2);
			}
		});

	}

	class SpaceShipSelectionHandler implements ActionListener {

		String name;

		public SpaceShipSelectionHandler(String x) {
			this.name = x;
		}

		public void actionPerformed(ActionEvent ev) {
			SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
			SpaceFrame.gamePlayScreen.setFocusable(true);
			SpaceFrame.gamePlayScreen.requestFocus();
			System.out.println(name);
			new ButtonSound();
			if (name.equals("SZERO"))
				SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipZERO());
			if (name.equals("SALPHA"))
				SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipALPHA());
			if (name.equals("SBETA"))
				SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipBETA());
			if (name.equals("SGAMA"))
				SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipGAMA());
			if (name.equals("SDELTA"))
				SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipDELTA());
			if (name.equals("SSIGMA"))
				SpaceFrame.gamePlayScreen.setUserSpaceShip(new SpaceShipSIGMA());

		}

	}

}
