import java.util.Scanner;

/**
 * Created by PiratePowWow on 2/10/16.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Welcome to The Force Awakens Movie stats");

        try {
            Movie.loadMovie();
            listOptions();
        }
        catch (Exception e) {
            System.out.println("No saved information found, generating new movie stat file:");
        }





    }

    public static void listOptions(){
        String selection = scanner.nextLine();
        switch (selection){
            case "1":
                break;
            case "2":
                break;
            default:
                break;

        }

    }

}
