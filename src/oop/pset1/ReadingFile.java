package oop.pset1.data;

import com.sun.tools.internal.xjc.api.Mapping;
import com.sun.tools.javac.code.Type;
import oop.pset1.models.Film;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingFile {

    public static void main(String[] args) throws Exception {
        String filePath = "src/oop/pset1/data/movies.csv";
        List<String> lines = Files.readAllLines(Paths.get(filePath));

        List<Film> films = lines.stream()
                .skip(1)
                .map(info -> info.split(";"))
                .filter(strings -> strings.length == 24)
                .map(ReadingFile::createNewFilm)
                .sorted(Comparator.comparing(Film::getRating).reversed())
                .limit(5)
                .collect(Collectors.toList());

        films.forEach(film -> System.out.println(film.getName() + " (" + film.getRating() + ")"));
    }

    private static Film createNewFilm(String[] strings) {
        return new Film(strings[20], Float.parseFloat(strings[22]), getListOfGenres(strings[3]));
    }

    // [{'id': 28, 'name': 'Action'}, {'id': 80, 'name': 'Crime'}, {'id': 18, 'name': 'Drama'}, {'id': 53, 'name': 'Thriller'}]
    private static List<String> getListOfGenres(String input) {
        return Arrays.stream(input.replaceAll("'", "")
                .replaceAll("]", "")
                .replaceAll("\\[", "")
                .replaceAll("}", "")
                .replaceAll("\\{", "")
                .split(",")).filter(s -> s.startsWith(" name"))
                .map(s -> s.substring(" name: ".length()))
                .collect(Collectors.toList());
    }
}