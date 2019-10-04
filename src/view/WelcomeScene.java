package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Welcome scene
 * @author xuefeng Xu
 */
public class WelcomeScene {
    /**
     * render the welcome page
     * the welcome page will lead to the main scene
     * @param s the primary stage
     */
    static void render(Stage s){
        Label welcomeLabel = new Label("Synthesizer v0.0.1");
        Button enterMainScene = new Button("Enter");
        enterMainScene.setOnAction(e -> {
            MainScene.render(s);
        });
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(e -> {
            boolean isClose = Alarm.alarm("Exit", "Do you really want to exit?");
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            if(isClose) stage.close();
        });
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(enterMainScene, exitBtn);
        Separator hr = new Separator();
        VBox vBox = new VBox(10);
        vBox.setMinSize(900, 600);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(welcomeLabel, hr, hBox);
        Scene scene = new Scene(vBox);
        scene.getStylesheets().add("/stylesheet.css");
        s.setScene(scene);
    }
}
