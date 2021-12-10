package sounds;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class GameAudioPlayer {
	private AudioInputStream audio;
	Clip clip;

	public GameAudioPlayer() {
		loadspaceambient();
	}

	void loadspaceambient() {
		try {
			audio = AudioSystem.getAudioInputStream(new File("./Resources/audio/space-ambience.wav"));
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);

			FloatControl gaincontrol = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gaincontrol.setValue(-15.0f);

			clip.start();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
