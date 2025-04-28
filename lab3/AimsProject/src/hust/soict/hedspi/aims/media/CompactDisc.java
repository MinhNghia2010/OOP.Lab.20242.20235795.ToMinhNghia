package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if(tracks.contains(track)){
            System.out.println("Track existed: " + track.getTitle());
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    @Override
    public String toString(){
        return "CD - Title: " + getTitle() + " - Artist: " + getArtist() + " - Cost: " + getCost() + "$";
    }

    @Override
    public int getLength(){
        int totalLength = 0;
        for(Track track : tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        for(Track track : tracks){
            track.play();
        }
    }
}
