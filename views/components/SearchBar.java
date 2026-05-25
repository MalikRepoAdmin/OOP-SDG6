package views.components;

import javax.swing.*;
import java.awt.*;

public class SearchBar extends JPanel {

    private final JTextField searchField;

    private Runnable onSearch;

    public SearchBar() {

        setLayout(new BorderLayout(5, 5));

        searchField = new JTextField();

        JButton searchButton = new JButton("Cari");

        add(searchField, BorderLayout.CENTER);
        add(searchButton, BorderLayout.EAST);

        searchButton.addActionListener(e -> {
            if (onSearch != null) {
                onSearch.run();
            }
        });
    }

    public String getKeyword() {
        return searchField.getText();
    }

    public void setOnSearch(Runnable onSearch) {
        this.onSearch = onSearch;
    }
}