package views.components;

import javax.swing.*;

public class PaginationPanel extends JPanel {

    private final JButton previousButton;

    private final JButton nextButton;

    public PaginationPanel() {

        previousButton = new JButton("<");

        nextButton = new JButton(">");

        add(previousButton);
        add(nextButton);
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }
}