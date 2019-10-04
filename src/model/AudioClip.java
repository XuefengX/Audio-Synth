package model;

/**
 * represent an audio clip that will get passed through our system
 *
 * @author Xuefeng Xu
 * @version 0.0.1
 */
public class AudioClip {
    public static final double DURATION = 1.0; // duration 1.0 second
    public static final int SAMPLE_RATE = 44100; // sample rate
    private byte[] sound; //byte array to store the sound

    /**
     * Default constructor
     */
    public AudioClip(){
        sound = new byte[SAMPLE_RATE * 2 * (int) DURATION];
    }

    /**
     * return the sample passed as an int
     *
     * @param index
     * @return
     */
    public int getSample(int index){
        if(index < 0 || index > sound.length) throw new IndexOutOfBoundsException();
        int upperBits = ((int) sound[2 * index + 1]) << 8;
        int lowerBits = sound[2 * index];
        return upperBits | 0xff & lowerBits;
    }

    /**
     * set the sample passed as an int
     * @param index
     * @param value
     */
    public void setSample(int index, int value){
        if(value < -0x8000 || value > 0x7fff) throw new IllegalArgumentException("Value should be in short range");
        sound[2 * index] = (byte) value;
        sound[2 * index + 1] = (byte) (value >> 8);
    }

    /**
     * returns our array
     * We need this method because the Java library that actually plays sounds expects our data as an array of bytes.
     * @return the sound byte array
     */
    public byte[] getData(){
        return sound;
    }
}
