/**
 * @author Kristian Karlson
 */
public class Employee extends Person{
    private String employeeNo;

    public Employee(String name, int age, String[] address, String employeeNo) {
        super(name, age, address);
        this.employeeNo = employeeNo;
    }
}
