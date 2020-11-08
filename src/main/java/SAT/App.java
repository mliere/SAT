package SAT;

import SAT.database.MySqlConnection;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        MySqlConnection connection = new MySqlConnection();

        Button btn1 = new Button(connection.getData());

        GridPane.setRowIndex(btn1, 0);
        GridPane.setColumnIndex(btn1, 0);
 
        Button btn2 = new Button("Button Two");
        GridPane.setRowIndex(btn2, 0);
        GridPane.setColumnIndex(btn2, 1);
 
        Button btn3 = new Button("Button Three");
        GridPane.setRowIndex(btn3, 0);
        GridPane.setColumnIndex(btn3, 2);
 
        Button btn4 = new Button("Button Four");
        GridPane.setRowIndex(btn4, 1);
        GridPane.setColumnIndex(btn4, 0);
 
        Button btn5 = new Button("Button Five");
        GridPane.setRowIndex(btn5, 1);
        GridPane.setColumnIndex(btn5, 1);
 
        // Buat Object GridPane
        GridPane gridpane = new GridPane();
 
        // Atur posisi dan celah antar kolom GridPane
        gridpane.setAlignment(Pos.CENTER);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
 
        gridpane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
 
        Scene scene = new Scene(gridpane, 900, 500);
 
        primaryStage.setTitle("Shape Analysis Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}
