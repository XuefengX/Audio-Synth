package widget;

import component.AudioComponent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * Widget for all kinds of audio components
 *
 * @author xuefeng Xu
 */
public abstract class Widget {
    private VBox widget;
    protected AudioComponent audioComponent;

    static class Position{
        double orgSceneX, orgSceneY;
        double orgTranslateX, orgTranslateY;
    }

    public static class DotPosition{
        double x, y;
    }

    Widget(){
        widget = new VBox(10);
        widget.setMaxSize(200, 100);
        widget.setBorder(new Border(new BorderStroke(Color.rgb(176, 176, 176, 0.5), BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(1))));
        widget.setAlignment(Pos.CENTER);
        widget.setBackground(new Background(new BackgroundFill(Color.rgb(220, 220, 220, 0.1), CornerRadii.EMPTY,
                Insets.EMPTY)));
        // Enable move
        Position position= new Position();
        widget.setOnMousePressed(e -> {
            position.orgSceneX = e.getSceneX();
            position.orgSceneY = e.getSceneY();
            position.orgTranslateX = ((VBox)(e.getSource())).getTranslateX();
            position.orgTranslateY = ((VBox)(e.getSource())).getTranslateY();
        });

        widget.setOnMouseDragged(e -> {
            double offsetX = e.getSceneX() - position.orgSceneX;
            double offsetY = e.getSceneY() - position.orgSceneY;
            double newTranslateX = position.orgTranslateX + offsetX;
            double newTranslateY = position.orgTranslateY + offsetY;

            ((VBox)(e.getSource())).setTranslateX(newTranslateX);
            ((VBox)(e.getSource())).setTranslateY(newTranslateY);
        });
    }

    /**
     * @return a VBox contains all widget elements
     */
    public VBox getWidget(){return widget;};

    public AudioComponent getAudioComponent(){return audioComponent;}

    public abstract void connect(AudioComponent input);
}
