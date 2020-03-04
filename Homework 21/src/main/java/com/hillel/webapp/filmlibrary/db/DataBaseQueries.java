package com.hillel.webapp.filmlibrary.db;

import com.hillel.webapp.filmlibrary.film.Film;
import com.hillel.webapp.filmlibrary.people.Actor;
import com.hillel.webapp.filmlibrary.people.Director;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.hillel.webapp.filmlibrary.db.DBConnectionHolder.*;

public class DataBaseQueries {

    public List<Actor> getActorsByFilm(int id) {
        List<Actor> actors = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ActorsByFilm)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    actors.add(new Actor(rs.getInt("id"), rs.getString("name"),
                            rs.getDate("birth")));
                }
                return actors;
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                return actors;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(FilmId)) {
            preparedStatement.setString(1, name);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("id");
                }
                return id;
            } catch (SQLException e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<Actor> getActorsByFilms(int amount) {
        List<Actor> actors = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ActorsByFilmAmount)) {
            preparedStatement.setInt(1, amount);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    actors.add(new Actor(rs.getInt("id"), rs.getString("name"),
                            rs.getDate("birth")));
                }
                return actors;
            } catch (SQLException e) {
                e.printStackTrace();
                return actors;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actors;
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(DeleteQuery)) {
            preparedStatement.setInt(1, years);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Film> getFilmsByActor(int id) {
        String sql = "SELECT * FROM film_library.cast_team RIGHT JOIN film_library.films ON film_id = films.id " +
                "RIGHT JOIN film_library.directors ON films.director_id = directors.id WHERE actor_id = " + id + ";";
        List<Film> films = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(FilmsByActor)) {
            preparedStatement.setInt(1, id);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }
}