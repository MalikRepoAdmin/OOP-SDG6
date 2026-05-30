package views.components;

import javax.swing.*;
import java.awt.*;

public class EmptyStatePanel extends JPanel {

    public EmptyStatePanel(String message) {

        setLayout(new GridBagLayout());

        JLabel label = new JLabel(message);

        label.setFont(new Font("SansSerif", Font.PLAIN, 18));

        add(label);
    }
}