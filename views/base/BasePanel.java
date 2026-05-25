package views.base;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Shared panel base.
 */
public class BasePanel extends JPanel {

    public BasePanel() {

        setBackground(Color.WHITE);

        setBorder(new EmptyBorder(10, 10, 10, 10));
    }
}