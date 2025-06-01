package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private static final int MAX_ITEMS = 100;

    public Store() {
    }

    public boolean addMedia(Media media) {
        if (itemsInStore.size() >= MAX_ITEMS) {
            System.out.println("The store is full");
            return false;
        }

        itemsInStore.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added to the store");
        return true;
    }

    public boolean removeMedia(Media media) {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty");
            return false;
        }

        if (itemsInStore.remove(media)) {
            System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store");
            return true;
        } else {
            System.out.println("The media \"" + media.getTitle() + "\" was not found in the store");
            return false;
        }
    }

    public void displayItems() {
        if (itemsInStore.size() == 0) {
            System.out.println("The store is empty");
            return;
        }
        System.out.println("*******************STORE ITEMS*******************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("Total items: " + itemsInStore.size());
        System.out.println("*************************************************");
    }

    public void printStore() {
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public int getqtyInStore() {
        return itemsInStore.size();
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public List<Media> searchByTitleLowerCase(String title) {
        List<Media> result = new ArrayList<Media>();
        for (Media media : itemsInStore) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(media);
            }
        }
        if (result.size() == 0) {
            return null;
        }

        return result;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return media;
            }
        }
        return null;
    }
}