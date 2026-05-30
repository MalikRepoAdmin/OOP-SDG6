package views.components;

import javax.swing.*;
import java.awt.*;

public class ConfirmDialog {

    public static boolean show(Component parent, String message) {

        int result = JOptionPane.showConfirmDialog(
                parent,
                message,
                "Konfirmasi",
                JOptionPane.YES_NO_OPTION
        );

        return result == JOptionPane.YES_OPTION;
    }
}