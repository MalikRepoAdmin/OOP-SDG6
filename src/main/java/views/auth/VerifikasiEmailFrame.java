package views.auth;

import views.base.BaseFrame;
import views.utils.DialogUtil;

import javax.swing.*;
import java.awt.*;

public class VerifikasiEmailFrame extends BaseFrame {

    public VerifikasiEmailFrame() {
        super("Verifikasi Email");

        initializeComponents();
    }

    @Override
    protected void initializeComponents() {

        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));

        JLabel label = new JLabel(
                "Masukkan kode verifikasi email"
        );

        JTextField verificationField = new JTextField();

        JButton verifyButton = new JButton("Verifikasi");

        panel.add(label);
        panel.add(verificationField);
        panel.add(verifyButton);

        add(panel, BorderLayout.CENTER);

        verifyButton.addActionListener(e -> {
            DialogUtil.showSuccess(this, "Verifikasi berhasil");
        });
    }
}