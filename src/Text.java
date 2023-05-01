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
        System.out.println("| 1) Create person                      |");
        System.out.println("| 2) Read person                        |");
        System.out.println("| 3) Update person                      |");
        System.out.println("| 4) Delete person                      |");
        System.out.println("| 5) List persons                       |");
        System.out.println("| 7) Add sample persons to Database     |");
        System.out.println("| 9) Exit                               |");
        System.out.println("+---------------------------------------+");
        System.out.print("Ange alternativ: ");
    }

    public static void personType() {
        System.out.println("Type\n1: Employee\n2: Customer");
        System.out.print("Choose: ");
    }
    public static void addPerson() {
        System.out.println("add new person to database");
        System.out.println("String name, int age, Sting street adress, String house number, int zipcode, String city, String employee number || Customer number");
    }
}
