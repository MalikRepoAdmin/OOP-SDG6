package views.base;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Reusable CRUD panel.
 *
 * This class is intentionally backend-independent.
 * Other teammates can inject actions later.
 */
public class BaseCrudPanel extends JPanel {

    protected JTable table;

    protected JButton addButton;
    protected JButton editButton;
    protected JButton deleteButton;
    protected JButton refreshButton;

    protected JTextField searchField;

    private Runnable onAdd;
    private Runnable onEdit;
    private Runnable onDelete;
    private Runnable onRefresh;

    public BaseCrudPanel() {
        initializeComponents();
        initializeLayout();
        initializeEvents();
    }

    private void initializeComponents() {

        table = new JTable();

        addButton = new JButton("Tambah");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Hapus");
        refreshButton = new JButton("Refresh");

        searchField = new JTextField(20);
    }

    private void initializeLayout() {

        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        topPanel.add(addButton);
        topPanel.add(editButton);
        topPanel.add(deleteButton);
        topPanel.add(refreshButton);
        topPanel.add(searchField);

        add(topPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void initializeEvents() {

        addButton.addActionListener(e -> {
            if (onAdd != null) {
                onAdd.run();
            }
        });

        editButton.addActionListener(e -> {
            if (onEdit != null) {
                onEdit.run();
            }
        });

        deleteButton.addActionListener(e -> {
            if (onDelete != null) {
                onDelete.run();
            }
        });

        refreshButton.addActionListener(e -> {
            if (onRefresh != null) {
                onRefresh.run();
            }
        });
    }

    /**
     * Allows backend team to inject table model later.
     */
    public void setTableModel(BaseTableModel model) {
        table.setModel(model);
    }

    public JTable getTable() {
        return table;
    }

    public String getSearchKeyword() {
        return searchField.getText();
    }

    public void setOnAdd(Runnable onAdd) {
        this.onAdd = onAdd;
    }

    public void setOnEdit(Runnable onEdit) {
        this.onEdit = onEdit;
    }

    public void setOnDelete(Runnable onDelete) {
        this.onDelete = onDelete;
    }

    public void setOnRefresh(Runnable onRefresh) {
        this.onRefresh = onRefresh;
    }
}