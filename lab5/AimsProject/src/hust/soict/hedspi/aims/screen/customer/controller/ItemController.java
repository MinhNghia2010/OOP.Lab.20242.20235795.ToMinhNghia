
package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;


    private Media media;
    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (media != null) {
            cart.addMedia(media);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Add to Cart");
            alert.setHeaderText(null);
            alert.setContentText(media.getTitle() + " has been added to your cart. Total items: " + cart.getItemsOrdered().size());
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Cannot add null media to cart");
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText(null);
                alert.setContentText("Now playing: " + media.getTitle());
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText(null);
                alert.setContentText("Error playing " + media.getTitle() + ": " + e.getMessage());
                alert.showAndWait();
            }
        }
    }

}
