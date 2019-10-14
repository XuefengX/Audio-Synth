package widget;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * call the appropriate connect method on the AudioComponent members of the widgets being connected
 * (ie, the part that actually makes sound happen).
 *
 * draw a line between the inputs to show the connection visually.
 * @author xuefeng Xu
 */
public class Cable {
    private Line line;
    private Widget input, output;
    public Cable(){
        line = new Line();
        line.setVisible(false);
        line.setStroke(Color.ALICEBLUE);
        line.setStrokeWidth(2);
    }

    public void connect(){
        System.out.println("connecting...");
        System.out.println(output.audioComponent.getClass().toString());
        System.out.println(input.audioComponent.getClass().toString());

        input.getAudioComponent().connectInput(0, output.getAudioComponent());
    }

    public Line getLine(){
        return line;
    }

    public void setInput(Widget input) {
        this.input = input;
    }

    public void setOutput(Widget output) {
        this.output = output;
    }
}
