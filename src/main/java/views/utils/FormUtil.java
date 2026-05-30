package views.utils;

import javax.swing.*;

public final class FormUtil {

    private FormUtil() {
    }

    public static void clearFields(JTextField... fields) {

        for (JTextField field : fields) {
            field.setText("");
        }
    }
}