package oop.pset1.parser;

import oop.pset1.model.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieParser {

    public List<Movie> getMovies() {
        String filePath = "src/oop/pset1/data/movies.csv";
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return lines.skip(1)
                    .map(line -> line.split(";"))
                    .filter(columns -> columns.length >= 23)
                    .map(toMovie())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Function<String[], Movie> toMovie() {
        return columns -> {
            Movie movie = new Movie();
            movie.setTitle(columns[8]);
            movie.setRating(Double.parseDouble(columns[22]));
            movie.setGenre(toGenre(columns[3]));
            return movie;
        };
    }

    private List<String> toGenre(String jsonGenres) {
        return Stream.of(jsonGenres.split("},"))
                .map(e -> e.replaceAll("\\[", ""))
                .map(e -> e.replaceAll("]", ""))
                .map(e -> e.replaceAll("\\{", ""))
                .map(e -> e.replaceAll("}", ""))
                .map(jsonGenre -> jsonGenre.split(", "))
                .flatMap(columns -> Stream.of(columns))
                .filter(column -> column.contains("'name': "))
                .map(genre -> genre.replaceAll("'name': ", ""))
                .map(genre -> genre.replaceAll("'", ""))
                .map(genre -> genre.trim())
                .collect(Collectors.toList());

    }
}
