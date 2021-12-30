package exceptions;

import java.util.UUID;

public class SaladNotFoundException extends NotFoundException {
    private String prefix;
    private UUID id;

    public SaladNotFoundException(String prefix, UUID id) {
        this.prefix = prefix;
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = String.format("%s Salad %s does not exist", prefix, id);
        return message;
    }
}
