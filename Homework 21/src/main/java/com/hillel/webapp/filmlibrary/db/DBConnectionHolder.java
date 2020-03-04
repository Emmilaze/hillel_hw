package com.hillel.webapp.filmlibrary.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnectionHolder {
    public static Connection connection;
    public static Statement statement;

    public static final String FilmId = "SELECT * FROM film_library.films WHERE title = ?";
    public static final String ActorsByFilm = "SELECT * FROM film_library.cast_team RIGHT JOIN " +
            "film_library.actors ON cast_team.actor_id = actors.id WHERE film_id = ?;";
    public static final String ActorsByFilmAmount = "SELECT * FROM film_library.actors a JOIN " +
            "(SELECT actor_id, count(film_id) amount FROM film_library.cast_team GROUP BY actor_id) af" +
            " on (a.id = af.actor_id) WHERE af.amount >= ?;";
    public static final String DeleteQuery = "DELETE FROM film_library.films WHERE date_part('year', " +
            "age(current_date, premiere)) > ?;";
    public static final String FilmsByActor = "SELECT * FROM film_library.cast_team RIGHT JOIN film_library.films ON film_id = films.id " +
            "RIGHT JOIN film_library.directors ON films.director_id = directors.id WHERE actor_id = ?;";

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