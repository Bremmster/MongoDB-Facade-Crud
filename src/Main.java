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

<<<<<<< Updated upstream
        Person person = new Person("Kalle Anka", 32, "Blomstergatan 24", 31313, "Ankeborg");
        db.insertOne(person);
=======
        addData(db); // adds Person Customer and Employee to the database

        findNames(db); // finds names from members in database

        System.out.println("search by age\n" + db.findByAge(42));

        searchById(db); // search for specific id

        searchByField(db); // Search for a field i the database list all documents containing

        updatePerson(db);

        getAllPersons(db);

        deletePerson(db);


        db.close(); // close the database

    }

    private static void deletePerson(DbFacade db) {
        System.out.println("Delete Joakim von Anka");
        var person = db.findName("Joakim von Anka");
        db.delete(person.getDbId());
    }

    private static void getAllPersons(DbFacade db) {
        System.out.println("List of all persons in database");
        List<Person> persons = db.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private static void updatePerson(DbFacade db) {
        System.out.println("update Kalle Anka to Joakim von Anka");
        var person = db.findName("Kalle Anka");

        db.update(String.valueOf(person.getDbId()), "Joakim von Anka", 67, "Pengabingen 1", 12345, "Ankeborg");

    }

    private static void searchByField(DbFacade db) {
        System.out.println("Search for Customers: ");
        List<Person> customers = db.findType("customerNo");
        for (Person person : customers) {
            System.out.println(person);
        }
    }

    private static void searchById(DbFacade db) {
        System.out.println("Search by _id: ");
        System.out.println(db.findById("645388d63ab03d7e8b764daa")); // Finds Barry
    }

    private static void findNames(DbFacade db) {
        System.out.println("Search for different names: ");
        System.out.println(db.findName("Kalle Anka")); // Prints Kalle Anka as a Person
        System.out.println(db.findName("Larry")); // Prints Larry as a Customer
        System.out.println(db.findName("Barry")); // Prints Barry as an Employee
    }

    public static void addData(DbFacade db) {
        System.out.println("adding data");
        Person kalleAnka = new Person("Kalle Anka", 32, "Blomstergatan 24", 31313, "Ankeborg");
        db.insertOne(kalleAnka);
>>>>>>> Stashed changes

        Customer customer = new Customer("Larry", 24, "Road 1", 54312, "soCal", "234");
        db.insertOne(customer);

        Employee employee = new Employee("Barry", 42, "Outback 1", 2324, "Texas", "1");

        db.insertOne(employee);

        System.out.println(db.find("Kalle Anka"));
        System.out.println(db.find("Larry"));
        System.out.println(db.find("Barry"));

 
        db.close();
    }
}
