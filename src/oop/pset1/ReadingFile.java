package oop.pset1.data;

import com.sun.tools.internal.xjc.api.Mapping;
import com.sun.tools.javac.code.Type;
import oop.pset1.Cast;
import oop.pset1.models.Film;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ReadingFile {
    private static Map<Integer, Cast> casting = new HashMap<>();

    public static void main(String[] args) throws Exception {

        String moviesPath = "src/oop/pset1/data/movies.csv";
        List<String> moviesLines = Files.readAllLines(Paths.get(moviesPath));

        List<Film> films = moviesLines.stream()
                .skip(1)
                .map(info -> info.split( ";"))
                .filter(strings -> strings.length == 24)
                .map(ReadingFile::createNewFilm)
                .sorted(Comparator.comparing(Film::getRating).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nMOST RATED FILMS:\n");
        films.forEach(film -> System.out.println(film.getName() + " (" + film.getRating() + ")"));
        System.out.println("\n-----------------------------------------------\n");



        String actorsPath = "src/oop/pset1/data/actors.csv";
        List<String> actorslines = Files.readAllLines(Paths.get(actorsPath));


        List<String> castingLines = actorslines.stream()
                .skip(1)
                .map(actorsline -> actorsline.split(";")[0])
                .collect(Collectors.toList());


        for(int i = 0; i < 5 ; i++){
            String line = castingLines.get(i);
            System.out.println(line);
        }

        List<String> castParts = castingLines.stream()
                .map(actorsline -> actorsline.split("}, "))
                .collect(Collectors.toList());

        List<Cast> casting = castingLines.stream()
                .map(actorsline -> actorsline.split("}, "))
                .map(ReadingFile::createNewCast)
                .collect(Collectors.toList());
    }

    private static Film createNewFilm(String[] strings) {
        return new Film(strings[20], Float.parseFloat(strings[22]), getListOfGenres(strings[3]));
    }

    private static Cast createNewCast(String[] strings) {
        int id = Integer.parseInt(strings[4].split(": ")[1]);
        Cast result;
        if(casting.containsKey(id)) {
            result = casting.get(id);
            result.increaseCount();
        } else {
            result = new Cast(strings[5], id, Integer.parseInt(strings[3].split(": ")[1]));
            casting.put(id, result);
        }
        return result;
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