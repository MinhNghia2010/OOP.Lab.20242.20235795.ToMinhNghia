package hust.soict.hedspi.aims.screen.customer.controller;

import java.io.IOException;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.RadioButton;

public class CartController {

    private Cart cart;
    private Store store;
    private FilteredList<Media> filteredMedia;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
        this.store = store;
    }
    @FXML
    private javafx.scene.control.TextField txtFilter;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        if (cart != null && cart.totalCostProperty() != null) {
            cart.totalCostProperty().addListener((observable, oldValue, newValue) -> {
                costLabel.setText(String.format("%.2f $", newValue.floatValue()));
            });
            costLabel.setText(String.format("%.2f $", cart.getTotalCost()));
        } else {
            System.err.println("Cart or totalCostProperty is null. Cannot set up listener for costLabel.");
            if (cart != null) {
                costLabel.setText(String.format("%.2f $", cart.getTotalCost()));
            } else {
                costLabel.setText("N/A");
            }
        }
        if(cart.getItemsOrdered() != null){
            filteredMedia = new FilteredList<>(cart.getItemsOrdered(), p -> true);
            tblMedia.setItems(filteredMedia);
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
//        txtFilter.textProperty().addListener(new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                showFilteredMedia(newValue);
//            }
//        });
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> filterMedia(newValue));
        radioBtnFilterId.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            if (isSelected) {
                filterMedia(txtFilter.getText());
            }
        });

        radioBtnFilterTitle.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            if (isSelected) {
                filterMedia(txtFilter.getText());
            }
        });
    }
    private void filterMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
            filteredMedia.setPredicate(s -> true);
        } else {
            filteredMedia.setPredicate(media -> {
                if (media == null) {
                    return false;
                }
                String lowerCaseFilter = filter.toLowerCase();
                if (radioBtnFilterTitle.isSelected()) {
                    return media.getTitle().toLowerCase().contains(lowerCaseFilter);
                } else if (radioBtnFilterId.isSelected()) {
                    try {
                        int idFilter = Integer.parseInt(filter);
                        return media.getId() == idFilter;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid ID format: " + filter + " - " + e.getMessage());
                        return false;
                    }
                }
                return false;
            });
        }
    }
//	private void showFilteredMedia(String filter) {
//        if (filteredMedia == null) return;
//
//        filteredMedia.setPredicate(media -> {
//            if (filter == null || filter.isEmpty()) {
//                return true;
//            }
//
//            String lowerCaseFilter = filter.toLowerCase();
//
//            return media.getTitle().toLowerCase().contains(lowerCaseFilter)
//                || media.getCategory().toLowerCase().contains(lowerCaseFilter);
//        });
//    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof Playable) {
            try {
                ((Playable) selectedMedia).play();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText(null);
                alert.setContentText("Now playing: " + selectedMedia.getTitle());
                alert.showAndWait();
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText(null);
                alert.setContentText("Error playing " + selectedMedia.getTitle() + ": " + e.getMessage());
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Not Playable");
            alert.setHeaderText(null);
            alert.setContentText("The selected media is not playable");
            alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }


    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.clearCart();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }


}