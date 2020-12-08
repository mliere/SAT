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

    private GridPane gridPane;

    public MainView(Stage primaryStage) {
        gridPane = new GridPane();

        createGridPane();
        addCalculateButton();

        Scene mainScene = new Scene(gridPane, 900, 500);

        primaryStage.setTitle("Shape Analysis Tool");
        primaryStage.setScene(mainScene);
        System.out.println("HALLOOO");
        primaryStage.show();
    }

    private void createGridPane()
    {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
    }

    private void addCalculateButton() {
        Button calculateButton = new Button("calculate");

//        //Creating the mouse event handler
//        EventHandler<MouseEvent> onCalculateClick = new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent e) {
//                GridPane grid = new GridPane();
//                mainStage.getScene().setRoot(grid);
//            }
//        };
//
//        //Registering the event filter
//        calculateButton.addEventFilter(MouseEvent.MOUSE_CLICKED, onCalculateClick);

        GridPane.setRowIndex(calculateButton, 0);
        GridPane.setColumnIndex(calculateButton, 0);

        gridPane.getChildren().addAll(calculateButton);
    }
}
