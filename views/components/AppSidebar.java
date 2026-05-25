package views.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Dynamic sidebar menu.
 */
public class AppSidebar extends JPanel {

    public AppSidebar(List<String> menus) {

        setLayout(new GridLayout(0, 1, 5, 5));

        setPreferredSize(new Dimension(220, 0));

        for (String menu : menus) {

            JButton button = new JButton(menu);

            add(button);
        }
    }
}