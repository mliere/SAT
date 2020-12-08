package SAT;

import SAT.data.MySqlConnection;
import SAT.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public MySqlConnection connection;

    public void start(final Stage primaryStage) throws Exception {
        connection = new MySqlConnection();
        MainView mainView = new MainView(primaryStage);
    }

    public static void main(String[] args) {

    }
}
