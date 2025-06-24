package models.Music;

public class Album extends Artist {

    String albumName;
    int numberOfSongs;
    boolean isExplicit;
    int yearReleased;
    Artist albumArtist;

    public Album(String albumName, int numberOfSongs,
            boolean isExplicit, int yearReleased, Artist artist) {
        super(artist.name,artist.dateFormed,artist.numberOfAlbums,artist.isActive);
        this.albumName = albumName;
        this.numberOfSongs = numberOfSongs;
        this.isExplicit = isExplicit;
        this.yearReleased = yearReleased;
        this.albumArtist = artist;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public Artist getAlbumArtist(){
        return albumArtist;
    }

    @Override
    public String toString() {
        return albumName + (isExplicit==true ? " (E)" : "") + "\nNumber of Songs: " + numberOfSongs + "\nYear Released: " + yearReleased;
    }
    
    

}
