package validations;

public class NameValidation implements IValidation {
    @Override
    public void run(String input) throws ValidationErrorException {
        // should be at least 2 chars long
        if(input.matches("[a-zA-Zа-яіїєА-ЯІЇЄ]{2,}")) return;
        throw new ValidationErrorException("Назва має містити тільки букви та щонайменше 2 символи");
    }
}
