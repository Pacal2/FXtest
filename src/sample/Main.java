package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Button myButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Title of the Window");

        myButton = new Button();
        myButton.setText("Click me");

        StackPane layout = new StackPane();
        layout.getChildren().add(myButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
