package commands;

import data.models.Vegetable;
//import services.Services;
import exceptions.NotFoundException;
import services.VegetableService;
import utils.AppLogger;
import utils.ConsoleUtils;
import validations.ValidationErrorException;

import java.io.IOException;
import java.util.logging.Logger;

public class AddVegetableCommand implements ICommand {
    private Vegetable vegetable;
    private Logger logger = AppLogger.getInstance();
    private VegetableService vegetableService = VegetableService.getInstance();

    public AddVegetableCommand(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, ValidationErrorException, NotFoundException, InterruptedException {
        Vegetable createdVegetable = vegetableService.add(vegetable);
        ConsoleUtils.writeLine(createdVegetable.toString());
        String msg = String.format("Add vegetable: %s", createdVegetable);
        logger.info(msg);
    }
}
