package widget;

import component.AudioComponent;
import component.Play;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Widget for mixer
 * @author xuefeng Xu
 */
public class MixerWidget extends Widget {
    private Circle input, output;
    public MixerWidget(){
        super();
        Label name = new Label("Mixer");
        Label label = new Label("Add sound waves");

        Button playBtn = new Button("Play");
        AudioComponent mixer = new component.Mixer();
        playBtn.setOnAction(e -> {
            Play.play(mixer);
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label);
        hBox.setPadding(new Insets(0, 10, 0, 10));
        output = new Circle(5);
        output.setFill(Color.ALICEBLUE);
        input = new Circle(5);
        input.setFill(Color.ALICEBLUE);
        HBox bottom = new HBox(34);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPadding(new Insets(0, 30, 0 ,30));
        bottom.getChildren().addAll(input, playBtn, output);
        super.getWidget().getChildren().addAll(name, hBox, bottom);
    }

    @Override
    public void connect(AudioComponent input) {
        super.audioComponent.connectInput(super.audioComponent.getNuminputs(), input);
    }

    public DotPosition getOutputPosition(){
        DotPosition pos = new DotPosition();
        pos.x = output.getTranslateX();
        pos.y = output.getTranslateY();
        return pos;
    }

    public DotPosition getInputPosition(){
        DotPosition pos = new DotPosition();
        pos.x = input.getTranslateX();
        pos.y = input.getTranslateY();
        return pos;
    }
}
