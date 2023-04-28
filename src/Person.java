/**
 * @author Kristian Karlson
 */
public class Person {

    // Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".

    private String name;
    private int age;
    private String[] address;
    private int zipcode;
    private String city;

    public Person(String name, int age, String[] address, int zipcode, String city) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.zipcode = zipcode;
        this.city = city;
    }
}