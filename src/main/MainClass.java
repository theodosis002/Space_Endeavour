package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import gui.SpaceFrame;

public class MainClass {
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static Font TitleFont = null;
	public static Font ButtonFont = null;
	public static Font TitleFont2 = null;

	public static double cosmosWidth = screenSize.getWidth();
	public static double cosmosHeight = screenSize.getHeight();

	public static void main(String[] args) {
		try {
			TitleFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Resources/Fonts/BarcadeBrawlRegular.ttf"))
					.deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(TitleFont);

			ButtonFont = Font.createFont(Font.TRUETYPE_FONT, new File("./Resources/Fonts/BarcadeBrawlRegular.ttf"))
					.deriveFont(10f);
			GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge2.registerFont(ButtonFont);

			TitleFont2 = Font.createFont(Font.TRUETYPE_FONT, new File("./Resources/Fonts/BarcadeBrawlRegular.ttf"))
					.deriveFont(14f);
			GraphicsEnvironment ge3 = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge3.registerFont(ButtonFont);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		new SpaceFrame((int) cosmosWidth, (int) cosmosHeight);
	}
}