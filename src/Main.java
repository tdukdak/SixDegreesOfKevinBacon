import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
        CostarDataBaseBuilder.createLevel1(movies);
        ArrayList<SimpleMovie> baconMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_movies");
        ArrayList<String> baconCostars = MovieDatabaseBuilder.getActorDB("src/bacon_costars");
        ArrayList<SimpleMovie> baconCostarMovies = MovieDatabaseBuilder.getMovieDB("src/bacon_costars_movies");

        Scanner s = new Scanner(System.in);
        System.out.print("Enter an actor or actress: ");
        String actor = s.nextLine();
        Boolean contains = false;
        String printedMessage = "Selected actor/actress): " + actor + "\n" + actor;
        for (SimpleMovie bm : baconMovies) {
            if (bm.getActors().indexOf(actor) != -1) {
                System.out.println("Selected actor/actress: " + actor);
                System.out.println(actor + " --> " + bm.getTitle() + " --> Kevin Bacon" + "\n bacon number " + 1);
                contains = true;
                break;
            }
        }
        if (!contains) {
            CostarDataBaseBuilder.createActorMovies(movies, actor);
            ArrayList<String> actorsCostars = MovieDatabaseBuilder.getActorDB("src/actor_costars");
            ArrayList<SimpleMovie> actorsMovies = MovieDatabaseBuilder.getMovieDB("src/actor_movies");
            for (String actorCostar : actorsCostars){
                String secondActor = actorCostar;
                for (SimpleMovie movie : baconCostarMovies){
                    String middleMovie = movie.getTitle();
                    if (movie.getActors().contains(actorCostar)){
                        String firstMovie = "";
                        for (SimpleMovie actMovie : actorsMovies) {
                            if (actMovie.getActors().contains(actorCostar)) {
                                firstMovie = actMovie.getTitle();
                            }
                        }
                        for (String baconCostar : movie.getActors()) {
                            if (baconCostars.contains(baconCostar)) {
                                String middleActor = baconCostar;
                                for (SimpleMovie baconMovie : baconMovies) {
                                    if (baconMovie.getActors().contains(middleActor)) {
                                        String finalMovie = baconMovie.getTitle();
                                        System.out.println("Selected actor/actress: " + actor);
                                        System.out.println(actor + " --> " + firstMovie + " --> " + secondActor + " --> " + middleMovie + " --> " + middleActor + " --> " + finalMovie + " --> Kevin Bacon" + "\n bacon number " + 3);
                                        contains = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
                if (contains == true) {
                    break;
                }
            }
            if (!contains) {
                for (SimpleMovie movie : baconCostarMovies) {
                    if (movie.getActors().contains(actor)) {
                        String finalMovie = movie.getTitle();
                        for (String currActor : movie.getActors()) {
                            if (baconCostars.contains(currActor)) {
                                String secondActor = currActor;
                                for (SimpleMovie baconMovie : baconMovies) {
                                    if (baconMovie.getActors().contains(currActor)) {
                                        String firstMovie = baconMovie.getTitle();
                                        System.out.println("Selected actor/actress: " + actor);
                                        System.out.println(actor + ">>>" + firstMovie + ">>>" + secondActor + ">>>" + finalMovie + ">>>Kevin Bacon" + "\nBacon #: " + 2);
                                        contains = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}