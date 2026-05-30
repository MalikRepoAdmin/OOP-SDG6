package views.base;

import javax.swing.*;
import java.awt.*;

/**
 * Shared base frame.
 *
 * All future frames should extend this class
 * for consistency.
 */
public abstract class BaseFrame extends JFrame {

    public BaseFrame(String title) {

        setTitle(title);

        setSize(1200, 700);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
    }

    protected abstract void initializeComponents();
}