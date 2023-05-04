import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * @author Kristian Karlson
 */
public class Person {

    // Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".

    @BsonProperty(value = "_id")
    protected ObjectId dbId;
    protected String name;
    protected int age;
    protected String address;
    protected int zipcode;
    protected String city;

    public Person(ObjectId dbId, String name, int age, String address, int zipcode, String city) {
        this.dbId = dbId;
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
                document.getObjectId("_id"),
                document.getString("name"),
                document.getInteger("age"),
                document.getString("address"),
                document.getInteger("zipcode"),
                document.getString("city"));

    }

    public static Person fromJson(String json) {
        Document doc = org.bson.Document.parse(json);
        return fromDoc(doc);
    }

    public Document toDoc() {
        return new Document("name", name)
                .append("age", age)
                .append("address", address)
                .append("zipcode", zipcode)
                .append("city", city)
                .append("_id", dbId);
    }

    public String toJson() {
        return toDoc().toJson();
    }

    // todo print employee no or customer id
    // should it be solved here oc in respective class?
    // (Person instanceof Employee) ? "" : "";


    /*@Override
    public String toString() {
        return "{_id='" + _id + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               ", zipcode=" + zipcode +
               ", city='" + city + '\'' +
               '}';
    }*/
}
