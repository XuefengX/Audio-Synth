package widget;

import component.AudioComponent;
import component.Play;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Widget for mixer
 * @author xuefeng Xu
 */
public class MixerWidget extends Widget {
    public MixerWidget(){
        super();
        Label name = new Label("Mixer");
        Label label = new Label("Add sound waves");

        Button playBtn = new Button("Play");
        AudioComponent mixer = new component.Mixer();
        this.audioComponent = mixer;
        playBtn.setOnAction(e -> {
            Play.play(mixer);
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label);
        hBox.setPadding(new Insets(0, 10, 0, 10));

        HBox bottom = new HBox(34);
        bottom.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPadding(new Insets(0, 30, 0 ,30));
        bottom.getChildren().addAll(input, playBtn, output);
        super.getWidget().getChildren().addAll(name, hBox, bottom);
    }

}
