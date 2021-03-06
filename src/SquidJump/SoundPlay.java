package SquidJump;

import javax.sound.sampled.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SoundPlay {

    public Clip clip;

    public SoundPlay(String file, float num) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(getClass().getResource(file));
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.setFramePosition(0);
            FloatControl gaiControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            double gain = num;
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
            gaiControl.setValue(dB);
            clip.start();
        } catch (LineUnavailableException e) {
//            Logger.getLogger(soundBG.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e) {
//            Logger.getLogger(soundBG.class.getName()).log(Level.SEVERE, null, e);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }
}
