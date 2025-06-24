package models.Music;

public class Artist {
    String name;
    int dateFormed;
    int numberOfAlbums;
    boolean isActive;

    public Artist(String name, int dateFormed, int numberOfAlbums, boolean isActive) {
        this.name = name;
        this.dateFormed = dateFormed;
        this.numberOfAlbums = numberOfAlbums;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getDateFormed() {
        return dateFormed;
    }

    public int getNumberOfAlbums() {
        return numberOfAlbums;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return name + "\nDate Formed: " + dateFormed + "\n Number of Albums: " + numberOfAlbums
                + "\nActive: " + isActive;
    }
    
}
