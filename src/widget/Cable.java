package widget;

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
    public Cable(){
        line = new Line();
    }

    public void connect(Widget output, Widget input){
        
    }
}
