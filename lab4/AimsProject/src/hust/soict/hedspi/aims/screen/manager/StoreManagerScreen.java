package hust.soict.hedspi.aims.screen.manager;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreManagerScreen extends JFrame{
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // return to main page
        JMenuItem viewStoreItem = new JMenuItem("View store");
        viewStoreItem.addActionListener(_ -> {
            new StoreManagerScreen(store);
        });
        menu.add(new JMenuItem("View store"));


        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(_ -> {
            dispose();
            new AddBookToStoreScreen(store);  // open new screen
        });
        smUpdateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(_ -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });
        smUpdateStore.add(addCD);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(_ -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });
        smUpdateStore.add(addDVD);


        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < 9; i++) {
            if (i < mediaInStore.size()) {
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            } else {
                center.add(new JPanel());
            }
        }
        return center;
    }



    public static void main(String[] args) {
        Store store = new Store();
        store.addMedia(new DigitalVideoDisc("Interstellar", "Sci-Fi", 19.99f));
        store.addMedia(new DigitalVideoDisc("Inception", "Action", 15.49f));
        store.addMedia(new Book("Clean Code", "Programming", 42.00f));
        store.addMedia(new Book("The Art of War", "Strategy", 18.75f));
        store.addMedia(new Book("The Pragmatic Programmer", "Programming", 39.99f));
        store.addMedia(new CompactDisc("Greatest Hits", "Pop", 30.00f));
        store.addMedia(new CompactDisc("Classical Moods", "Classical", 22.50f));
        store.addMedia(new CompactDisc("Lo-fi Chill Beats", "Electronic", 27.80f));

        new StoreManagerScreen(store);
    }
}
