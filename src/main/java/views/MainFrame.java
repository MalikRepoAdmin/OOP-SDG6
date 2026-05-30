package views;

import views.base.BaseFrame;
import views.comment.CommentPanel;
import views.dashboard.DashboardPanel;
import views.sungai.SungaiPanel;
import views.user.UserPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Main application window.
 *
 * Responsible for:
 * - navigation
 * - page switching
 * - app layout
 */
public class MainFrame extends BaseFrame {

    /**
     * Content layout manager.
     */
    private final CardLayout cardLayout;

    /**
     * Main content container.
     */
    private final JPanel contentPanel;

    public MainFrame() {

        super("Sistem Informasi Sungai");

        cardLayout = new CardLayout();

        contentPanel = new JPanel(cardLayout);

        initializeComponents();
    }

    @Override
    protected void initializeComponents() {

        add(createSidebar(), BorderLayout.WEST);

        add(createContentPanel(), BorderLayout.CENTER);

        showPage("dashboard");
    }

    /**
     * Sidebar navigation.
     */
    private JPanel createSidebar() {

        JPanel sidebar = new JPanel(
                new GridLayout(0, 1, 5, 5)
        );

        sidebar.setPreferredSize(
                new Dimension(220, 0)
        );

        JButton dashboardButton =
                new JButton("Dashboard");

        JButton sungaiButton =
                new JButton("Sungai");

        JButton userButton =
                new JButton("User");

        JButton commentButton =
                new JButton("Comment");

        sidebar.add(dashboardButton);
        sidebar.add(sungaiButton);
        sidebar.add(userButton);
        sidebar.add(commentButton);

        dashboardButton.addActionListener(e ->
                showPage("dashboard"));

        sungaiButton.addActionListener(e ->
                showPage("sungai"));

        userButton.addActionListener(e ->
                showPage("user"));

        commentButton.addActionListener(e ->
                showPage("comment"));

        return sidebar;
    }

    /**
     * Main content pages.
     */
    private JPanel createContentPanel() {

        contentPanel.add(
                new DashboardPanel(),
                "dashboard"
        );

        contentPanel.add(
                new UserPanel(),
                "user"
        );

        contentPanel.add(
                new SungaiPanel(),
                "sungai"
        );

        contentPanel.add(
                new CommentPanel(),
                "comment"
        );

        contentPanel.revalidate();

        contentPanel.repaint();

        return contentPanel;
    }

    /**
     * Switch active page.
     */
    private void showPage(String pageName) {

        cardLayout.show(contentPanel, pageName);
    }
}