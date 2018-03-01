package oop.pset1.view;

import java.util.List;

public class Summary {

    private List<String> mostRatedFilms;
    private List<String> mostAppearingMovieGenres;
    private List<String> mostHiredActors;
    private List<String> maleFemaleRatioPercentage;


    public List<String> getMostRatedFilms() {
        return mostRatedFilms;
    }
    public void setMostRatedFilms(List<String> mostRatedFilms) {
        this.mostRatedFilms = mostRatedFilms;
    }


    public List<String> getMostAppearingMovieGenres() {
        return mostAppearingMovieGenres;
    }
    public void setMostAppearingMovieGenres(List<String> mostAppearingMovieGenres) {
        this.mostAppearingMovieGenres = mostAppearingMovieGenres;
    }


    public List<String> getMostHiredActors() {
        return mostHiredActors;
    }
    public void setMostHiredActors(List<String> mostHiredActors) {
        this.mostHiredActors = mostHiredActors;
    }


    public List<String> getMaleFemaleRatioPercentage() {
        return maleFemaleRatioPercentage;
    }
    public void setMaleFemaleRatioPercentage(List<String> maleFemaleRatioPercentage) {
        this.maleFemaleRatioPercentage = maleFemaleRatioPercentage;
    }
}


