import java.util.ArrayList;

public class SimpleMovie {
    private String title;
    private String actorData;
    private ArrayList<String> actors;
    public SimpleMovie(String t, String a) {
        title = t;
        actorData = a;
        actors = new ArrayList<String>();
        String[] temporaryActors = actorData.split(":");
        for (int i = 0; i < temporaryActors.length; i++) {
            actors.add(temporaryActors[i]);
        }

    }
    public String getTitle()
    {
        return title;
    }

    public ArrayList<String> getActors()
    {
        return actors;
    }
    public String toString() {
        return "Title: " + title + "\n" + "Actors: " + actors + "\n";
    }
}