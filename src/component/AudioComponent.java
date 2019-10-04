package component;

import model.AudioClip;

/**
 * components of our synthesizer will have a single output (an Play.AudioClip)
 * and zero or more inputs (things that produce AudioClips)
 *
 * @author Xuefeng Xu
 * @version 0.0.1
 */
public interface AudioComponent {
    /**
     * @return the current sound produced by this component
     */
    public AudioClip getClip();

    /**
     * @return how many inputs does it have
     */
    public int getNuminputs();

    /**
     * What's input index called?
     * This will be useful when we make our GUI
     *
     * @param index input index
     * @return the name of input
     */
    public String getInputName(int index);

    /**
     * connect another device to this input.
     *
     * For most classes implementing this interface, this method will just store a reference
     * to this Play.AudioComponent.
     *
     * @param index
     * @param input input component
     */
    public void connectInput(int index, AudioComponent input);

}
