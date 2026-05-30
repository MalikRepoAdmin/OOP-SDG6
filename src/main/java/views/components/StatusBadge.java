package views.components;

import javax.swing.*;
import java.awt.*;

public class StatusBadge extends JLabel {

    public StatusBadge(String status) {

        setText(status);

        setOpaque(true);

        setHorizontalAlignment(CENTER);

        setForeground(Color.WHITE);

        switch (status.toLowerCase()) {

            case "aktif", "bersih" -> setBackground(new Color(76, 175, 80));

            case "warning" -> setBackground(new Color(255, 152, 0));

            default -> setBackground(new Color(244, 67, 54));
        }
    }
}