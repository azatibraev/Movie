package Ultimate.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException() {
    }

    public MovieNotFoundException(String message) {
        super(message);
    }
}
