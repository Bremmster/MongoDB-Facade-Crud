/**
 * @author Kristian Karlson
 */
public class Customer extends Person{
    private String customerNo;

    public Customer(String name, int age, String[] address, String customerNo) {
        super(name, age, address);
        this.customerNo = customerNo;
    }
}
