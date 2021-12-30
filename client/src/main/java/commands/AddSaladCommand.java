package commands;

import data.models.Salad;
import dto.SaveSaladDto;
import exceptions.NotFoundException;
//import services.Services;
import services.SaladService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class AddSaladCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private SaveSaladDto salad;

    public AddSaladCommand(SaveSaladDto salad) { this.salad = salad; }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Salad createdSalad = saladService.add(salad);
        ConsoleUtils.writeLine(createdSalad);
        String msg = String.format("Add salad %s", createdSalad);
        logger.info(msg);
    }
}
