import db.DBConnectionHolder;
import db.DataBaseRequests;
import film.Film;
import people.Actor;

import java.util.List;

public class FilmLibrary {

    private DBConnectionHolder connectionHolder;
    private DataBaseRequests requests;

    public void loadLibrary() {
        connectionHolder = new DBConnectionHolder();
        connectionHolder.connect();
        requests = new DataBaseRequests();
    }

    public void getNewFilms() {
        List<Film> films = requests.getFilmsByYear();
        if (!isEmptyLibrary(films)) {
            System.out.println("Films of the present and last year:");
            films = (List<Film>) addCast(films);
            System.out.println(films);
        }
    }

    public void getActorsByFilm(String name) {
        int id = requests.getFilmId(name);
        List<Actor> actors = requests.getActorsByFilm(id);
        if (!isEmptyLibrary(actors)) {
            System.out.println("\nInformation about the actors who starred in the movie " + name + ":");
            actors = (List<Actor>) addCast(actors);
            System.out.println(actors);
        }
    }

    public void getActorsFilmNumber(int amount) {
        List<Actor> actors = (List<Actor>) addCast(requests.getActorsByFilms(amount));
        if(!isEmptyLibrary(actors)){
            System.out.println("\nActors starring in at least 2 films:");
            actors = (List<Actor>) addCast(actors);
            System.out.println(actors);
        }
    }

    public void getActorsDirectors() {
        List<Actor> actors = (List<Actor>) addCast(requests.getActorsDirectors());
        if(!isEmptyLibrary(actors)){
            System.out.println("\nActors who were directing films:");
            actors = (List<Actor>) addCast(actors);
            System.out.println(actors);
        }
    }

    public void deleteOldFilms(int years) {
        requests.deleteOldFilms(years);
    }

    private List<?> addCast(List<?> list) {
        for (Object o : list) {
            if (o instanceof Film) {
                Film film = (Film) o;
                film.setActors(requests.getActorsByFilm(film.getId()));
            }
            if (o instanceof Actor) {
                Actor actor = (Actor) o;
                actor.setFilms(requests.getFilmsByActor(actor.getId()));
            }
        }
        return list;
    }

    private boolean isEmptyLibrary(List<?> list) {
        if (list.isEmpty()) {
            System.out.println("No matches...");
            return true;
        } else {
            return false;
        }
    }

    public void closeLibrary() {
        connectionHolder.close();
    }
}
