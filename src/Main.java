import java.io.IOException;
import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/10/16.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static Movie movie = new Movie();

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to The Force Awakens Movie stats. Here are your stats:");

        while (true) {
            try {
                movie = Movie.loadMovie();
                Movie.print(movie);
                update();
            } catch (Exception e) {
                System.out.println("No saved information found, generating new movie stat file:");
                movie = Movie.createMovie();
            }
            Movie.saveMovie(movie);
        }
    }
    public static void update(){
        System.out.println("Would you like to update your movie stats?");
        String selection = scanner.nextLine();
        if (selection.equalsIgnoreCase("y")){
            movie = Movie.createMovie();
        }
        else{
            System.exit(0);
        }
    }

}
