package validations;

import utils.ValidationUtils;

public class CaloriesValidation implements IValidation {
    @Override
    public void run(String input) throws ValidationErrorException {
        if(ValidationUtils.isDouble(input)) return;
        throw new ValidationErrorException("Калорії мають бути типу double");
    }
}
