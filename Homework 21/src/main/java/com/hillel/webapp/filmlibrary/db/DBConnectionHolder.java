package com.hillel.webapp.filmlibrary.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBConnectionHolder {
    public static Connection connection;
    public static Statement statement;

    public void connect() {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/postgres");
            connection = ds.getConnection();
            statement = connection.createStatement();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}