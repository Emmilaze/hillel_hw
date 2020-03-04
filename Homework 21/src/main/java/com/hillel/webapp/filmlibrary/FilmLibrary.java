package com.hillel.webapp.filmlibrary;

import com.hillel.webapp.filmlibrary.db.DBConnectionHolder;
import com.hillel.webapp.filmlibrary.db.DataBaseQueries;
import com.hillel.webapp.filmlibrary.film.Film;
import com.hillel.webapp.filmlibrary.people.Actor;

import java.util.List;

public class FilmLibrary {
    private static FilmLibrary instance;
    private DBConnectionHolder connectionHolder;
    private DataBaseQueries requests;

    public static FilmLibrary getInstance() {
        if (instance == null) {
            instance = new FilmLibrary();
        }
        return instance;
    }

    private FilmLibrary() {
        connectionHolder = new DBConnectionHolder();
        connectionHolder.connect();
        requests = new DataBaseQueries();
    }

    public List<Film> getNewFilms() {
        List<Film> films = requests.getFilmsByYear();
        if (!films.isEmpty()) {
            films = setCast(films);
            return films;
        } else {
            return null;
        }
    }

    public List<Actor> getActorsByFilm(String name) {
        int id = requests.getFilmId(name);
        List<Actor> actors = requests.getActorsByFilm(id);
        if (!actors.isEmpty()) {
            actors = setFilms(actors);
            return actors;
        } else {
            return null;
        }
    }

    public List<Actor> getActorsFilmNumber(int amount) {
        List<Actor> actors = requests.getActorsByFilms(amount);
        if (!actors.isEmpty()) {
            actors = setFilms(actors);
            return actors;
        } else {
            return null;
        }
    }

    public List<Actor> getActorsDirectors() {
        List<Actor> actors = requests.getActorsDirectors();
        if (!actors.isEmpty()) {
            actors = setFilms(actors);
            return actors;
        }
        else return null;
    }

    public void deleteOldFilms(int years) {
        requests.deleteOldFilms(years);
    }

    private List<Film> setCast(List<Film> films) {
        for (Film film : films) {
            film.setActors(requests.getActorsByFilm(film.getId()));
        }
        return films;
    }

    private List<Actor> setFilms(List<Actor> actors) {
        for (Actor actor : actors) {
            actor.setFilms(requests.getFilmsByActor(actor.getId()));
        }
        return actors;
    }
}