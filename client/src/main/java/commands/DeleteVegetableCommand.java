package commands;

import exceptions.NotFoundException;
import services.VegetableService;
import utils.AppLogger;

import java.io.IOException;
import java.util.logging.Logger;

public class DeleteVegetableCommand implements ICommand {
    private VegetableService vegetableService = VegetableService.getInstance();
    private Logger logger = AppLogger.getInstance();
    private Long id;

    public DeleteVegetableCommand(Long id) {
        this.id = id;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        vegetableService.delete(id);
        String msg = String.format("Delete vegetable %s", id);
        logger.info(msg);
    }
}
