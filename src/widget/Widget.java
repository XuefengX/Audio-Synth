package widget;

import component.AudioComponent;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Widget for all kinds of audio components
 *
 * @author xuefeng Xu
 */
public abstract class Widget {
    private VBox widget;
    Circle input, output;
    AudioComponent audioComponent;

    static class Position{
        double orgSceneX, orgSceneY;
        double orgTranslateX, orgTranslateY;
    }

    Widget(){
        widget = new VBox(10);
        widget.setMaxSize(200, 100);
        widget.setPadding(new Insets(10, 0, 10, 0));
        widget.setBorder(new Border(new BorderStroke(Color.rgb(176, 176, 176, 0.5), BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                new BorderWidths(1))));
        widget.setAlignment(Pos.CENTER);
        widget.setBackground(new Background(new BackgroundFill(Color.rgb(220, 220, 220, 0.1), CornerRadii.EMPTY,
                Insets.EMPTY)));
        // Enable move
        Position position= new Position();
        output = new Circle(5);
        output.setFill(Color.ALICEBLUE);
        input = new Circle(5);
        input.setFill(Color.ALICEBLUE);
        Bounds inputBounds = input.localToScene(input.getBoundsInParent());
        Bounds outputBounds = output.localToScene(output.getBoundsInParent());

        widget.setOnMousePressed(e -> {
            position.orgSceneX = e.getSceneX();
            position.orgSceneY = e.getSceneY();
            position.orgTranslateX = ((VBox)(e.getSource())).getTranslateX();
            position.orgTranslateY = ((VBox)(e.getSource())).getTranslateY();
        });

        widget.setOnMouseDragged(e -> {
           // if(!(distanceToMouse(input, e) < input.getRadius()) && !(distanceToMouse(output, e) < output.getRadius
            // ())){
                double offsetX = e.getSceneX() - position.orgSceneX;
                double offsetY = e.getSceneY() - position.orgSceneY;
                double newTranslateX = position.orgTranslateX + offsetX;
                double newTranslateY = position.orgTranslateY + offsetY;

                ((VBox)(e.getSource())).setTranslateX(newTranslateX);
                ((VBox)(e.getSource())).setTranslateY(newTranslateY);
           // }
        });
    }

    /**
     * @return a VBox contains all widget elements
     */
    public VBox getWidget(){return widget;};

    public AudioComponent getAudioComponent(){return audioComponent;}

    public Circle getInput() {
        return input;
    }

    public Circle getOutput() {
        return output;
    }
}
