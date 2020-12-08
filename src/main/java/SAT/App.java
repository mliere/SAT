package SAT;

import SAT.data.MySqlConnection;
import SAT.view.CalculateView;
import SAT.view.MainView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    public MySqlConnection connection;
    private Stage satStage;

    public void start(final Stage primaryStage) throws Exception {
        satStage = primaryStage;
        connection = new MySqlConnection();
        MainView mainView = new MainView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public GridPane createGridPane()
    {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        return gridPane;
    }

    public Button getBackButton(Stage recievedStage) {
        Button backButton = new Button("back");

        //Creating the mouse event handler
        EventHandler<MouseEvent> onBackClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                MainView mainView = new MainView(recievedStage);
            }
        };

        //Registering the event filter
        backButton.addEventFilter(MouseEvent.MOUSE_CLICKED, onBackClick);

        GridPane.setRowIndex(backButton, 0);
        GridPane.setColumnIndex(backButton, 0);

        return backButton;
    }
}
