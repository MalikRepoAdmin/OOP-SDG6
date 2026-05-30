package views.auth;

import views.base.BaseFrame;
import views.utils.DialogUtil;
import views.validator.GlobalExceptionHandler;
import views.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class LoginFrame extends BaseFrame {

    JTextField emailField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    private LoginRequest loginRequest;
    private Map<String, String> requestErrors;


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

            this.loginRequest = new LoginRequest(emailField.getText(), passwordField.getText());

            this.requestErrors = GlobalExceptionHandler.handleValidation(this.loginRequest);
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
                    // JIKA AMAN: Lanjutkan proses login
                    DialogUtil.showSuccess(null, "Input valid! Menghubungkan ke dashboard...");
                }

            MainFrame frame =
                    new MainFrame();

            frame.setVisible(true);

            dispose();
        });

        registerButton.addActionListener(e -> {
            dispose();

            RegisterFrame frame =
                    new RegisterFrame();

            frame.setVisible(true);
        });

        forgotButton.addActionListener(e -> {
            dispose();

            ForgotPasswordFrame frame =
                    new ForgotPasswordFrame();

            frame.setVisible(true);
        });
    }
}