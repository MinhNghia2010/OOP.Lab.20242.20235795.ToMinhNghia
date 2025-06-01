package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.NegativePriceException;

import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public void setCost(float cost) throws NegativePriceException {
        if (cost < 0) {
            throw new NegativePriceException("ERROR: Media price cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;

        Media other = (Media) o;
        return this.getTitle() != null && this.getTitle().equals(other.getTitle());
    }
    
    @Override
    public int compareTo(Media other) {
        if (other == null) throw new NullPointerException("Compared media is null");

        int titleCompare = this.title.compareTo(other.title);
        if (titleCompare != 0) {
            return titleCompare;
        } else {
            return Float.compare(this.cost, other.cost);
        }
    }

    @Override
    public String toString() {
        return "Media - Title: " + title + " - Category: " + category + " - Cost: $" + cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }
    
}
