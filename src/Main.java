import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kristian Karlson
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello MongoDB!");

        Logger.getLogger("org.mongodb.driver")
                .setLevel(Level.SEVERE);

        DbFacade db = new DbFacade(new KeyReader("api.key"));

        addData(db); // adds Person Customer and Employee to the database

        findNames(db); // finds names from members in database

        searchById(db); // search for specific id

        searchByField(db); // Search for a field i the database list all documents containing

        updatePerson(db);

        System.out.println("Delete Kalle Anka uses Search by _id");

        System.out.println(kalleAnka.getDbId()); // removes kalle anka from database
        System.out.println(customer.getDbId());
        System.out.println(employee.getDbId());

        db.close(); // close the database

    }

    private static void updatePerson(DbFacade db) {
        var update = db.findName("Kalle Anka").;
        update
    }

    private static void searchByField(DbFacade db) {
        System.out.println("Search for Customers: ");
        List<Person> customers = db.findType("customerNo");
        for (Person cust : customers) {
            System.out.println(cust);
        }
    }

    private static void searchById(DbFacade db) {
        System.out.println("Search by _id: ");
        System.out.println(db.findById("645388d63ab03d7e8b764daa")); // Finds Barry
    }

    private static void findNames(DbFacade db) {
        System.out.println("Search for different names: ");
        System.out.println(db.find("Kalle Anka")); // Prints Kalle Anka as a Person
        System.out.println(db.find("Larry")); // Prints Larry as a Customer
        System.out.println(db.find("Barry")); // Prints Barry as an Employee
    }

    public static void addData(DbFacade db) {
        System.out.println("adding data");
        Person kalleAnka = new Person("Kalle Anka", 32, "Blomstergatan 24", 31313, "Ankeborg");
        db.insertOne(kalleAnka);

        Customer customer = new Customer("Larry", 24, "Road 1", 54312, "soCal", "234");
        db.insertOne(customer);

        Customer customer1 = new Customer("Doris", 54, "Street 99", 43131, "New York", "543");
        db.insertOne(customer1);

        Employee employee = new Employee("Barry", 42, "Outback 1", 2324, "Texas", "1");
        db.insertOne(employee);
    }
}

