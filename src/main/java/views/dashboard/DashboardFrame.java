package views.dashboard;

import views.base.BaseFrame;
import views.components.AppSidebar;
import views.components.AppTopbar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Main dashboard window.
 *
 * Responsible ONLY for:
 * - app shell
 * - navigation
 * - layout composition
 *
 * Does NOT contain dashboard business UI directly.
 */
public class DashboardFrame extends BaseFrame {

    public DashboardFrame() {
        super("Dashboard");
    }

    @Override
    protected void initializeComponents() {

        add(createSidebar(), BorderLayout.WEST);

        add(createMainContent(), BorderLayout.CENTER);
    }

    /**
     * Creates left navigation sidebar.
     */
    private JPanel createSidebar() {

        return new AppSidebar(List.of(
                "Dashboard",
                "Sungai",
                "User",
                "Comment",
                "Kategori",
                "Status",
                "Logout"
        ));
    }

    /**
     * Main app content area.
     */
    private JPanel createMainContent() {

        JPanel panel = new JPanel(
                new BorderLayout(10, 10)
        );

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        panel.add(createTopbar(), BorderLayout.NORTH);

        panel.add(createDashboardContent(),
                BorderLayout.CENTER);

        return panel;
    }

    /**
     * Top navigation/header.
     */
    private JPanel createTopbar() {

        return new AppTopbar("Dashboard");
    }

    /**
     * Actual dashboard content.
     */
    private JPanel createDashboardContent() {

        return new DashboardPanel();
    }
}