package com.hillel.webapp.filmlibrary.person;

import com.hillel.webapp.filmlibrary.film.Film;

import java.util.Date;
import java.util.List;

public class Actor extends Person{
    private List<Film> films;

    public Actor(int id, String name, Date birth) {
        super(id, name, birth);
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
