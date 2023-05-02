/**
 * @author Kristian Karlson
 */
public class Application {

/*    public void mainMenu() {
        // Switch with main menu
        while (true) {
            switch (UsrInput.Int()) {
                case 1 -> addPerson();
                case 2 -> readPerson();
                case 3 -> updatePerson();
                case 4 -> deletePerson();
                case 5 -> listPersons();
                case 7 -> addSamples();
                case 9 -> {
                    return;
                }
            }
        }
    } */

    private void addPerson() {
        Text.addPerson();
        // "String name, int age, Sting street adress, String house number, int zipcode, String city, String employee number || Customer number"
        String name = UsrInput.String();
        int age = UsrInput.Int();
        String street = UsrInput.String();
        String houseNo = UsrInput.String();
        int zipcode = UsrInput.Int();
        String city = UsrInput.String();

        String[] adress = {street, houseNo, Integer.toString(zipcode), city};

        Text.personType();

        switch (UsrInput.Int()) {
            case 1 -> {
                String employeeNo = UsrInput.String();

                Person employee = new Employee(name, age, adress, employeeNo);
            }
            case 2 -> {
                String customerNo = UsrInput.String();
                Person customer = new Customer(name, age, adress, customerNo);
            }
        }
        // todo send object to DB
    }
}
