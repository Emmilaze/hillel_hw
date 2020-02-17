package db;

import film.Film;
import people.Actor;
import people.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static db.DBConnectionHolder.preparedStatement;
import static db.DBConnectionHolder.statement;

public class DataBaseRequests {

    public List<Actor> getActorsByFilm(int id) {
        List<Actor> actors = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery("SELECT * FROM film_library.cast_team RIGHT JOIN " +
                "film_library.actors ON cast_team.actor_id = actors.id WHERE film_id = " + id + ";")) {
            while (rs.next()) {
                actors.add(new Actor(rs.getInt("id"), rs.getString("name"),
                        rs.getDate("birth")));
            }
            return actors;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return actors;
        }
    }

    public List<Film> getFilmsByYear() {
        String sql = "SELECT * FROM film_library.films RIGHT JOIN film_library.directors " +
                "ON director_id = directors.id WHERE premiere >= (current_date - interval '1 year');";
        List<Film> films = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                films.add(new Film(rs.getInt("id"), rs.getString("title"),
                        new Director(rs.getInt("director_id"), rs.getString("name"),
                                rs.getDate("birth")), rs.getString("country"),
                        rs.getDate("premiere")));
            }
            return films;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return films;
        }
    }

    public int getFilmId(String name) {
        int id = 0;
        try {
            preparedStatement.setString(1, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                id = rs.getInt("id");
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return id;
        }
    }

    public List<Actor> getActorsByFilms(int amount) {
        List<Actor> actors = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery("SELECT * FROM film_library.actors a JOIN " +
                "(SELECT actor_id, count(film_id) amount FROM film_library.cast_team GROUP BY actor_id) af" +
                " on (a.id = af.actor_id) WHERE af.amount >= " + amount + ";")) {
            while (rs.next()) {
                actors.add(new Actor(rs.getInt("id"), rs.getString("name"),
                        rs.getDate("birth")));
            }
            return actors;
        } catch (SQLException e) {
            e.printStackTrace();
            return actors;
        }
    }

    public List<Actor> getActorsDirectors() {
        String sql = "SELECT * FROM film_library.actors INTERSECT SELECT * FROM film_library.directors;";
        List<Actor> actors = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                actors.add(new Actor(rs.getInt("id"), rs.getString("name"),
                        rs.getDate("birth")));
            }
            return actors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteOldFilms(int years) {
        String sql = "DELETE FROM film_library.films WHERE date_part('year', age(current_date, premiere)) > "
                + years + ";";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Film> getFilmsByActor(int id) {
        String sql = "SELECT * FROM film_library.cast_team RIGHT JOIN film_library.films ON film_id = films.id " +
                "RIGHT JOIN film_library.directors ON films.director_id = directors.id WHERE actor_id = " + id + ";";
        List<Film> films = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                films.add(new Film(rs.getInt("film_id"), rs.getString("title"),
                        new Director(rs.getInt("director_id"), rs.getString("name"),
                                rs.getDate("birth")), rs.getString("country"),
                        rs.getDate("premiere")));
            }
            return films;
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return films;
        }
    }
}
