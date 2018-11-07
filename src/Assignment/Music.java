package Assignment;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//I honestly don't know what half of these things do so
//TIME FOR SHITTY AND VAGUE COMMENTS! WEEE
public class Music {
    //Method to declare the audio file
    public void SoundMusic() {
        File Music = new File("Deemo-Reflection (Mirror Night).wav");
        PlaySound(Music);
    }
    
    //plays the music in background
    static void PlaySound(File Sound) {

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();

            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

}
