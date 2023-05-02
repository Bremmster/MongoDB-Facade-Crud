/**
 * @author Kristian Karlson
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // todo remove or move code
        KeyReader keyReader = new KeyReader("api.key");
        System.out.println(keyReader.getKey("apiKey"));
        System.out.println(keyReader.getKey("usrName"));

//        DbFacade db = new DbFacade();
        DbFacade.connect(keyReader);



    }
}
