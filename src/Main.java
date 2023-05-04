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

        Person person = new Person("Kalle Anka", 32, "Blomstergatan 24", 31313, "Ankeborg");
        db.insertOne(person);
        Customer customer = new Customer("Larry", 24, "Road 1", 54312, "soCal", "234");
        db.insertOne(customer);
        Employee employee = new Employee("Barry", 42, "Outback 1", 2324, "Texas", "1");

        db.insertOne(employee);

        System.out.println(db.find("Kalle Anka")); // Prints Kalle Anka as a Person
        System.out.println(db.find("Larry")); // Prints Larry as a Customer
        System.out.println(db.find("Barry")); // Prints Barry as an Employee

        System.out.println(db.findById("64525f7c83034f6c27972d93")); // Finds Barry



        db.delete(person.getDbId()); // removes kalle anka from database

 
        db.close();
    }
}
