package Ultimate.repositories;

import Ultimate.models.Movie;
import Ultimate.models.Movies;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class MovieRepository {

    private final List<Movie> movieList;

    public MovieRepository() throws FileNotFoundException {
        Gson gson = new Gson();

        JsonReader jsonReader = new JsonReader(
                new FileReader("resources/movies.json"));
        Movies movies = gson.fromJson(jsonReader,Movies.class);

        movieList = movies.getMovies();

    }

    public List<Movie> getMovieList(){
        return movieList;
    }
}
