package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("Item existed");
        } else {
            itemsInStore.add(media);
            System.out.println("Added: " + media.getTitle());
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed: " + media.getTitle());
        } else {
            System.out.println("Item not existed");
        }
    }

    public void printStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("************************INVENTORY***********************");
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". " + media.toString());
            }
            System.out.println("********************************************************");
        }
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public Media searchById (int id){
        for (Media media: itemsInStore){
            if(media.getId() == id){
                return media;
            }
        }
        return null;
    }
}