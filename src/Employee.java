/**
 * @author Kristian Karlson
 */
public class Employee extends Person{
    private int employeeNo;

    public Employee(String name, int age, String[] address, int zipcode, String city,int employeeNo) {
        super(name, age, address, zipcode, city);
        this.employeeNo = employeeNo;
    }
}
