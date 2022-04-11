package Ultimate.services;
import Ultimate.exceptions.MovieNotFoundException;
import Ultimate.models.Movie;
import Ultimate.repositories.MovieRepository;
import java.io.FileNotFoundException;
import java.util.List;

public class MovieSearchService {
    
    private final MovieRepository movieRepository;

    public MovieSearchService() throws FileNotFoundException {
        movieRepository = new MovieRepository();
    }

    public Movie findMovieByName(String movieName) {
        return movieRepository.getMovieList().stream()
                .filter(m -> m.getName().equalsIgnoreCase(movieName))
                .findFirst().orElseThrow(() -> new MovieNotFoundException(
                        "movie with name = " + movieName + " not found"
                ));
    }

    public List<Movie> findMoviesByActor(String cast){
        return movieRepository.getMovieList().stream().filter(movie -> movie.getCast()
                .stream().anyMatch(cast1 -> cast1.getFullName().equalsIgnoreCase(cast))).toList();
    }

    public List<Movie> findMoviesByDirector(String directorsName) {
        return movieRepository.getMovieList().stream()
                .filter(movie -> movie.getDirector().getFullName().equalsIgnoreCase(directorsName))
                .toList();
    }

    public List<Movie> findMoviesByYear(int year){
        return movieRepository.getMovieList().stream()
                .filter(movie -> movie.getYear()==year).toList();
    }

    public List<Movie> findMoviesAndRoleByActor(String actor){
        return movieRepository.getMovieList().stream()
                .filter(movie -> movie.getCast()
                        .stream().anyMatch(cast1 -> cast1.getFullName().equalsIgnoreCase(actor))).toList();
    }

    public void showActorRoles(){
        movieRepository.getMovieList()
                .forEach(Movie::printCast);

    }

    public void commands(){
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }
}