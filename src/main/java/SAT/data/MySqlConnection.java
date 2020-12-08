package SAT.data;

import java.sql.*;
import java.util.ArrayList;

public class MySqlConnection {

  private Connection connection;
  private Statement statement;

  public MySqlConnection() throws SQLException {
    openConnection();
  }

  public void openConnection() throws SQLException {

    if (connection == null) {
      connection = DriverManager.getConnection("jdbc:mysql://localhost/SAT", "user", "password");
    }

    if (statement == null) {
      statement = connection.createStatement();
    }

    return;
  }

  public String getData() throws SQLException {
    String resultString = null;
    String query ="select * from test";

    openConnection();

    ResultSet result = statement.executeQuery(query);

    while (result.next()) {
      resultString = result.getString(1);
    }

    return resultString;
  }

}
