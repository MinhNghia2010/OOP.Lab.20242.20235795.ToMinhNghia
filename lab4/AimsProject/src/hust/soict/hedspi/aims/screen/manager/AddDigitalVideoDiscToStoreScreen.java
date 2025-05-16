package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField titleField = new JTextField(30);
        JTextField categoryField = new JTextField(30);
        JTextField costField = new JTextField(30);

        JButton addButton = new JButton("Add DigitalVideoDisc");
        addButton.addActionListener(_ -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());

            DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(title, category, cost);
            store.addMedia(digitalVideoDisc);

            JOptionPane.showMessageDialog(this, "DigitalVideoDisc added successfully!");
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
