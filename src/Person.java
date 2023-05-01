import java.util.Arrays;

/**
 * @author Kristian Karlson
 */
public class Person {

    // Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".

    private String dbId;
    private String name;
    private int age;
    private String[] address;
    private int zipcode;
    private String city;
    public Person(String dbId, String name, int age, String[] address) {
        this.dbId = dbId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person(String name, int age, String[] address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        // todo print employee no or customer id
        // should it be solved here oc in respective class?

        return "Person{" +
               "dbId='" + dbId + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address=" + Arrays.toString(address) +

               '\'' +
               '}';
    }
}
