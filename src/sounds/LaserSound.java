package sounds;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class LaserSound {
	private AudioInputStream audio;
	Clip clip;

	public LaserSound() {
		loadspaceambient();
	}

	void loadspaceambient() {
		try {
			audio = AudioSystem.getAudioInputStream(new File("./Resources/audio/laser.wav"));
			clip = AudioSystem.getClip();
			clip.open(audio);
			

			FloatControl gaincontrol = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gaincontrol.setValue(-29.0f);

			clip.start();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
