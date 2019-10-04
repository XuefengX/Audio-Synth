package widget;

import component.AudioComponent;
import component.Filter;
import component.Play;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Widget for the volume
 *
 * @author xuefeng Xu
 */
public class Volume extends Widget{
    private Circle input, output;
    public Volume(){
        super();
        Label name = new Label("Filter");
        Label volumeLabel = new Label("Volume");
        Slider slider = new Slider();
        slider.setMaxWidth(120);
        slider.setMax(20.0);
        slider.setMin(0.0);
        slider.setValue(3);
        Button playBtn = new Button("Play");
        Filter volume = new component.Filter(slider.getValue());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            volume.setVolumeScale(newValue.doubleValue());
        });
        playBtn.setOnAction(e -> {
            volume.connectInput(0, volume);
            Play.play(volume);
        });
        this.audioComponent = volume;
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(volumeLabel, slider);
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
        super.audioComponent.connectInput(0, input);
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
