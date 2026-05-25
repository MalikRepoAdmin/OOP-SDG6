package views.base;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Dynamic form dialog.
 *
 * Fields are generated dynamically.
 */
public class BaseFormDialog extends JDialog {

    private final Map<String, JTextField> fieldMap;

    private Runnable onSave;

    public BaseFormDialog(
            Frame owner,
            String title,
            String[] fields
    ) {

        super(owner, title, true);

        fieldMap = new LinkedHashMap<>();

        initialize(fields);
    }

    private void initialize(String[] fields) {

        setLayout(new BorderLayout(10, 10));

        JPanel formPanel = new JPanel(new GridLayout(fields.length, 2, 10, 10));

        for (String field : fields) {

            JLabel label = new JLabel(field);

            JTextField textField = new JTextField();

            fieldMap.put(field, textField);

            formPanel.add(label);
            formPanel.add(textField);
        }

        JButton saveButton = new JButton("Simpan");
        JButton cancelButton = new JButton("Batal");

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(e -> {
            if (onSave != null) {
                onSave.run();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(null);
    }

    public Map<String, String> getFormValues() {

        Map<String, String> values = new LinkedHashMap<>();

        fieldMap.forEach((key, value) -> {
            values.put(key, value.getText());
        });

        return values;
    }

    public void setFieldValue(String fieldName, String value) {

        JTextField field = fieldMap.get(fieldName);

        if (field != null) {
            field.setText(value);
        }
    }

    public void setOnSave(Runnable onSave) {
        this.onSave = onSave;
    }
}