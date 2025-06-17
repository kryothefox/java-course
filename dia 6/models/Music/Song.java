package models.Music;

import java.util.Arrays;

public class Song extends Album {

    String title;
    String[] publishers;
    String genre;
    Album songAlbum;
    String ISRCCode;

    int yearPublished;
    int durationInSeconds;


    

    public Song(String title, Album songAlbum, Artist songArtist,
            String[] publishers, String genre, int yearPublished, int durationInSeconds,
            String iSRCCode) {
        super(songAlbum.albumName, songAlbum.numberOfSongs, songAlbum.isExplicit, songAlbum.yearReleased, songArtist);
        this.title = title;
        this.publishers = publishers;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.durationInSeconds = durationInSeconds;
        this.songAlbum = songAlbum;
        ISRCCode = iSRCCode;
    }

    public String getTitle() {
        return title;
    }

    public String[] getPublishers() {
        return publishers;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public String getISRCCode() {
        return ISRCCode;
    }

    public Album getAlbum(){
        return songAlbum;
    }


    @Override
    public String toString() {
        return title + "\nPublishers: " + Arrays.toString(publishers) + "\nGenre: " + genre + "\nAlbum: "
                + albumName + "\nYear Published: " + yearPublished + "\nDuration: " + durationInSeconds
                + "s\nISRC Code: " + ISRCCode;
    }

}
