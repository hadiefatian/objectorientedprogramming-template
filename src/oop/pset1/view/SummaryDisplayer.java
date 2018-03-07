package oop.pset1.view;

public class SummaryDisplayer {
    public void display(Summary summary) {

        // Display 5 most rated movies
        System.out.println("\nFIVE TOP RATED MOVIES:\n");
        summary.getMostRatedFilms()
                .forEach(System.out::println);

        System.out.println("\n-----------------------------------------------\n");


        // Display 2 most appearing movie genres
        System.out.println("TWO MOST APPEARING MOVIE GENRES:\n");
        summary.getMostAppearingMovieGenres()
                .forEach(System.out::println);

        System.out.println("\n-----------------------------------------------\n");


        // Display 5 most hired actors
        System.out.println("FIVE MOST HIRED ACTORS:\n");
        summary.getMostHiredActors()
                .forEach(System.out::println);

        System.out.println("\n-----------------------------------------------\n");


        // Display % of male-female ratio (biggest % smallest)
        System.out.println("ACTORS MALE-FEMALE RATIO:\n");
        summary.getMaleFemaleRatioPercentage()
                .forEach(System.out::println);

        System.out.println("\n-----------------------------------------------\n");
    }

    public void display() {
        System.out.println("File Error!");
    }
}
