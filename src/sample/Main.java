package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application  {
    Stage window;
    Scene scene;
    Button button;
    TreeView<String> tree;
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

        /* List View
        listView = new ListView<>();
        listView.getItems().addAll("Gravity's Rainbow", "Book of the New Sun", "Invisible Cities");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        button.setOnAction(e -> buttonClicked());
        */

        /* Tree Item
        *

        TreeItem<String> root, comics, games;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Comics
        comics = makeBranch("Komiksy", root);
        makeBranch("The Maxx", comics);
        makeBranch("Dorohedoro", comics);
        makeBranch("Nausicaa of the Valley of the Wind", comics);

        //Games
        games = makeBranch("Gry", root);
        makeBranch("Planescape: Torment", games);
        makeBranch("The Elder Scrolls III: Morrowind", games);
        makeBranch("Bloodborne", games);

        //Tworzenie drzewa
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if(newValue != null) {
                        System.out.println(newValue.getValue());
                    }
        });
         */


        //Observable List
        TableView<Comics> table;
        TextField nameInput, releaseYearInput, issuesInput;

        //Name column
        TableColumn<Comics, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //ReleseYear column
        TableColumn<Comics, Integer> releaseYearColumn = new TableColumn<>("Release Year");
        releaseYearColumn.setMinWidth(100);
        releaseYearColumn.setCellValueFactory(new PropertyValueFactory<>("releaseYear"));
        //Issues column
        TableColumn<Comics, Integer> issuesColumn = new TableColumn<>("Issues");
        issuesColumn.setMinWidth(100);
        issuesColumn.setCellValueFactory(new PropertyValueFactory<>("issues"));

        //Name Input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);
        //ReleaseYearInput
        releaseYearInput = new TextField();
        releaseYearInput.setPromptText("Release year");
        //Name Input
        issuesInput = new TextField();
        issuesInput.setPromptText("Issues");

        table = new TableView<>();
        table.setItems(getComics());
        table.getColumns().addAll(nameColumn, releaseYearColumn, issuesColumn);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked(nameInput, releaseYearInput, issuesInput, table));
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked(table));

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 0, 0, 0));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, releaseYearInput, issuesInput, addButton, deleteButton);


        //Layout
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();

    }

    private void addButtonClicked(TextField nameInput, TextField releaseYearInput, TextField issuesInput, TableView<Comics> table) {
        Comics comics = new Comics();
        comics.setName(nameInput.getText());
        comics.setReleaseYear(Integer.parseInt(releaseYearInput.getText()));
        comics.setIssues(Integer.parseInt(issuesInput.getText()));
        table.getItems().add(comics);
        nameInput.clear();
        releaseYearInput.clear();
        issuesInput.clear();

    }

    private void deleteButtonClicked(TableView<Comics> table) {
        ObservableList<Comics> comicsSelected, allComics;
        allComics = table.getItems();
        comicsSelected = table.getSelectionModel().getSelectedItems();

        comicsSelected.forEach(allComics::remove);
    }



    private ObservableList<Comics> getComics() {
        ObservableList<Comics> comics = FXCollections.observableArrayList();
        comics.add(new Comics("The Maxx", 1993, 35));
        comics.add(new Comics("Incal", 1980, 6));
        comics.add(new Comics("Dorohedoro", 2000, 23));
        return comics;
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
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
