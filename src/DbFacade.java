/**
 * @author Kristian Karlson
 */

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import com.mongodb.client.model.IndexOptions;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


public class DbFacade {

    String collectionName;
    MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    private String connString;
    private String dbName;

    public DbFacade(KeyReader key, String dbName, String collectionName) {
        this.connString = "mongodb+srv://" + key.getKey("usrName") + ":" + key.getKey("apiKey") + "@cluster0.lb6kqnd.mongodb.net/?retryWrites=true&w=majority";
        this.dbName = dbName;
        this.collectionName = collectionName;
        connect();
    }
    public DbFacade(KeyReader key) {
        this.connString = "mongodb+srv://" + key.getKey("usrName") + ":" + key.getKey("apiKey") + "@cluster0.lb6kqnd.mongodb.net/?retryWrites=true&w=majority";
        this.dbName = "Person";
        this.collectionName = "public_person";
        connect();
    }

    public void connect() {

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connString))
                .serverApi(serverApi)
                .build();

        try {
            this.mongoClient = MongoClients.create(settings);
            this.db = mongoClient.getDatabase(this.dbName);
            System.out.println("You successfully connected to MongoDB!");
            this.collection = db.getCollection(collectionName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createIndex() {
        collection.createIndex(new Document("name", 1), new IndexOptions().unique(false));
    }

    public void insertOne(Person person) {

        Document doc = person.toDoc();
        doc.remove("_id");
        var find = collection.find(doc);
        if (find.first() == null) collection.insertOne(doc);
    }

    public Person findById(String id) {
        Document doc = new Document("id", id);
        Document search = collection.find(doc).first();

        return Person.fromDoc(search);
    }
    public void delete(String id) {
        Document doc = new Document("id", id);
        collection.deleteOne(doc);
    }

    public List<Person> find(String name) {
        Document query = new Document("name", name);
        MongoCursor<Document> cursor = collection.find(query).iterator();

        ArrayList<Person> people = new ArrayList<>();

        result.forEach(person -> people.add(Person.fromDoc(person)));

        return people;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
