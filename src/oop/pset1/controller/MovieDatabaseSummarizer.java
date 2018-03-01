package oop.pset1.controller;

import oop.pset1.model.Actor;
import oop.pset1.model.Movie;
import oop.pset1.parser.ActorParser;
import oop.pset1.parser.MovieParser;
import oop.pset1.view.Summary;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieDatabaseSummarizer {

    public Optional<Summary> summarize() {


        //--------------------------- Movie Summary --------------------------//

        List<Movie> movies = new MovieParser().getMovies();

        // 5 most rated movies
        List<String> mostRatedFilms = movies.stream()
                .sorted((e1, e2) -> e2.getRating().compareTo(e1.getRating()))
                .limit(5)
                .map(e -> e.getTitle() + " (" + e.getRating() + ")")
                .collect(Collectors.toList());


        // 2 most appearing movie genres
        Map<String, Long> appearances = movies.stream()
                .map(genre -> genre.getGenre())
                .flatMap(genre -> genre.stream())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> mostAppearingMovieGenres = appearances.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(2)
                .map(e -> e.getKey() + " (" + e.getValue() + ")")
                .collect(Collectors.toList());


        //--------------------------- Actor Summary --------------------------//

        List<Actor> actors = new ActorParser().getActors();

        // 5 most hired actors
        Map<String, Long> hired = actors.stream()
                .map(actor -> actor.getName())
                //.flatMap(name -> name.stream())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> mostHiredActors = hired.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .map(e -> e.getKey() + " (" + e.getValue() + ")")
                .collect(Collectors.toList());


        // % of male-female ratio (biggest % smallest)
        Map<String, Long> gender = actors.stream()
                .map(actor -> actor.getGender())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> maleFemaleRatioPercentage = gender.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " (" + ((double) e.getValue())/ actors.size() * 100 + "%)")
                .collect(Collectors.toList());


        //------------------------- The Whole Summary ------------------------//

        Summary summary = new Summary();
        summary.setMostRatedFilms(mostRatedFilms);
        summary.setMostAppearingMovieGenres(mostAppearingMovieGenres);
        summary.setMostHiredActors(mostHiredActors);
        summary.setMaleFemaleRatioPercentage(maleFemaleRatioPercentage);
        return Optional.of(summary);

    }
}




