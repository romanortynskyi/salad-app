package commands;

import data.models.Vegetable;
import exceptions.NotFoundException;
import exceptions.VegetableNotFoundException;
import services.VegetableService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class UpdateVegetableCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private VegetableService vegetableService = VegetableService.getInstance();
    private Long id;
    private Vegetable vegetable;

    public UpdateVegetableCommand(Long id, Vegetable vegetable) {
        this.id = id;
        this.vegetable = vegetable;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Vegetable updatedVegetable = vegetableService.update(id, vegetable);
        ConsoleUtils.writeLine(updatedVegetable);
        String msg = String.format("Update vegetable %s:", updatedVegetable);
        logger.info(msg);
    }
}
