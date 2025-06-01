package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hespi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);

        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();

        // Thêm media vào Store
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, 88, "Roger Allers"));
        store.addMedia(new DigitalVideoDisc(2, "Aladin", "Animation", 18.99f, 90, "Ron Clements"));
        store.addMedia(new DigitalVideoDisc(3, "The Shawshank Redemption", "Drama", 21.99f, 142, "Frank Darabont"));
        store.addMedia(new Book(4, "The Hobbit", "Fantasy", 24.99f, new ArrayList<>(List.of("J.R.R. Tolkien"))));
        store.addMedia(new Book(5, "To Kill a Mockingbird", "Classic", 14.99f, new ArrayList<>(List.of("Harper Lee"))));
        store.addMedia(new CompactDisc(6, "The Beatles", "Rock", 19.99f, 60, "George Martin", "The Beatles"));
        
        launch(args);
    }
}