package com.hillel.webapp.filmlibrary.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnectionHolder {
    public static Connection connection;
    public static Statement statement;

    public void connect() {
        Properties property = new Properties();
        try (InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream("config.properties")) {
            property.load(inputStream);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(property.getProperty("db.host"), property.getProperty("db.login"),
                    property.getProperty("db.password"));
            statement = connection.createStatement();
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}