package validations;

public interface IValidation {
    void run(String input) throws ValidationErrorException;
}
