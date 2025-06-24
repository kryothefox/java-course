package musicModel.com.core.Models;


public class Song extends Album {
    
    private String titleSong;

    private String[] artists;

    private String[] genreList;

    private String datePublished;

    public Song(String titleSong, String[] artists, String[] genreList, String datePublished) {
        this.titleSong = titleSong;
        this.artists = artists;
        this.genreList = genreList;
        this.datePublished = datePublished;
    }


    public Song(){

    }


    public String getTitleSong() {
        return titleSong;
    }


    public void setTitleSong(String titleSong) {
        this.titleSong = titleSong;
    }


    public String[] getArtists() {
        return artists;
    }


    public void setArtists(String[] artist) {
        this.artists = artist;
    }


    public String[] getGenreList() {
        return genreList;
    }


    public void setGenreList(String[] genreList) {
        this.genreList = genreList;
    }


    public String getDatePublished() {
        return datePublished;
    }


    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    

    @Override
    public String toString() {
        return "Song Title: " + titleSong + "\nArtist: " + String.join(", ",artists) + "\nGenres: " + String.join(", ",genreList)
                + "\nDate Published: " + datePublished;
    };

    

    

}
