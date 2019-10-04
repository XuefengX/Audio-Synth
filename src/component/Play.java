package component;

import model.AudioClip;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 * Test and play sound
 *
 * @author Xuefeng Xu
 * @version 0.0.1
 */
public class Play {
    public static void play(AudioComponent audioComponent){
        try{
            Clip c = AudioSystem.getClip();
            AudioFormat format16 = new AudioFormat(44100, 16, 1, true, false);

            AudioClip clip = audioComponent.getClip();

            c.open(format16, clip.getData(), 0, clip.getData().length); //reads data from my byte array to play it

            c.start(); //plays it
            c.loop(2); //plays it 2 more times if desired, so 3 seconds total

            //makes sure the program doesn't quit before the sound plays
            while(c.getFramePosition() < AudioClip.DURATION || c.isActive() || c.isRunning()){}

            c.close();
        } catch (LineUnavailableException e){
            System.out.println(e + e.getMessage());
            e.printStackTrace();
        }

    }

}
