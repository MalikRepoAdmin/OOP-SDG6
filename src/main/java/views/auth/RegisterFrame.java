package views.auth;

import views.base.BaseFrame;
import views.utils.DialogUtil;
import views.validator.GlobalExceptionHandler;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RegisterFrame extends BaseFrame {

    JTextField emailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    private RegisterRequest registerRequest;
    private Map<String, String> requestErrors;

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


        JButton registerButton = new JButton("Register");

        panel.add(new JLabel("Email"));
        panel.add(emailField);

        panel.add(new JLabel("Password"));
        panel.add(passwordField);

        panel.add(new JLabel());
        panel.add(registerButton);

        registerButton.addActionListener(e -> {

            this.registerRequest = new RegisterRequest(emailField.getText(), passwordField.getText());

            this.requestErrors = GlobalExceptionHandler.handleValidation(this.registerRequest);
                if (!this.requestErrors.isEmpty()) {
                    // JIKA ADA ERROR: tampilkan ke UI
                    DialogUtil.showError(null, "Gagal memproses data! Silakan perbaiki input Anda.");
                    
                    if (this.requestErrors.containsKey("email")) {
                        DialogUtil.showError(null, "Error Email: " + this.requestErrors.get("email"));
                    }
                    if (this.requestErrors.containsKey("password")) {
                        DialogUtil.showError(null, "Error Password: " + this.requestErrors.get("password"));
                    }

                    return;
                } else {
                    // JIKA AMAN: Lanjutkan proses Register
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke dashboard...");
                }

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