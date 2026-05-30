package views.components;

import javax.swing.*;
import java.awt.*;

public class LoadingPanel extends JPanel {

    public LoadingPanel() {

        setLayout(new GridBagLayout());

        JProgressBar progressBar = new JProgressBar();

        progressBar.setIndeterminate(true);

        add(progressBar);
    }
}