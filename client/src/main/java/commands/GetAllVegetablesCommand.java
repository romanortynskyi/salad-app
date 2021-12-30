package commands;

import data.models.Vegetable;
import services.VegetableService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class GetAllVegetablesCommand implements ICommand {

    private Logger logger = AppLogger.getInstance();
    private VegetableService vegetableService = VegetableService.getInstance();

    @Override
    public void execute() throws IOException, ClassNotFoundException, InterruptedException {
        List<Vegetable> vegetables = vegetableService.getAll();
        vegetables.forEach(v -> ConsoleUtils.writeLine(v));
        String msg = String.format("Get all vegetables: %s", vegetables);
        logger.info(msg);
    }
}
