package view;

import widget.SineWave;
import widget.Widget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Render the main storyboard and set layout
 * @author xuefeng Xu
 */
public class MainScene {

    private static Button addBasic;
    private static Button squareWave;
    private static Button whiteNoise;
    private static Button triangleWave;
    private static Button sawtooth;
    private static Button reverb;

    private static Button clearBtn;
    private static Button mixBtn;
    private static Button volumeBtn;

    /**
     * Render the main storyboard
     * @param s primary stage
     */
    static void render(Stage s){
        BorderPane borderPane = new BorderPane();
        borderPane.setMinSize(900, 600);
        loadLayout(borderPane);
        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add("/stylesheet.css");
        s.setScene(scene);
    }

    /**
     * Set layout for the main scene
     * @param borderPane major layout of the scene
     */
    private static void loadLayout(BorderPane borderPane){
        borderPane.setRight(setRight());
        borderPane.setTop(setTop());
        borderPane.setCenter(setCenter());
    }

    /**
     * Put control button and menu on the right
     * @return GridPane
     */
    private static GridPane setRight(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        VBox soundMenu = new VBox(10);
        soundMenu.setPrefWidth(170);
        Label soundLabel = new Label("Add A Sound and Mix It!");
        addBasic = new Button("SineWave");
        addBasic.setMinWidth(soundMenu.getPrefWidth());
        volumeBtn = new Button("Volume");
        volumeBtn.setMinWidth(soundMenu.getPrefWidth());
        mixBtn = new Button("Mixer");
        mixBtn.setMinWidth(soundMenu.getPrefWidth());
        squareWave = new Button("SquareWave");
        squareWave.setMinWidth(soundMenu.getPrefWidth());
        whiteNoise = new Button("WhiteNoise");
        whiteNoise.setMinWidth(soundMenu.getPrefWidth());
        triangleWave = new Button("TriangleWave");
        triangleWave.setMinWidth(soundMenu.getPrefWidth());
        sawtooth = new Button("Sawtooth");
        sawtooth.setMinWidth(soundMenu.getPrefWidth());
        reverb = new Button("Reverb");
        reverb.setMinWidth(soundMenu.getPrefWidth());

        Separator hr = new Separator();
        clearBtn = new Button("Clear");
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(e -> {
            boolean isClose = Alarm.alarm("Exit", "This program will exit soon.\nAll unsaved changes will be " +
                    "discarded.");
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            if(isClose) stage.close();
        });

        soundMenu.getChildren().addAll(soundLabel, addBasic, squareWave, whiteNoise, triangleWave, sawtooth,
                reverb, volumeBtn,
                mixBtn);
        VBox optionMenu = new VBox(10);
        optionMenu.setPrefWidth(170);
        optionMenu.getChildren().addAll(hr, clearBtn, exitBtn);
        exitBtn.setMinWidth(optionMenu.getPrefWidth());
        clearBtn.setMinWidth(optionMenu.getPrefWidth());
        optionMenu.setAlignment(Pos.BOTTOM_CENTER);
        gridPane.add(soundMenu, 0, 0);
        gridPane.add(optionMenu, 0, 1);
        return gridPane;
    }

    /**
     * Add title to the top
     * @return A GridPane
     */
    private static GridPane setTop(){
        Label iconLabel = new Label("Synthesizer v0.0.1");
        GridPane gridPane = new GridPane();
        gridPane.setMinHeight(100);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(iconLabel, 0 ,0);
        gridPane.setBorder(new Border(new BorderStroke(Color.rgb(176, 176, 176, 0.7),
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(20))));
        return gridPane;
    }

    /**
     * Add widgets to the center
     * @return a StackPane contains new widgets
     */
    private static StackPane setCenter(){
        StackPane stackPane = new StackPane();
        addBasic.setOnAction(e -> {
            Widget sineWave = new SineWave();
            stackPane.getChildren().add(sineWave.getWidget());
        });
        volumeBtn.setOnAction(e -> {
            Widget volume = new widget.Volume();
            stackPane.getChildren().add(volume.getWidget());
        });
        mixBtn.setOnAction(e -> {
            Widget mixer = new widget.MixerWidget();
            stackPane.getChildren().add(mixer.getWidget());
        });
        clearBtn.setOnAction(e -> {
            stackPane.getChildren().clear();
        });
        return stackPane;
    }
}
