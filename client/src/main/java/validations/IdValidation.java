package validations;

import utils.ValidationUtils;

public class IdValidation implements IValidation {
    @Override
    public void run(String input) throws ValidationErrorException {
        String regex = "^\\+?(0|[1-9]\\d*)$";
        if(input.matches(regex)) return;
        throw new ValidationErrorException("Id має бути цілим додатним числом");
    }
}
