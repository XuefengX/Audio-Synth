package view;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main entrance to the application
 * @author xuefeng Xu
 */
public class Main extends Application {

    /**
     * open a window and render the welcome scene
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Synthesizer");
        primaryStage.setResizable(false);

        WelcomeScene.render(primaryStage);

        primaryStage.setOnCloseRequest(e -> {
            boolean isClose = Alarm.alarm("Exit", "Do you want to exit this program?\nAll unsaved changes will be " +
                    "discarded" +
                    ".");

            if(!isClose) e.consume();
        });
        primaryStage.show();
    }

    /**
     * launch program
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
