package commands;

import exceptions.NotFoundException;
import validations.ValidationErrorException;

import java.io.IOException;

interface ICommand {
    void execute() throws IOException, ClassNotFoundException, NotFoundException, ValidationErrorException, InterruptedException;
}
