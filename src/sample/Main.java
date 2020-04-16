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
    BorderPane layout;
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

        /*
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
        */

        /*
        //File menu
        Menu fileMenu = new Menu("File");

        //Menu items
        MenuItem newList = new MenuItem("New list");
        newList.setOnAction(e -> System.out.println("New list"));


        fileMenu.getItems().add(newList);
        fileMenu.getItems().add(new MenuItem("Save list..."));
        fileMenu.getItems().add(new MenuItem("Load list..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new MenuItem("Exit"));

        //Edit menu
        Menu editMenu = new Menu ("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting."));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        //Help menu
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if(showLines.isSelected()) {
                System.out.println("Program will show line numbers");
            } else {
                System.out.println("Hiding line numbers");
            }
        });

        CheckMenuItem autoSave = new CheckMenuItem("Enable auto-save");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(showLines, autoSave);

        //Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

        */

        /* Label and inputs
        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Użytkownik:");
        nameLabel.setId("bold-label");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("Pacal");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password Label
        Label passLabel = new Label("Hasło:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("hasło");
        GridPane.setConstraints(passInput, 1, 1);

        //Login
        Button loginButton = new Button("Zaloguj");
        GridPane.setConstraints(loginButton, 1, 2);

        //Login
        Button signUpButton = new Button("Zapisz się");
        signUpButton.getStyleClass().add("button-blue");
        GridPane.setConstraints(signUpButton, 1, 3);

        //Add everything to grid
        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);


         */

        Person pacal = new Person();

        pacal.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + pacal.firstNameProperty());
            System.out.println("getFirstName(): " + pacal.getFirstName());
        });

        button = new Button("Potwierdź");
        button.setOnAction(e -> pacal.setFirstName("Porky"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 200);
        scene.getStylesheets().add("Theme.css");
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
