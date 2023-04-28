/**
 * @author Kristian Karlson
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        KeyReader keyReader = new KeyReader("api.key");
        System.out.println(keyReader.getKey("apiKey"));
    }
}
