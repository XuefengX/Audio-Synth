package component;

import model.AudioClip;

public class SquareWave implements AudioComponent{

    private double frequency;

    public SquareWave(double frequency){
        this.frequency = frequency;
    }

    /**
     * @return the current sound produced by this component
     */
    @Override
    public AudioClip getClip() {
        AudioClip audioClip = new AudioClip();
        for(int i = 0; i < audioClip.getData().length / 2; i++){
            audioClip.setSample(i, (frequency * i / AudioClip.SAMPLE_RATE) % 1 > 0.5 ? Short.MAX_VALUE : Short.MIN_VALUE);
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
