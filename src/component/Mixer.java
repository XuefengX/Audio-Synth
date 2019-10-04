package component;

import model.AudioClip;

import java.util.ArrayList;
import java.util.List;

public class Mixer implements AudioComponent{

    private List<AudioComponent> connectedAudios;

    public Mixer(){
        this.connectedAudios = new ArrayList<>();
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

        for(int i = 0; i < connectedAudios.size(); i++){
            AudioClip input = connectedAudios.get(i).getClip();
            for(int j = 0; j < audioClip.getData().length / 2; j++){
                audioClip.setSample(j, clamp(audioClip.getSample(j) + input.getSample(j)));
            }
        }
        return audioClip;
    }

    /**
     * Play.Mixer may have multiple inputs
     *
     * @return how many inputs does it have
     */
    @Override
    public int getNuminputs() {
        return connectedAudios.size();
    }

    /**
     * Get the input name according to the index
     *
     * @param index input index
     * @return the name of input
     */
    @Override
    public String getInputName(int index) {
        if(index > connectedAudios.size() - 1 || index < 0) throw new IndexOutOfBoundsException();
        return connectedAudios.get(index) != null ? connectedAudios.get(index).getClass().getSimpleName() : "";
    }

    /**
     * connect another device to this input.
     * <p>
     * Play.Mixer could take multiple inputs and replace certain input according to the index
     *
     * @param index the index to add or replace
     * @param input input component
     */
    @Override
    public void connectInput(int index, AudioComponent input) {
        if(index < 0) throw new IllegalArgumentException();
        else if(index > connectedAudios.size() - 1)
            connectedAudios.add(input);
        else
            connectedAudios.set(index, input);
    }
}
