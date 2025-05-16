package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if(!authors.contains(authorName)){
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName){
        authors.remove(authorName);
    }

    public ArrayList<String> getAuthors(){
        return authors;
    }

    @Override
    public String toString(){
        return "Book - Title: " + getTitle() + " - Category: " + getCategory() + " - Cost: " + getCost() + "$";
    }
}
