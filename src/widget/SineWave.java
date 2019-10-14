package widget;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import component.AudioComponent;
import component.Play;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.print.DocFlavor;

/**
 * Widget for sine wave
 * @author xuefeng Xu
 */
public class SineWave extends Widget {
    public SineWave(){
        super();
        Label name = new Label("SineWave");
        Label volumeLabel = new Label("frequency");
        Slider slider = new Slider();
        slider.setMaxWidth(100);
        slider.setMax(2000.0);
        slider.setMin(50.0);
        slider.setValue(220.0);
        Button playBtn = new Button("Play");
        component.SineWave sineWave = new component.SineWave(slider.getValue());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            sineWave.setFrequency(newValue.doubleValue());
        });
        playBtn.setOnAction(e -> {
            sineWave.connectInput(0, sineWave);
            Play.play(sineWave);
        });
        super.audioComponent = sineWave;
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(volumeLabel, slider);
        hBox.setPadding(new Insets(0, 10, 0, 10));
        HBox bottom = new HBox(38);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPadding(new Insets(0, 30, 0 ,30));
        bottom.getChildren().addAll(playBtn, output);
        super.getWidget().getChildren().addAll(name, hBox, bottom);
    }
}
