//package oop.pset1;
//
//import oop.pset1.controller.MovieDatabaseSummarizer;
//import oop.pset1.view.Summary;
//import oop.pset1.view.SummaryDisplayer;
//
//import java.util.Optional;
//
//public class Pset1Main {
//
//    public static void main(String[] args) {
//        MovieDatabaseSummarizer summarizer = new MovieDatabaseSummarizer();
//        SummaryDisplayer displayer = new SummaryDisplayer();
//
//        Optional<Summary> summary = summarizer.summarize();
//        if(summary.isPresent()){
//            displayer.display(summary.get());
//        } else {
//            displayer.display();
//        }
//    }
//}




//public class ReadingFile {
//
//    public static void main(String[] args) throws Exception {
//        String filePath = "src/oop/pset1/data/movies.csv";
//        List<String> lines = Files.readAllLines(Paths.get(filePath));
//
//        List<Film> films = lines.stream()
//                .skip(1)
//                .map(info -> info.split(";"))
//                .filter(strings -> strings.length == 24)
//                .map(ReadingFile::createNewFilm)
//                .sorted(Comparator.comparing(Film::getRating).reversed())
//                .limit(5)
//                .collect(Collectors.toList());
//
//        films.forEach(film -> System.out.println(film.getName() + " (" + film.getRating() + ")"));
//    }
//
//    private static Film createNewFilm(String[] strings) {
//        return new Film(strings[20], Float.parseFloat(strings[22]), getListOfGenres(strings[3]));
//    }
//
//    // [{'id': 28, 'name': 'Action'}, {'id': 80, 'name': 'Crime'}, {'id': 18, 'name': 'Drama'}, {'id': 53, 'name': 'Thriller'}]
//    private static List<String> getListOfGenres(String input) {
//        return Arrays.stream(input.replaceAll("'", "")
//                .replaceAll("]", "")
//                .replaceAll("\\[", "")
//                .replaceAll("}", "")
//                .replaceAll("\\{", "")
//                .split(",")).filter(s -> s.startsWith(" name"))
//                .map(s -> s.substring(" name: ".length()))
//                .collect(Collectors.toList());
//    }
//}