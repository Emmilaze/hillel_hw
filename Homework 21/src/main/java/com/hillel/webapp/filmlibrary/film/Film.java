package com.hillel.webapp.filmlibrary.film;

import com.hillel.webapp.filmlibrary.people.Actor;
import com.hillel.webapp.filmlibrary.people.Director;

import java.util.Date;
import java.util.List;

public class Film {
    private int id;
    private String name;
    private Director director;
    private String country;
    private Date premiere;

    private List<Actor> actors;

    public Film(int id, String name, Director director, String country, Date premiere) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.country = country;
        this.premiere = premiere;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public Director getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public Date getPremiere() {
        return premiere;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Actor actor: actors) {
            builder.append(actor.toString());
        }
        return "Film " +
                "№" + id + ", title: \'" + name + "\', country: " + country +
                ", premiere: " + premiere + ". \nActors: " + builder + "\nDirector: " + director;
    }
}