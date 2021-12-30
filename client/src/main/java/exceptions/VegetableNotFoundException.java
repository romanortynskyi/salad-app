package exceptions;

public class VegetableNotFoundException extends NotFoundException {
    private String prefix;
    private Long id;

    public VegetableNotFoundException(String prefix, Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        String message = String.format("%s Vegetable %s does not exist", prefix, id);
        return message;
    }
}
