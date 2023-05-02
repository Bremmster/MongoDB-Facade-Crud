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
import org.bson.Document;


public class DbFacade {

    String collectionName;
    MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    private String connString;
    private String dbName;
    public DbFacade(String connString, String dbName, String collectionName) {
        this.connString = connString;
        this.dbName = dbName;
        this.collectionName = collectionName;
    }

    public void connect() {

        // Replace the placeholder with your Atlas connection string
        // String uri = "mongodb+srv://" + key.getKey("usrName") + ":" + key.getKey("apiKey") + "@cluster0.lb6kqnd.mongodb.net/?retryWrites=true&w=majority";

        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connString))
                .serverApi(serverApi)
                .build();


        this.mongoClient = MongoClients.create(settings);
        this.db = mongoClient.getDatabase(this.dbName);
        System.out.println("You successfully connected to MongoDB!");
        this.collection = db.getCollection(collectionName);
    }


    public void insertOne() {

    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
