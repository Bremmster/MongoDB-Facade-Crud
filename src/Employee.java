import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * @author Kristian Karlson
 */
public class Employee extends Person {
    private String employeeNo;

    public Employee(ObjectId _id, String name, int age, String address, int zipcode, String city, String employeeNo) {
        super(_id, name, age, address, zipcode, city);
        this.employeeNo = employeeNo;
    }

    public Employee(String name, int age, String address, int zipcode, String city, String employeeNo) {
        super(name, age, address, zipcode, city);
        this.employeeNo = employeeNo;
    }

    public Employee() {

    }


    public Document toDoc() {
        return new Document("name", name)
                .append("age", age)
                .append("address", address)
                .append("zipcode", zipcode)
                .append("city", city)
                .append("employeeNo", employeeNo)
                .append("_id", dbId);
    }
    public static Employee fromDoc(Document document) {
        if (document == null) {
            return new Employee();
        }
        // ObjectId dbId, String name, int age, String address, int zipcode, String city, String customerNo
        return new Employee(
                document.getObjectId("_id"),
                document.getString("name"),
                document.getInteger("age"),
                document.getString("address"),
                document.getInteger("zipcode"),
                document.getString("city"),
                document.getString("employeeNo"));
    }

    @Override
    public String toString() {
        return "employeeNo='" + employeeNo + '\'' +
               ", _id='" + dbId + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               ", zipcode=" + zipcode +
               ", city='" + city + '\'' +
               '}';
    }
}
