package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleFloatProperty;


public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private SimpleFloatProperty totalCost = new SimpleFloatProperty(0.0f);
    public Cart() {

    }
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!");
            return;
        }
        itemsOrdered.add(media);
        calculateTotalCost();
        System.out.println("The media \"" + media.getTitle() + "\" has been added");
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED - 1) {
            System.out.println("The cart is almost full!");
        } else if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!");
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty!");
            return;
        }
        if (itemsOrdered.remove(media)) {
            calculateTotalCost();
            System.out.println("The media \"" + media.getTitle() + "\" has been removed");
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" was not found in the cart");
        }
    }
    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }
    public void calculateTotalCost() {
        float cost = 0;
        for (Media media : itemsOrdered) {
            cost += media.getCost();
        }
        totalCost.set(cost);
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        if (itemsOrdered.size() == 0) {
            System.out.println("The cart is empty!");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
            }
            System.out.println("Total cost: " + totalCost() + " $");
        }
        System.out.println("***************************************************");
    }
    public void searchById(int id) {
        boolean found = false;
        System.out.println("***********************CART***********************");
        System.out.println("Search results for ID: " + id);

        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No match found for ID: " + id);
        }
        System.out.println("***************************************************");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        System.out.println("***********************CART***********************");
        System.out.println("Search results for title: " + title);

        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            if (media instanceof DigitalVideoDisc) {
                if (((DigitalVideoDisc) media).isMatch(title)) {
                    System.out.println((i + 1) + ". " + media.toString());
                    found = true;
                }
            } else if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println((i + 1) + ". " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found for title: " + title);
        }
        System.out.println("***************************************************");
    }
    public void displayCartItems() {
        if (itemsOrdered.size() == 0) {
            System.out.println("The cart is empty!");
            return;
        }
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.print((i + 1));
            System.out.print("	");
            System.out.print(itemsOrdered.get(i).getTitle());
            System.out.print("	");
            System.out.println(itemsOrdered.get(i).getCost());
        }
        System.out.print("	");
        System.out.print("Total Cost	");
        System.out.println(totalCost());
    }
    public void sortMediaByTitleCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortMediaByCostTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public SimpleFloatProperty totalCostProperty() {
        return totalCost;
    }
    public float getTotalCost() {
        return totalCost.get();
    }
    public void clearCart() {
        itemsOrdered.clear();
        calculateTotalCost();
    }
}