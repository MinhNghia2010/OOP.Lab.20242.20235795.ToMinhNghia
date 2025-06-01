package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.ItemNotFoundException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.exception.PlayerException;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ItemNotFoundException {
        store.addMedia(new DigitalVideoDisc(1, "Inception", "Science Fiction", 25.0f, 148, "Christopher Nolan"));
        store.addMedia(new Book(2, "The Hobbit", "Fantasy Adventure", 18.0f, new ArrayList<>(List.of("J.R.R. Tolkien"))));
        store.addMedia(new CompactDisc(3, "Thriller", "Pop", 12.0f, 42, "Quincy Jones", "Michael Jackson"));

        while (true) {
            showMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> viewCart();
                case 0 -> {
                    System.out.println("Exiting.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    //show menu
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    //show store menu
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    //media menu
    public static void mediaDetailsMenu(boolean isPlayable) {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (isPlayable) System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1" + (isPlayable ? "-2" : ""));
    }

    //cart menu
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore() {
        while (true) {
            store.displayItems();
            storeMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        mediaDetails(media);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    title = scanner.nextLine();
                    media = store.searchByTitle(title);
                    if (media != null) {
                        cart.addMedia(media);
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    title = scanner.nextLine();
                    media = store.searchByTitle(title);
                    if (media != null && media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void mediaDetails(Media media) {
        if (media != null) {
            System.out.println(media);
            if (media instanceof Playable) {
                mediaDetailsMenu(true);
            } else {
                mediaDetailsMenu(false);
            }
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void updateStore() {
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        int choice = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter cost: ");
        float cost = Float.parseFloat(scanner.nextLine());

        if (choice == 1) {
            System.out.println("Choose media type:");
            System.out.println("1. Book");
            System.out.println("2. DVD");
            System.out.println("3. CD");
            int mediaType = Integer.parseInt(scanner.nextLine());

            Media media = null;
            switch (mediaType) {
                case 1:
                    System.out.print("Enter author (or multiple authors separated by comma): ");
                    String authorInput = scanner.nextLine();
                    ArrayList<String> authors = new ArrayList<>(Arrays.asList(authorInput.split(",")));
                    media = new Book(store.getItemsInStore().size() + 1, title, category, cost, authors);
                    break;
                case 2:
                    System.out.print("Enter director: ");
                    String director = scanner.nextLine();
                    System.out.print("Enter length: ");
                    int length = Integer.parseInt(scanner.nextLine());
                    media = new DigitalVideoDisc(store.getItemsInStore().size() + 1, title, category, cost, length, director);
                    break;
                case 3:
                    System.out.print("Enter artist: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter director: ");
                    director = scanner.nextLine();
                    System.out.print("Enter length: ");
                    length = Integer.parseInt(scanner.nextLine());
                    media = new CompactDisc(store.getItemsInStore().size() + 1, title, category, cost, length, director, artist);
                    break;
                default:
                    System.out.println("Invalid media type.");
                    return;
            }
            store.addMedia(media);
            System.out.println("Added media to store.");
        } else if (choice == 2) {
            Media media = store.searchByTitle(title);
            if (media != null) {
                store.removeMedia(media);
                System.out.println("Removed media from store.");
            } else {
                System.out.println("Media not found in store.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public static void viewCart() throws ItemNotFoundException {
        while (true) {
            cart.print();
            cartMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID, 2. Title");
                    int filterChoice = Integer.parseInt(scanner.nextLine());
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        cart.searchById(id);
                    } else {
                        System.out.print("Enter title: ");
                        String filterTitle = scanner.nextLine();
                        cart.searchByTitle(filterTitle);
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title, 2. Cost");
                    int sortChoice = Integer.parseInt(scanner.nextLine());
                    if (sortChoice == 1) {
                        cart.sortMediaByTitleCost();
                        cart.print();
                    } else {
                        cart.sortMediaByCostTitle();
                        cart.print();
                    }
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();
                    Media mediaToRemove = store.searchByTitle(removeTitle);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                        System.out.println("Media removed from cart.");
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    Media mediaToPlay = store.searchByTitle(playTitle);
                    if (mediaToPlay != null && mediaToPlay instanceof Playable) {
                        try {
                            ((Playable) mediaToPlay).play();
                        } catch (PlayerException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Media cannot be played or not found.");
                    }
                    break;
                case 5:
                    System.out.println("Order has been placed.");
                    cart = new Cart();  // Create a new empty cart
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}