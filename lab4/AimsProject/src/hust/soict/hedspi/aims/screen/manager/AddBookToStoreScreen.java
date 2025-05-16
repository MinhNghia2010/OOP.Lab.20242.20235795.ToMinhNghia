package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField titleField = new JTextField(30);
        JTextField categoryField = new JTextField(30);
        JTextField costField = new JTextField(30);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(_ -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());

            Book book = new Book(title, category, cost);
            store.addMedia(book);

            JOptionPane.showMessageDialog(this, "Book added successfully!");
        });

        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(addButton);

        return panel;
    }
}

