/**
 * @author Kristian Karlson
 */

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import org.bson.Document;


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

    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
