package commands;

import data.models.Salad;
import dto.UpdateSaladDto;
import exceptions.NotFoundException;
import services.SaladService;
import utils.AppLogger;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.logging.Logger;

public class RenameSaladCommand implements ICommand {
    private Logger logger = AppLogger.getInstance();
    private SaladService saladService = SaladService.getInstance();
    private Long id;
    private UpdateSaladDto updateSaladDto;

    public RenameSaladCommand(Long id, UpdateSaladDto updateSaladDto) {
        this.id = id;
        this.updateSaladDto = updateSaladDto;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Salad updatedSalad = saladService.update(id, updateSaladDto);
        ConsoleUtils.writeLine(updatedSalad);
        String msg = String.format("Rename salad: %s", updatedSalad);
        logger.info(msg);
    }
}
