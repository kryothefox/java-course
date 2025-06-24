package com.core.models;

public class Movie {
    public static enum Genre{
        ACTION, THRILLER, WESTERN, COMEDY, SCIFI, DRAMA; 
    }
        
    private String title, director;
    private Genre genre;
    private int year;
    private double rating;
    private boolean viewed;

    public Movie(String title, String director, Genre genre, int year, double rating, boolean viewed) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.viewed = viewed;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", director=" + director + ", genre=" + genre + ", year=" + year + ", rating=" + rating + ", viewed=" + viewed + '}';
    }
    
    
    
    
}
