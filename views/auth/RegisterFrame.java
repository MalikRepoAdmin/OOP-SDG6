package views.auth;

import views.base.BaseFrame;
import views.utils.DialogUtil;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends BaseFrame {

    public RegisterFrame() {
        super("Register");

        initializeComponents();
    }

    @Override
    protected void initializeComponents() {

        add(createFormPanel(), BorderLayout.CENTER);
    }

    private JPanel createFormPanel() {

        JPanel panel = new JPanel(
                new GridLayout(5, 2, 10, 10)
        );

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton registerButton = new JButton("Register");

        panel.add(new JLabel("Nama"));
        panel.add(nameField);

        panel.add(new JLabel("Email"));
        panel.add(emailField);

        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        panel.add(new JLabel());
        panel.add(registerButton);

        registerButton.addActionListener(e -> {
            DialogUtil.showSuccess(this,
                    "Registrasi berhasil");
        });

        JButton backButton = new JButton("Back to Login");

        backButton.addActionListener(e -> {

            LoginFrame frame = new LoginFrame();

            frame.setVisible(true);

            dispose();
        });

        return panel;
    }
}