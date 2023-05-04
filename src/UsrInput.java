import java.util.Scanner;

/**
 * @author Kristian Karlson
 */
public class UsrInput {


    public static String String() {
        Scanner scanner = new Scanner(System.in);
        return scanner.toString();
    }
    public static int Int() {
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
}
