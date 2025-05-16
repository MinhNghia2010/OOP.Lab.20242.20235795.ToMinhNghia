package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(createMenuBar(), BorderLayout.NORTH);
        add(createFormPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(_ -> {
            new StoreManagerScreen(store);
            this.dispose();
        });

        JMenu updateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(_ -> {
            new AddBookToStoreScreen(store);
            this.dispose();
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(_ -> {
            new AddCompactDiscToStoreScreen(store);
            this.dispose();
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(_ -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            this.dispose();
        });

        updateStore.add(addBook);
        updateStore.add(addCD);
        updateStore.add(addDVD);

        menu.add(viewStore);
        menu.add(updateStore);

        JMenuBar bar = new JMenuBar();
        bar.setLayout(new FlowLayout(FlowLayout.LEFT));
        bar.add(menu);
        return bar;
    }

    protected abstract JPanel createFormPanel();
}

