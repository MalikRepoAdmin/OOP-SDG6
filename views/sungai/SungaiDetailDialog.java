package views.sungai;

import javax.swing.*;
import java.awt.*;

public class SungaiDetailDialog extends JDialog {

    public SungaiDetailDialog(Object[] data) {

        setTitle("Detail Sungai");

        setLayout(new GridLayout(0, 2, 10, 10));

        add(new JLabel("ID"));
        add(new JLabel(data[0].toString()));

        add(new JLabel("Nama Sungai"));
        add(new JLabel(data[1].toString()));

        add(new JLabel("Kategori"));
        add(new JLabel(data[2].toString()));

        add(new JLabel("Status"));
        add(new JLabel(data[3].toString()));

        pack();

        setLocationRelativeTo(null);
    }
}