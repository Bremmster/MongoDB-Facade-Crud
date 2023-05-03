import org.bson.Document;

/**
 * @author Kristian Karlson
 */
public class Person {

    // Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".

    private String _id;
    private String name;
    private int age;
    private String address;
    private int zipcode;
    private String city;

    public Person(String _id, String name, int age, String address, int zipcode, String city) {
        this._id = _id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Person(String name, int age, String address, int zipcode, String city) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Person() {
    }

    public static Person fromDoc(Document document) {
        if (document == null) {
            return new Person();
        }
        return new Person(
                document.getString("name"),
                document.getInteger("age"),
                document.getString("streetaddress"),
                document.getInteger("zipcode"),
                document.getString("city"));

    }

    @Override
    public String toString() {
        return super.toString();
    }

    // todo print employee no or customer id
        // should it be solved here oc in respective class?
        // (Person instanceof Employee) ? "" : "";



}
