package Ultimate;
import Ultimate.exceptions.MovieNotFoundException;
import Ultimate.models.Movie;
import Ultimate.repositories.MovieRepository;
import Ultimate.services.MovieSearchService;
import Ultimate.services.MovieSortService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        MovieSearchService movieSearchService = new MovieSearchService();
        MovieSortService movieSortService = new MovieSortService();

        MovieRepository movieRepository = new MovieRepository();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            movieSearchService.commands();

            System.out.print("Choose your commands: ");

            int sort = scanner.nextInt();
            List<Movie> movieList = movieRepository.getMovieList();

            switch (sort) {
                case 1:
                    movieSortService.printAllMovies(movieList);
                    break;

                case 2:
                    try {
                        System.out.print("What kind of movie do you want to watch: ");
                        String movieName = sc.nextLine();
                        movieSearchService.findMovieByName(movieName);
                    } catch (MovieNotFoundException movieNotFoundException) {
                        System.out.println("\u001B[36m " + movieNotFoundException.getMessage());
                    }
                    break;

                case 3:
                    movieSortService.sortByYear().forEach(System.out::println);
                    break;

                case 4:
                    movieSortService.sortMoviesByName().forEach(System.out::println);
                    break;

                case 5:
                    movieSortService.sortByDirector();
                    break;

                case 6:
                    System.out.print("Input actor: ");
                    String actor = sc.nextLine();
                    movieSearchService.findMoviesByActor(actor).forEach(System.out::println);
                    break;

                case 7:
                    System.out.print("Input director: ");
                    String director = sc.nextLine();
                    movieSearchService.findMoviesByDirector(director).forEach(System.out::println);
                    break;

                case 8:
                    System.out.print("Input your date: ");
                    int year = sc.nextInt();
                    movieSearchService.findMoviesByYear(year).forEach(System.out::println);
                    break;

                case 9:
                    System.out.print("Input your actor: ");
                    String actor1 = sc.nextLine();
                    movieSearchService.findMoviesAndRoleByActor(actor1).forEach(System.out::println);
                    break;

                case 10:
                    movieSearchService.showActorRoles();
                    break;
            }
        }
    }
}