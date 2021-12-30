import commands.*;
import data.models.Vegetable;
import dto.AddSaladIngredientDto;
import dto.SaveSaladDto;
import dto.UpdateSaladDto;
import exceptions.NotFoundException;
import ui.forms.*;
import utils.AppLogger;
import utils.ConsoleUtils;
import utils.EmailUtils;
import validations.ValidationErrorException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static Logger logger;
    private static CommandExecutor commandExecutor;
    
    private static void onAddVegetable() throws ValidationErrorException, IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Vegetable vegetable = new AddVegetableForm().show();
        if(vegetable != null) {
            commandExecutor.add(new AddVegetableCommand(vegetable));
            commandExecutor.execute();
        }
    }

    private static void onGetAllVegetables() throws IOException, ClassNotFoundException, ValidationErrorException, NotFoundException, InterruptedException {
        commandExecutor.add(new GetAllVegetablesCommand());
        commandExecutor.execute();
    }

    private static void onGetVegetableById() throws ValidationErrorException, IOException, NotFoundException, ClassNotFoundException, InterruptedException {
        Long id = new GetVegetableByIdForm().show();
        if(id != null) {
            commandExecutor.add(new GetVegetableByIdCommand(id));
            commandExecutor.execute();
        }
    }

    private static void onUpdateVegetable() throws NotFoundException, IOException, ClassNotFoundException, ValidationErrorException, InterruptedException {
        Vegetable vegetable = new UpdateVegetableForm().show();
        if(vegetable != null) {
            commandExecutor.add(new UpdateVegetableCommand(vegetable.getId(), vegetable));
            commandExecutor.execute();
        }
    }

    private static void onDeleteVegetable() throws ValidationErrorException, IOException, NotFoundException, ClassNotFoundException, InterruptedException {
        Long id = new DeleteVegetableForm().show();
        if(id != null) {
            commandExecutor.add(new DeleteVegetableCommand(id));
            commandExecutor.execute();
        }
    }

    private static void onAddSalad() throws ValidationErrorException, IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        SaveSaladDto salad = new AddSaladForm().show();
        if(salad != null) {
            commandExecutor.add(new AddSaladCommand(salad));
            commandExecutor.execute();
        }
    }

    private static void onGetAllSalads() throws IOException, ClassNotFoundException, ValidationErrorException, NotFoundException, InterruptedException {
        commandExecutor.add(new GetAllSaladsCommand());
        commandExecutor.execute();
    }

    private static void onGetSaladById() throws ValidationErrorException, IOException, NotFoundException, ClassNotFoundException, InterruptedException {
        Long id = new GetSaladByIdForm().show();
        if(id != null) {
            commandExecutor.add(new GetSaladByIdCommand(id));
            commandExecutor.execute();
        }
    }

    private static void onUpdateSalad() throws IOException, ValidationErrorException, NotFoundException, ClassNotFoundException, InterruptedException {
        UpdateSaladMenu.Command updateSaladCommand = new UpdateSaladMenu().show();
        switch(updateSaladCommand) {
            case RENAME -> {
                onRenameSalad();
            }

            case ADD_INGREDIENT -> {
                onAddIngredient();
            }

            case DELETE_INGREDIENT -> {
                onDeleteIngredient();
            }
        }
    }

    private static void onRenameSalad() throws ValidationErrorException, IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        UpdateSaladDto updatedSalad = new RenameSaladForm().show();

        if(updatedSalad != null) {
            commandExecutor.add(new RenameSaladCommand(updatedSalad.getId(), updatedSalad));
            commandExecutor.execute();
        }
    }

    private static void onAddIngredient() throws ValidationErrorException, IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        AddSaladIngredientDto updatedSalad = new AddSaladIngredientForm().show();
        if(updatedSalad != null) {
            commandExecutor.add(new AddSaladIngredientCommand(updatedSalad));
            commandExecutor.execute();
        }
    }

    private static void onDeleteIngredient() throws ValidationErrorException, IOException, ClassNotFoundException, NotFoundException, InterruptedException {
        Long ingredientId = new DeleteSaladIngredientForm().show();
        if(ingredientId != null) {
            commandExecutor.add(new DeleteSaladIngredientCommand(ingredientId));
            commandExecutor.execute();
        }
    }

    private static void onGetCaloriesBySalad() throws ValidationErrorException, IOException, NotFoundException, ClassNotFoundException, InterruptedException {
        Long id = new GetCaloriesBySaladForm().show();
        if(id != null) {
            commandExecutor.add(new GetCaloriesBySaladCommand(id));
            commandExecutor.execute();
        }
    }

    private static void onSortSaladIngredientsByCalories() throws ValidationErrorException, IOException, NotFoundException, ClassNotFoundException, InterruptedException {
        Long id = new SortSaladIngredientsByCaloriesForm().show();
        if(id != null) {
            commandExecutor.add(new SortSaladIngredientsByCaloriesCommand(id));
            commandExecutor.execute();
        }
    }

    private static void onDeleteSalad() throws ValidationErrorException, IOException, NotFoundException, ClassNotFoundException, InterruptedException {
        Long id = new DeleteSaladForm().show();
        if(id != null) {
            commandExecutor.add(new DeleteSaladCommand(id));
            commandExecutor.execute();
        }
    }

    private static void onExit() {
        System.exit(0);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, ValidationErrorException, MessagingException, InterruptedException {
        AppLogger.initialize();

        logger = AppLogger.getInstance();
        commandExecutor = CommandExecutor.getInstance();

        Menu menu = new Menu();
        Menu.Command command;

        while(true) {
            try {
                command = menu.show();

                switch(command) {
                    case ADD_VEGETABLE -> onAddVegetable();

                    case GET_ALL_VEGETABLES -> onGetAllVegetables();

                    case GET_VEGETABLE_BY_ID -> onGetVegetableById();

                    case UPDATE_VEGETABLE -> onUpdateVegetable();

                    case DELETE_VEGETABLE -> onDeleteVegetable();

                    case ADD_SALAD -> onAddSalad();

                    case GET_ALL_SALADS -> onGetAllSalads();

                    case GET_SALAD_BY_ID -> onGetSaladById();

                    case UPDATE_SALAD -> onUpdateSalad();

                    case GET_CALORIES_BY_SALAD -> onGetCaloriesBySalad();

                    case SORT_SALAD_INGREDIENTS_BY_CALORIES -> onSortSaladIngredientsByCalories();

                    case DELETE_SALAD -> onDeleteSalad();

                    case EXIT -> onExit();
                }
            }
            catch (NotFoundException e) {
                commandExecutor.reset();
                String msg = e.getMessage();
                ConsoleUtils.writeLine(msg);
                logger.info(msg);
//                EmailUtils.sendEmail(System.getenv("receiverEmail"), msg);
            }
        }
    }
}
