package views.components;

import javax.swing.*;
import java.awt.*;

public class AppTopbar extends JPanel {

    public AppTopbar(String title) {

        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        add(titleLabel, BorderLayout.WEST);

        add(new JTextField(20), BorderLayout.EAST);
    }
}