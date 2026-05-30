package views.comment;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.*;

public class CommentDetailDialog extends JDialog {

	public CommentDetailDialog(Object[] data) {

        setTitle("Detail Comment");

        setLayout(new GridLayout(0, 2, 10, 10));

        add(new JLabel("ID"));
        add(new JLabel(data[0].toString()));

        add(new JLabel("Nama User"));
        add(new JLabel(data[1].toString()));

        add(new JLabel("Isi Komentar"));
        add(new JLabel(data[2].toString()));

        add(new JLabel("Tanggal"));
        add(new JLabel(data[3].toString()));

        pack();

        setLocationRelativeTo(null);
    }
}