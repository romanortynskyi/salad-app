package ui.forms;

import utils.ConsoleUtils;

import java.io.IOException;

public class UpdateSaladMenu extends Form<UpdateSaladMenu.Command>{
    public enum Command {
        RENAME,
        ADD_INGREDIENT,
        DELETE_INGREDIENT
    }

    private void showMenu() {
        System.out.println("1. Змінити назву салату");
        System.out.println("2. Додати інгредієнт");
        System.out.println("3. Видалити інгредієнт");
    }

    @Override
    public Command show() throws IOException {
        showMenu();

        String commandInput = ConsoleUtils.readLine();
        int commandIndex = Integer.parseInt(commandInput) - 1;

        Command command = Command.values()[commandIndex];

        return command;
    }
}
