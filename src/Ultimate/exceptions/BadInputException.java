package Ultimate.exceptions;

public class BadInputException extends RuntimeException {
    public BadInputException(String you_give_wrong_input_type) {
        super(you_give_wrong_input_type);
    }
}
