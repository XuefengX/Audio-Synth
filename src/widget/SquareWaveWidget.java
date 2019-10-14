package widget;

import component.Play;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class SquareWaveWidget extends Widget{
    public SquareWaveWidget(){
        super();
        Label name = new Label("Square Wave");
        Label volumeLabel = new Label("frequency");
        Slider slider = new Slider();
        slider.setMaxWidth(100);
        slider.setMax(2000.0);
        slider.setMin(50.0);
        slider.setValue(220.0);
        Button playBtn = new Button("Play");
        component.SquareWave squareWave = new component.SquareWave(slider.getValue());
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            squareWave.setFrequency(newValue.doubleValue());
        });
        playBtn.setOnAction(e -> {
            squareWave.connectInput(0, squareWave);
            Play.play(squareWave);
        });
        super.audioComponent = squareWave;
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
