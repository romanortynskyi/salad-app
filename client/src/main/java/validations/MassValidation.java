package validations;

import utils.ValidationUtils;

public class MassValidation implements IValidation {
    @Override
    public void run(String input) throws ValidationErrorException {
        if(ValidationUtils.isDouble(input)) return;
        throw new ValidationErrorException("Маса має бути типу double");
    }
}
