package views.dashboard;

import javax.swing.*;
import java.awt.*;

/**
 * Reusable dashboard statistic card.
 */
public class DashboardCard extends JPanel {

    public DashboardCard(
            String title,
            String value
    ) {

        initializeComponents(title, value);
    }

    private void initializeComponents(
            String title,
            String value
    ) {

        setLayout(new BorderLayout());

        setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 220)
                        ),
                        BorderFactory.createEmptyBorder(
                                15,
                                15,
                                15,
                                15
                        )
                )
        );

        JLabel titleLabel = new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        14
                )
        );

        JLabel valueLabel = new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        28
                )
        );

        add(titleLabel, BorderLayout.NORTH);

        add(valueLabel, BorderLayout.CENTER);
    }
}