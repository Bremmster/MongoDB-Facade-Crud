import java.util.Scanner;

/**
 * @author Kristian Karlson
 */
public class UsrInput {


    public static int Int() {
        // try catch to get int
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println("not a valid integer " + e.getMessage());
            }
        }
    }
}
