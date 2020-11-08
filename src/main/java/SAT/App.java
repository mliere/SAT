package SAT;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
 
public class App extends Application {

    //create connection for a server installed in localhost, with a user "root" with no password
    public String connect() throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", "user", "password")) {
            // create a Statement
            try (Statement stmt = conn.createStatement()) {
                //execute query
                try (ResultSet rs = stmt.executeQuery("SELECT * from SAT.test")) {
                    //position result to first
                    rs.next();
                    return (rs.getString(1)); //result is "Hello World!"
                }
            }
        }
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception{
 
        // Buat Object Button
        Button btn1 = new Button(connect());
 
        // Atur posisi Button berdasarkan baris dan kolom
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
