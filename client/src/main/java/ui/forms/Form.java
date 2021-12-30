package ui.forms;

import utils.ConsoleUtils;
import validations.*;

import java.io.IOException;

public abstract class Form<T> {
    public abstract T show() throws IOException, ClassNotFoundException, ValidationErrorException;
    public String read(String message, IValidation validation) throws IOException, ValidationErrorException {
        String input = "";

        while(true) {
            ConsoleUtils.write(message);
            input = ConsoleUtils.readLine();

            if(input.equals("q")) return null;

            try {
                validation.run(input);
                break;
            }
            catch (ValidationErrorException e) {
                ConsoleUtils.writeLine(e.getMessage());
                continue;
            }

        }

        return input;
    }
}
