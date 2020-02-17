package people;

import film.Film;

import java.util.Date;
import java.util.List;

public class Director extends Person{
    private List<Film> films;

    public Director(int id, String name, Date birth) {
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
