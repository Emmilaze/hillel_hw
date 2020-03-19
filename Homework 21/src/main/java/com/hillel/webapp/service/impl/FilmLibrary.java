package com.hillel.webapp.service.impl;

import com.hillel.webapp.filmlibrary.db.DataBaseQueries;
import com.hillel.webapp.filmlibrary.film.Film;
import com.hillel.webapp.filmlibrary.person.Actor;
import com.hillel.webapp.service.FilmLibraryService;

import java.util.List;

public class FilmLibrary implements FilmLibraryService {
    private static FilmLibrary filmLibrary;
    private DataBaseQueries requests;

    public static FilmLibrary getInstance() {
        if (filmLibrary == null) {
            filmLibrary = new FilmLibrary();
        }
        return filmLibrary;
    }

    private FilmLibrary() {
        requests = DataBaseQueries.getInstance();
    }

    @Override
    public List<Film> getNewFilms() {
        List<Film> films = requests.getFilmsByYear();
        if (!films.isEmpty()) {
            films = setCast(films);
            return films;
        } else {
            return null;
        }
    }

    @Override
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

    @Override
    public List<Actor> getActorsFilmNumber(int amount) {
        List<Actor> actors = requests.getActorsByFilms(amount);
        if (!actors.isEmpty()) {
            actors = setFilms(actors);
            return actors;
        } else {
            return null;
        }
    }

    @Override
    public List<Actor> getActorsDirectors() {
        List<Actor> actors = requests.getActorsDirectors();
        if (!actors.isEmpty()) {
            actors = setFilms(actors);
            return actors;
        } else return null;
    }

    @Override
    public void deleteOldFilms(int years) {
        requests.deleteOldFilms(years);
    }

    @Override
    public List<Film> setCast(List<Film> films) {
        for (Film film : films) {
            film.setActors(requests.getActorsByFilm(film.getId()));
        }
        return films;
    }

    public List<Actor> setFilms(List<Actor> actors) {
        for (Actor actor : actors) {
            actor.setFilms(requests.getFilmsByActor(actor.getId()));
        }
        return actors;
    }
}