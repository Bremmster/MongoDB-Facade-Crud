import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * @author Kristian Karlson
 */
public class Customer extends Person{
    private String customerNo;

    public Customer() {
    }

    public Customer(ObjectId dbId, String name, int age, String address, int zipcode, String city, String customerNo) {
        super(dbId, name, age, address, zipcode, city);
        this.customerNo = customerNo;
    }

    public Customer(String name, int age, String address, int zipcode, String city, String customerNo) {
        super(name, age, address, zipcode, city);
        this.customerNo = customerNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Document toDoc() {
        return new Document("name", name)
                .append("age", age)
                .append("address", address)
                .append("zipcode", zipcode)
                .append("city", city)
                .append("customerNo", customerNo)
                .append("_id", dbId);
    }

    public static Customer fromDoc(Document document) {
        if (document == null) {
            return new Customer();
        }
        // ObjectId dbId, String name, int age, String address, int zipcode, String city, String customerNo
        return new Customer(
                document.getObjectId("_id"),
                document.getString("name"),
                document.getInteger("age"),
                document.getString("address"),
                document.getInteger("zipcode"),
                document.getString("city"),
                document.getString("customerNo"));
    }

    @Override
    public String toString() {
        return "_id='" + dbId + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               ", zipcode=" + zipcode +
               ", city='" + city + '\'' +
               ", customerNo='" + customerNo + '\'';
    }
}
