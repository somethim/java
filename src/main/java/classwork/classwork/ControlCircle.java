package classwork.classwork;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ControlCircle extends Application {
    private final CirclePane circlePane = new CirclePane();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        Button buttonEnlarge = new Button("Enlarge");
        Button buttonShrink = new Button("Shrink");

        hBox.getChildren().addAll(buttonEnlarge, buttonShrink);

        buttonEnlarge.setOnAction(new EnlargeHandler());
        buttonShrink.setOnAction(_ -> circlePane.shrink());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        stage.setTitle("ControlCircle");
        stage.setScene(scene);
        stage.show();
    }

    static class CirclePane extends StackPane {
        private final Circle circle = new Circle();

        public CirclePane() {
            getChildren().add(circle);
            circle.setStroke(javafx.scene.paint.Color.BLACK);
            circle.setFill(javafx.scene.paint.Color.WHITE);
        }

        public void enlarge() {
            circle.setRadius(circle.getRadius() + 2);
        }

        public void shrink() {
            circle.setRadius(circle.getRadius() > 2 ? circle.getRadius() - 2 : circle.getRadius());
        }
    }

    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(javafx.event.ActionEvent event) {
            circlePane.enlarge();
        }
    }

}