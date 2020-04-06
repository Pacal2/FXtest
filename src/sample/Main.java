package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application  {
    Stage window;
    Scene scene;
    Button button;
    ChoiceBox<String> choiceBox;
    ComboBox<String> comboBox;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Java FX");
        button = new Button("Kliknij mnie");

        /* Używanie choiceBox
        //ChoiceBox
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "End of Evangelion",
                "Angel's Egg",
                "Feherlofia"
        );
        comboBox.setPromptText("Wybierz film");
        comboBox.setEditable(true);

        button.setOnAction(e -> printInput());
        comboBox.setOnAction(e -> System.out.println("Użytkownik wybrał: " + comboBox.getValue()));
        */

        listView = new ListView<>();
        listView.getItems().addAll("Gravity's Rainbow", "Book of the New Sun", "Invisible Cities");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e -> buttonClicked());

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);

        scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();

    }

    private void buttonClicked() {
        String message = "";
        ObservableList<String> choices;
        choices = listView.getSelectionModel().getSelectedItems();

        for(String c: choices) {
            message += c + "\n";
        }
        System.out.println(message);
    }

    private void printInput() {
        System.out.println(comboBox.getValue());
    }


    private void getChoice(ChoiceBox<String> choiceBox) {
        String choice = choiceBox.getValue();
        System.out.println(choice);
    }

    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message = "Zamówienie:\n";

        if(box1.isSelected()) {
            message += "bekon\n";
        } if (box2.isSelected()) {
            message += "tuńczyk\n";
        }

        System.out.println(message);

    }

    private boolean isInt(TextField input, String message) {
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        }catch (NumberFormatException e) {
            System.out.println("Error:  " + message + " is not a number.");
            return false;
        }
    }


    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Tytuł", "Tak, czy na pewno chcesz wyjść?");
        if(answer) {
            window.close();
        }

    }


}
