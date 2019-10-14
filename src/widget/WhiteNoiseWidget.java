package widget;

import component.Play;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class WhiteNoiseWidget extends Widget {
    public WhiteNoiseWidget(){
        super();
        Label name = new Label("White Noise");

        Button playBtn = new Button("Play");
        component.WhiteNoise whiteNoise = new component.WhiteNoise();

        playBtn.setOnAction(e -> {
            Play.play(whiteNoise);
        });
        super.audioComponent = whiteNoise;
        HBox bottom = new HBox(38);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPadding(new Insets(0, 30, 0 ,30));
        bottom.getChildren().addAll(playBtn, output);
        super.getWidget().getChildren().addAll(name, bottom);
    }
}
