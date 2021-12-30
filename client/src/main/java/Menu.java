import exceptions.NotFoundException;
import utils.ConsoleUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Menu {
    public enum Command {
        ADD_VEGETABLE,
        GET_ALL_VEGETABLES,
        GET_VEGETABLE_BY_ID,
        UPDATE_VEGETABLE,
        DELETE_VEGETABLE,

        ADD_SALAD,
        GET_ALL_SALADS,
        GET_SALAD_BY_ID,
        UPDATE_SALAD,
        DELETE_SALAD,

        GET_CALORIES_BY_SALAD,
        SORT_SALAD_INGREDIENTS_BY_CALORIES,

        EXIT
    }

    private void showMenu() {
        System.out.println("1. Створити овоч");
        System.out.println("2. Переглянути всі овочі");
        System.out.println("3. Переглянути овоч за id");
        System.out.println("4. Оновити овоч");
        System.out.println("5. Видалити овоч");

        System.out.println("6. Створити салат");
        System.out.println("7. Переглянути всі салати");
        System.out.println("8. Переглянути салат за id");
        System.out.println("9. Оновити салат");
        System.out.println("10. Видалити салат");

        System.out.println("11. Переглянути к-сть калорій салату");
        System.out.println("12. Сортувати інгредієнти салату за калорійністю");

        System.out.println("13. Вийти");
    }

    public Command show() throws IOException, NotFoundException {
        showMenu();

        String commandInput = ConsoleUtils.readLine();
        int commandIndex = Integer.parseInt(commandInput) - 1;

        Command[] commands = Command.values();
        if(commandIndex < 0 || commandIndex >= commands.length) throw new NotFoundException("Команда не існує");

        Command command = commands[commandIndex];

        return command;
    }
}
