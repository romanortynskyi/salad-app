package exceptions;

import java.util.UUID;

public class IngredientNotFoundException extends NotFoundException {
    private String prefix;
    private UUID id;

    public IngredientNotFoundException(String prefix, UUID id) {
        this.prefix = prefix;
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = String.format("%s Ingredient %s does not exist", prefix, id);
        return message;
    }
}
