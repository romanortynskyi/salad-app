package validations;

public class ValidationErrorException extends Exception {
    public ValidationErrorException(String message) {
        super(message);
    }

}
