package views.auth;

import views.base.BaseFrame;
import views.MainFrame;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends BaseFrame {

    public LoginFrame() {

        super("Login");

        initializeComponents();
    }

    @Override
    protected void initializeComponents() {

        add(createMainPanel(),
                BorderLayout.CENTER);
    }

    /**
     * Main login UI.
     */
    private JPanel createMainPanel() {

        JPanel wrapper = new JPanel(
                new GridBagLayout()
        );

        JPanel panel = new JPanel(
                new GridLayout(6, 1, 10, 10)
        );

        panel.setPreferredSize(
                new Dimension(350, 300)
        );

        JLabel titleLabel =
                new JLabel(
                        "Sistem Informasi Sungai",
                        SwingConstants.CENTER
                );

        titleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        JTextField emailField =
                new JTextField();

        JPasswordField passwordField =
                new JPasswordField();

        JButton loginButton =
                new JButton("Login");

        JButton registerButton =
                new JButton("Register");

        JButton forgotButton =
                new JButton("Forgot Password");

        panel.add(titleLabel);

        panel.add(createFieldPanel(
                "Email",
                emailField
        ));

        panel.add(createFieldPanel(
                "Password",
                passwordField
        ));

        panel.add(loginButton);

        panel.add(registerButton);

        panel.add(forgotButton);

        initializeActions(
                loginButton,
                registerButton,
                forgotButton
        );

        wrapper.add(panel);

        return wrapper;
    }

    /**
     * Reusable form field section.
     */
    private JPanel createFieldPanel(
            String label,
            JComponent field
    ) {

        JPanel panel = new JPanel(
                new BorderLayout(5, 5)
        );

        panel.add(
                new JLabel(label),
                BorderLayout.NORTH
        );

        panel.add(field,
                BorderLayout.CENTER);

        return panel;
    }

    /**
     * Navigation actions.
     */
    private void initializeActions(
            JButton loginButton,
            JButton registerButton,
            JButton forgotButton
    ) {

        loginButton.addActionListener(e -> {

            MainFrame frame =
                    new MainFrame();

            frame.setVisible(true);

            dispose();
        });

        registerButton.addActionListener(e -> {

            RegisterFrame frame =
                    new RegisterFrame();

            frame.setVisible(true);

            dispose();
        });

        forgotButton.addActionListener(e -> {

            ForgotPasswordFrame frame =
                    new ForgotPasswordFrame();

            frame.setVisible(true);

            dispose();
        });
    }
}