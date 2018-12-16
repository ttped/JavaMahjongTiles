import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayClip {
	
	static void play() {
		File sound = new File("res/sounds/single.wav");
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));

			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
			clip.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}