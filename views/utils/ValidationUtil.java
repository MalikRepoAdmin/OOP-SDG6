package views.utils;

import java.util.Map;

public final class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean hasEmptyField(Map<String, String> values) {

        return values.values()
                .stream()
                .anyMatch(value -> value == null || value.trim().isEmpty());
    }
}