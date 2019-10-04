package component;

import model.AudioClip;

/**
 * produce an audio clip containing a sine wave
 *
 * @author Xuefeng Xu
 * @version 0.0.1
 */
public class SineWave implements AudioComponent {

    private double frequency;

    public SineWave(double frequency){
        this.frequency = frequency;
    }

    /**
     * @return the current sound produced by this component
     */
    @Override
    public AudioClip getClip() {
        AudioClip audioClip = new AudioClip();
        for(int i = 0; i < audioClip.getData().length / 2; i++){
            audioClip.setSample(i,
                    (int) (Short.MAX_VALUE * Math.sin(2 * Math.PI * frequency * i / AudioClip.SAMPLE_RATE)));
        }
        return audioClip;
    }

    /**
     * Sine Wave take no input
     * @return how many inputs does it have
     */
    @Override
    public int getNuminputs() {
        return 0;
    }

    /**
     * Sine Wave takes no input
     *
     * @param index input index
     * @return the name of input
     */
    @Override
    public String getInputName(int index) {
        return "";
    }

    /**
     * connect another device to this input.
     * <p>
     * Play.SineWave should not connect any inputs
     *
     * @param index
     * @param input input component
     */
    @Override
    public void connectInput(int index, AudioComponent input) {}

    public void setFrequency(double frequency){
        this.frequency = frequency;
    }
}
