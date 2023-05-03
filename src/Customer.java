import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * @author Kristian Karlson
 */
public class Customer extends Person{
    private String customerNo;

    public Customer(ObjectId _id, String name, int age, String address, int zipcode, String city, String customerNo) {
        super(_id, name, age, address, zipcode, city);
        this.customerNo = customerNo;
    }

    public Customer(String name, int age, String address, int zipcode, String city, String customerNo) {
        super(name, age, address, zipcode, city);
        this.customerNo = customerNo;
    }
    public Document toDoc() {
        return new Document("name", name)
                .append("age", age)
                .append("address", address)
                .append("zipcode", zipcode)
                .append("city", city)
                .append("customerNo", customerNo)
                .append("_id", _id);
    }

    @Override
    public String toString() {
        return "customerNo='" + customerNo + '\'' +
               ", _id='" + _id + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               ", zipcode=" + zipcode +
               ", city='" + city + '\'' +
               '}';
    }
}
