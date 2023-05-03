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


    public Document toDoc() {
        return new Document("name", name)
                .append("age", age)
                .append("address", address)
                .append("zipcode", zipcode)
                .append("city", city)
                .append("employeeNo", employeeNo)
                .append("_id", _id);
    }

    @Override
    public String toString() {
        return "employeeNo='" + employeeNo + '\'' +
               ", _id='" + _id + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               ", zipcode=" + zipcode +
               ", city='" + city + '\'' +
               '}';
    }
}
