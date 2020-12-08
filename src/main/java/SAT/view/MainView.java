package SAT.view;

import SAT.App;
import SAT.data.MySqlConnection;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainView extends App {

    private Stage stage;
    private GridPane gridPane;

    public MainView(Stage primaryStage) {
        stage = primaryStage;
        gridPane = createGridPane();

        gridPane.getChildren().add(getCalculateButton());
        gridPane.getChildren().add(getLoadButton());

        Scene mainScene = new Scene(gridPane, 500, 300);

        stage.setTitle("Shape Analysis Tool");
        stage.setScene(mainScene);
        stage.show();
    }

    private Button getCalculateButton() {
        Button calculateButton = new Button("calculate");

        //Creating the mouse event handler
        EventHandler<MouseEvent> onCalculateClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CalculateView calculateView = new CalculateView(stage);
            }
        };

        //Registering the event filter
        calculateButton.addEventFilter(MouseEvent.MOUSE_CLICKED, onCalculateClick);

        GridPane.setRowIndex(calculateButton, 0);
        GridPane.setColumnIndex(calculateButton, 0);

        return calculateButton;
    }

    private Button getLoadButton() {
        Button loadButton = new Button("load");

        //Creating the mouse event handler
        EventHandler<MouseEvent> onCalculateClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                LoadView loadView = new LoadView(stage);
            }
        };

        //Registering the event filter
        loadButton.addEventFilter(MouseEvent.MOUSE_CLICKED, onCalculateClick);

        GridPane.setRowIndex(loadButton, 0);
        GridPane.setColumnIndex(loadButton, 1);

        return loadButton;
    }
}
