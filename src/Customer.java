/**
 * @author Kristian Karlson
 */
public class Customer extends Person{
    private int customerNo;

    public Customer(String name, int age, String[] address, int zipcode, String city, int customerNo) {
        super(name, age, address, zipcode, city);
        this.customerNo = customerNo;
    }
}
