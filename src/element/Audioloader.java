package element;

import javafx.scene.media.AudioClip;

public class Audioloader {
	public static AudioClip mousePressedSound = new AudioClip(ClassLoader.getSystemResource("audio/mousepressedsound.mp3").toString());
	public static AudioClip backGroundSound = new AudioClip(ClassLoader.getSystemResource("audio/backgroundsound.wav").toString());
	public static AudioClip laserSound = new AudioClip(ClassLoader.getSystemResource("audio/jellyBeam.mp3").toString());
	
}
