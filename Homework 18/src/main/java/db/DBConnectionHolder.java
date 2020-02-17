package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnectionHolder {
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    private static final String request = "SELECT * FROM film_library.films WHERE title = ?";

    public void connect() {
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream("./src/main/resources/config.properties")) {
            property.load(fis);
            connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.login"),
                    property.getProperty("db.password"));
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement(request);
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if(!statement.isClosed()){
                statement.close();
            }
            if(!preparedStatement.isClosed()){
                preparedStatement.close();
            }
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
