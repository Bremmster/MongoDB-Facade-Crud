import java.io.FileInputStream;
import java.util.Properties;

public class KeyReader {

    Properties property;

    public KeyReader(String file) { //
        property = new Properties(); //the variable properties can store an assortement of key-value pairs.

        try {
            FileInputStream input = new FileInputStream(file); //öppnar filen
            property.load(input); //load läser av filen
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getAPIKey() {
        return property.getProperty("apiKey");
    } //läser raden i txt filen apikey

    public String getKey(String key) {
        return property.getProperty(key);
    } // returnerar det som finns txt filen efter = tecknet "nyckeln"
}
