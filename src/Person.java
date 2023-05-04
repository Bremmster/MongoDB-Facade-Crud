import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * @author Kristian Karlson
 */
public class Person {

    // Skapa en Java-modell för "Person" med följande egenskaper: "namn", "ålder" och "adress".

    @BsonProperty(value = "_id") // Makes it possible to follow the Java language naming convention for dbId
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Document toDoc() {
        return new Document("name", name)
                .append("age", age)
                .append("address", address)
                .append("zipcode", zipcode)
                .append("city", city)
                .append("_id", dbId);
    }

    public ObjectId getDbId() {
        return dbId;
    }

    public void setDbId(ObjectId dbId) {
        this.dbId = dbId;
    }

    @Override
    public String toString() {
        return "_id='" + dbId + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               ", zipcode=" + zipcode +
               ", city='" + city + '\'';
    }
}
