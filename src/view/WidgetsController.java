package view;

import javafx.geometry.Bounds;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import widget.Cable;
import widget.Widget;
import java.util.List;

class WidgetsController {
    static void setOnPaneMouseAction(Pane pane, List<Widget> allWidgets, List<Cable> allCables) {
        boolean isConnected = false;
        pane.setOnMouseClicked(mouseEvent -> {
            for(var widget : allWidgets){
                Circle output = widget.getOutput();
                Circle input = widget.getInput();
                Bounds b = output.localToScene(output.getBoundsInLocal());
                Bounds c = input.localToScene(input.getBoundsInLocal());
                if(distanceToMouse(b, mouseEvent) < output.getRadius()){
                    System.out.println("Get Output");
                    output.setFill(Color.DARKSALMON);
                    Cable cable = new Cable();
                    cable.getLine().setVisible(true);
                    cable.getLine().setStartX(b.getMinX() + b.getWidth() / 2);
                    cable.getLine().setStartY(b.getMinY() + b.getHeight() / 2 - 100);
                    allCables.add(cable);
                    cable.setOutput(widget);
                    System.out.println("output: " + widget.getAudioComponent().getClass().toString());
                }
                else if(distanceToMouse(c, mouseEvent) < input.getRadius()){
                    System.out.println("Connect Input");
                    input.setFill(Color.DARKTURQUOISE);
                    if(!allCables.isEmpty()){
                        Cable cable = allCables.get(allCables.size() - 1);
                        cable.getLine().setEndX(c.getMinX() + c.getWidth() / 2);
                        cable.getLine().setEndY(c.getMinY() + c.getHeight() / 2 - 100);
                        if(!pane.getChildren().contains(cable.getLine())){
                            pane.getChildren().add(cable.getLine());
                        }
                        System.out.println("input: " + widget.getAudioComponent().getClass().toString());
                        cable.setInput(widget);
                        cable.connect();
                    }
                }
            }
        });
    }


    private static double distanceToMouse(Bounds b, MouseEvent mouseEvent){
        double cicleX = b.getMinX() + b.getWidth() / 2;
        double cicleY = b.getMinY() + b.getHeight() / 2;
        double x = mouseEvent.getSceneX() - cicleX;
        double y = mouseEvent.getSceneY() - cicleY;

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
