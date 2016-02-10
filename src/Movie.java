import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/10/16.
 */
public class Movie {
    private String title;
    private int stars;
    private String genre;
    private boolean isPartofSeries;
    private boolean wouldRecommend;

    private Movie() {
    }

    private Movie(String title, int stars, String genre, boolean isPartofSeries, boolean wouldRecommend) {
        this.title = title;
        this.stars = stars;
        this.genre = genre;
        this.isPartofSeries = isPartofSeries;
        this.wouldRecommend = wouldRecommend;
    }

    public static Movie createMovie() {

        System.out.println("What is the title of the movie?");
        String title = Main.scanner.nextLine();
        System.out.println("How many stars would you rate this movie? [0-5]");
        int stars = Integer.valueOf(Main.scanner.nextLine());
        System.out.println("What is the genre of the movie?");
        String genre = Main.scanner.nextLine();
        System.out.println("Is this movie part of a series of movies?");
        boolean isPartOfSeries = Boolean.valueOf(Main.scanner.nextLine());
        System.out.println("Would you recommend this movie to others?");
        boolean wouldRecommend = Boolean.valueOf(Main.scanner.nextLine());
        return new Movie(title, stars, genre, isPartOfSeries, wouldRecommend);
    }

    public static void saveMovie(Movie movie) throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(movie);
        File savemovie = new File("savemovie.json");
        FileWriter fw = new FileWriter(savemovie);
        fw.write(json);
        fw.close();
        System.out.println("Movie stats saved.");
        System.out.println("Here are your movie stats:");
    }

    public static Movie loadMovie() throws FileNotFoundException {
        File f = new File("savemovie.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();

        JsonParser movie = new JsonParser();
        return movie.parse(contents, Movie.class);
    }

    public static void print(Movie movie){
        System.out.printf("Title: %s\n", movie.title);
        System.out.printf("Rating: %d Stars\n", movie.stars);
        System.out.printf("Genre: %s\n", movie.genre);
        System.out.printf("Part of a Series?: %b\n", movie.isPartofSeries);
        System.out.printf("Would you Recommend this Movie?: %b\n", movie.wouldRecommend);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPartofSeries(boolean partofSeries) {
        isPartofSeries = partofSeries;
    }

    public void setWouldRecommend(boolean wouldRecommend) {
        this.wouldRecommend = wouldRecommend;
    }

    public String getTitle() {
        return title;
    }

    public int getStars() {
        return stars;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isPartofSeries() {
        return isPartofSeries;
    }

    public boolean isWouldRecommend() {
        return wouldRecommend;
    }
}
