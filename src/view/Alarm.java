package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Alarm window
 *
 * @author Xuefeng Xu
 * @version 0.0.1
 */
public class Alarm {

    /**
     * Create a window that user must handle before continue
     * @param title stage title
     * @param warningMessage label show messages
     * @return
     */
    public static boolean alarm(String title, String warningMessage){
        AtomicBoolean isClose = new AtomicBoolean(true);
        Stage alarmStage = new Stage();
        alarmStage.initModality(Modality.APPLICATION_MODAL);
        alarmStage.setOnCloseRequest(e -> {
            isClose.set(false);
        });

        alarmStage.setTitle(title);
        Label warningLable = new Label(warningMessage);
        Button exitBtn = new Button("Exit");
        exitBtn.setOnAction(e -> {
            alarmStage.close();
        });
        Button backBtn = new Button("Back");
        backBtn.setOnAction(e -> {
            alarmStage.close();
            isClose.set(false);
        });
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(backBtn, exitBtn);
        VBox vBox = new VBox(10);
        vBox.setMinSize(300, 150);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(warningLable, hBox);
        Scene scene = new Scene(vBox);
        alarmStage.setScene(scene);
        alarmStage.showAndWait();
        return isClose.get();
    }
}
