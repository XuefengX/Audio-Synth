package component;

import model.AudioClip;

/**
 * adjusts the input clip's volume before outputting it
 *
 * @author Xuefeng Xu
 * @version 0.0.1
 */
public class Filter implements AudioComponent{

    private double volumeScale;
    private AudioComponent connectedAudio;

    /**
     * Default constructor
     * @param volumeScale the volume of the connected clip
     */
    public Filter(double volumeScale){
        this.volumeScale = volumeScale;
    }

    /**
     * Prevent the scaled sample out of bounds
     * @param sample sample input
     * @return sample in short range
     */
    private int clamp(int sample){
        if(sample > Short.MAX_VALUE) return Short.MAX_VALUE;
        else if(sample < Short.MIN_VALUE) return Short.MIN_VALUE;
        else return sample;
    }

    /**
     * @return the current sound produced by this component
     */
    @Override
    public AudioClip getClip() {
        AudioClip audioClip = new AudioClip();
        if(connectedAudio != null){
            AudioClip input = connectedAudio.getClip();

            for(int i = 0; i < audioClip.getData().length / 2; i++){
                audioClip.setSample(i, clamp((int) (volumeScale * input.getSample(i))));
            }
        }
        return audioClip;
    }

    /**
     * Play.Filter only takes one input
     * @return how many inputs does it have
     */
    @Override
    public int getNuminputs() {
        return 1;
    }

    /**
     * Play.Filter only takes one input
     *
     * @param index input index
     * @return the name of input
     */
    @Override
    public String getInputName(int index) {
        return connectedAudio != null ? connectedAudio.getClass().getSimpleName() : "";
    }

    /**
     * connect another device to this input.
     * <p>
     *
     * connected to an audio
     *
     * @param index
     * @param input input component
     */
    @Override
    public void connectInput(int index, AudioComponent input) {
        connectedAudio = input;
    }

    public void setVolumeScale(double v){
        this.volumeScale = v;
    }
}
