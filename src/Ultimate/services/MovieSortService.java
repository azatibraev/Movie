package Ultimate.services;

import Ultimate.models.Director;
import Ultimate.models.Movie;
import Ultimate.repositories.MovieRepository;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MovieSortService {

    private final MovieRepository movieRepository;

    public MovieSortService() throws FileNotFoundException {
        this.movieRepository = new MovieRepository();
    }

    public void printAllMovies(List<Movie> movie) {
        movie.stream().toList().forEach(System.out::println);
    }

    public List<Movie> sortMoviesByName() {
            return movieRepository.getMovieList().stream()
                    .sorted(Comparator.comparing(Movie::getName))
                    .toList();
    }

    public List<Movie> sortByYear() {
            return movieRepository.getMovieList().stream()
                    .sorted(Comparator.comparing(Movie::getYear))
                    .toList();
    }

    public void sortByDirector() {
        Map<Director, List<Movie>> directorListMap = movieRepository.getMovieList().stream()
                .collect(Collectors.groupingBy(Movie::getDirector));
        directorListMap.forEach(((director, movies) ->{
            System.out.println(director);
            movies.forEach(System.out::println);
            System.out.println();
        }));
    }
}