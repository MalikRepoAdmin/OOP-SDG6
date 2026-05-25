package views.auth;

import views.base.BaseFrame;
import views.utils.DialogUtil;

import javax.swing.*;
import java.awt.*;

public class ForgotPasswordFrame extends BaseFrame {

    public ForgotPasswordFrame() {
        super("Forgot Password");

        initializeComponents();
    }

    @Override
    protected void initializeComponents() {

        add(createContent(), BorderLayout.CENTER);
    }

    private JPanel createContent() {

        JPanel panel = new JPanel(
                new GridLayout(3, 1, 10, 10)
        );

        JTextField emailField = new JTextField();

        JButton resetButton = new JButton(
                "Kirim Reset Password"
        );

        panel.add(new JLabel("Masukkan Email"));
        panel.add(emailField);
        panel.add(resetButton);

        resetButton.addActionListener(e -> {
            DialogUtil.showSuccess(this,
                    "Link reset password dikirim");
        });

        return panel;
    }
}