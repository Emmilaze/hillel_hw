public class Main {
    public static void main(String[] args) {
        FilmLibrary filmLibrary = new FilmLibrary();
        filmLibrary.loadLibrary();

        filmLibrary.getNewFilms();
        filmLibrary.getActorsByFilm("Once Upon a Time in Hollywood");
        filmLibrary.getActorsFilmNumber(2);
        filmLibrary.getActorsDirectors();
        filmLibrary.deleteOldFilms(10);

        filmLibrary.closeLibrary();
    }
}
