package utils;

import java.util.function.Predicate;

public class ValidationUtils {
    public static boolean isDouble(String input) {
        return input.matches("\\d+(\\.\\d)?");
    }

    public static boolean isUUID(String input) {
        return input.matches("[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}");
    }
}
