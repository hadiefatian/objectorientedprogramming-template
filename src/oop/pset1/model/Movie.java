package oop.pset1.model;

import java.util.List;

public class Movie {

    private List<String> genre;
    private String title;
    private Double rating;


    public List<String> getGenre() {
        return genre;
    }
    public void setGenre(List<String> genre) {
        this.genre = genre;
    }


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title ='" + title + '\'' +
                ", rating =" + rating +
                ", genre =" + genre +
                '}';
    }
}
