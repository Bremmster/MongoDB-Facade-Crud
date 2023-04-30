/**
 * @author Kristian Karlson
 */
public class Text {

    public static void welcome() {
        System.out.println("Welcome to MongoDB crud");
    }
    public static void menu() {
        System.out.println("+---------------------------------------+");
        System.out.println("| MongoDB crud main menu                |");
        System.out.println("+---------------------------------------+");
        System.out.println("| 1) Create person                       |");
        System.out.println("| 2) Read person                        |");
        System.out.println("| 3) Update person                      |");
        System.out.println("| 4) Delete person                      |");
        System.out.println("| 5) List persons                       |");
        System.out.println("| 9) Exit                               |");
        System.out.println("+---------------------------------------+");
        System.out.print("Ange alternativ: ");
    }
}
