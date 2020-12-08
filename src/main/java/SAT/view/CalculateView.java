package SAT.view;

import SAT.App;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculateView extends App {

    private Stage stage;
    private GridPane gridPane;

    public CalculateView(Stage recievedStage)
    {
        stage = recievedStage;
        gridPane = createGridPane();

        gridPane.getChildren().add(getBackButton(stage));

        Scene calculateScene = new Scene(gridPane, 500, 300);

        stage.setTitle("Shape Analysis Tool - Calculate");
        stage.setScene(calculateScene);
    }
}
