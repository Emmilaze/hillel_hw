package com.hillel.webapp.service;

import com.hillel.webapp.filmlibrary.film.Film;
import com.hillel.webapp.filmlibrary.person.Actor;

import java.util.List;

public interface FilmLibraryService {
    List<Film> getNewFilms();

    List<Actor> getActorsByFilm(String name);

    List<Actor> getActorsFilmNumber(int amount);

    List<Actor> getActorsDirectors();

    void deleteOldFilms(int years);

    List<Film> setCast(List<Film> films);

    List<Actor> setFilms(List<Actor> actors);

}
