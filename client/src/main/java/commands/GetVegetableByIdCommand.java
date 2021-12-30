package commands;

import data.models.Vegetable;
import exceptions.NotFoundException;
import services.VegetableService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class GetVegetableByIdCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private Long id;
    private VegetableService vegetableService = VegetableService.getInstance();

    public GetVegetableByIdCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Vegetable vegetable = vegetableService.getById(id);
        ConsoleUtils.writeLine(vegetable);
        String msg = String.format("Get vegetable by id %s: %s", id, vegetable);
        logger.info(msg);
    }
}
