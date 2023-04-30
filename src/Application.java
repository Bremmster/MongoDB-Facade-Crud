import java.util.Scanner;

/**
 * @author Kristian Karlson
 */
public class Application {
    public void mainMenu() {
        // Switch with main menu

        switch (usrIntInput()) {
            case 1 ->
        }

    }

    public static int usrIntInput() {
        // try catch to get int
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("not a valid integer " + e.getMessage());
            }
        }
        return input;
    }
    public String usrInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.toString();
    }




}
