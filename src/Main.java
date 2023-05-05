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

        System.out.println("\nsearch by age\n" + db.findByAge(42));

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
        System.out.println("\nList of all persons in database");
        List<Person> persons = db.findAll();
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private static void updatePerson(DbFacade db) {
        var person = db.findName("Kalle Anka");
        System.out.println("\nupdate Kalle Anka to Joakim von Anka. Before update\n" + person.toString());

        person.setName("Joakim von Anka");
        person.setAge(67);
        person.setAddress("Pengabingen 1");
        person.setZipcode(12345);
        person.setCity("Ankeborg");

        db.update(String.valueOf(person.getDbId()), person);
        System.out.println("After update\n" + db.findById(person.getDbId().toString()));
    }

    private static void searchByField(DbFacade db) {
        System.out.println("\nSearch for Customers: ");
        List<Person> customers = db.findType("customerNo");
        for (Person person : customers) {
            System.out.println(person);
        }
    }

    private static void searchById(DbFacade db) {
        System.out.println("\nSearch by _id: ");
        System.out.println(db.findById("645388d63ab03d7e8b764daa")); // Finds Barry
    }

    private static void findNames(DbFacade db) {
        System.out.println("\nSearch for different names: ");
        System.out.println(db.findName("Kalle Anka")); // Prints Kalle Anka as a Person
        System.out.println(db.findName("Larry")); // Prints Larry as a Customer
        System.out.println(db.findName("Barry")); // Prints Barry as an Employee
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

