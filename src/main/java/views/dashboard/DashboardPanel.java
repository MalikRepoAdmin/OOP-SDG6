package views.dashboard;

import javax.swing.*;
import java.awt.*;

/**
 * Dashboard content panel.
 *
 * Responsible for:
 * - statistics
 * - dashboard widgets
 * - activity sections
 */
public class DashboardPanel extends JPanel {

    public DashboardPanel() {

        setLayout(new BorderLayout(15, 15));

        add(createStatisticsSection(),
                BorderLayout.NORTH);

        add(createBottomSection(),
                BorderLayout.CENTER);
    }

    /**
     * Top statistics cards.
     */
    private JPanel createStatisticsSection() {

        JPanel panel = new JPanel(
                new GridLayout(2, 2, 15, 15)
        );

        panel.add(createCard(
                "Total Sungai",
                "25"
        ));

        panel.add(createCard(
                "Total User",
                "120"
        ));

        panel.add(createCard(
                "Komentar Baru",
                "18"
        ));

        panel.add(createCard(
                "Sungai Bersih",
                "80%"
        ));

        return panel;
    }

    /**
     * Bottom dashboard widgets.
     */
    private JPanel createBottomSection() {

        JPanel panel = new JPanel(
                new GridLayout(1, 2, 15, 15)
        );

        panel.add(createRecentActivityPanel());

        panel.add(createRecentCommentPanel());

        return panel;
    }

    /**
     * Reusable statistic card.
     */
    private JPanel createCard(
            String title,
            String value
    ) {

        JPanel card = new JPanel(
                new BorderLayout()
        );

        card.setBorder(
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
                        32
                )
        );

        card.add(titleLabel, BorderLayout.NORTH);

        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    /**
     * Recent system activity section.
     */
    private JPanel createRecentActivityPanel() {

        JPanel panel = new JPanel(
                new BorderLayout()
        );

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        "Aktivitas Terbaru"
                )
        );

        DefaultListModel<String> model =
                new DefaultListModel<>();

        model.addElement(
                "User Malik menambahkan komentar"
        );

        model.addElement(
                "Admin memperbarui status sungai"
        );

        model.addElement(
                "Data sungai baru ditambahkan"
        );

        JList<String> activityList =
                new JList<>(model);

        panel.add(
                new JScrollPane(activityList),
                BorderLayout.CENTER
        );

        return panel;
    }

    /**
     * Recent comments section.
     */
    private JPanel createRecentCommentPanel() {

        JPanel panel = new JPanel(
                new BorderLayout()
        );

        panel.setBorder(
                BorderFactory.createTitledBorder(
                        "Komentar Terbaru"
                )
        );

        JTextArea commentArea = new JTextArea();

        commentArea.setEditable(false);

        commentArea.setText(
                "- Sungai terlihat bersih\\n\\n" +
                "- Air mulai keruh setelah hujan\\n\\n" +
                "- Banyak sampah di area utara"
        );

        panel.add(
                new JScrollPane(commentArea),
                BorderLayout.CENTER
        );

        return panel;
    }
}