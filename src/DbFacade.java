/**
 * @author Kristian Karlson
 */

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class DbFacade {

    String collectionName;
    MongoClient mongoClient;
    private MongoDatabase db;
    private MongoCollection<Document> collection;
    private String connString;
    private String dbName;

    public DbFacade(String address, String dbName, String collectionName) {
        this.connString = address;
        this.dbName = dbName;
        this.collectionName = collectionName;
        connect();
    }

    public DbFacade(KeyReader key) {
        this.connString = "mongodb+srv://" + key.getKey("usrName") + ":" + key.getKey("apiKey") + "@" + key.getKey("dbA");
        this.dbName = "People";
        this.collectionName = "Persons";
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
        // handles person and the inherited classes
        Document doc = person.toDoc();
        doc.remove("_id");
        var find = collection.find(doc);
        if (find.first() == null) collection.insertOne(doc);
    }

    public Person findName(String name) {
        Document query = new Document("name", name);
        return getPerson(query);
    }

    public Person findById(String id) {
        Document query = new Document("_id", new ObjectId(id));
        return getPerson(query);
    }

    public Person findByAge(int age) {
        Document query = new Document("age", age);
        return getPerson(query);
    }

    public Person findByCustomerNo(String CustomerNo) {
        Document query = new Document("CustomerNo", CustomerNo);
        return getPerson(query);
    }

    public Person findByEmployeeNo(String EmployeeNo) {
        Document query = new Document("EmployeeNo", EmployeeNo);
        return getPerson(query);
    }

    public void delete(ObjectId id) {
        Document doc = new Document("_id", id);
        collection.deleteOne(doc);
    }

    public void update(String id, Person person) {

        // Create a query that matches the document with the given _id value
        Document query = new Document("_id", new ObjectId(id));

        // Create an update that sets the value of a field to the new value
        Document update = new Document("$set", new BasicDBObject("name", person.getName())
                .append("age", person.age)
                .append("address", person.getAddress())
                .append("zipcode", person.getZipcode())
                .append("city", person.getCity()));
                // Customer or Employee number will never change
        // Call the updateOne method with the query and update objects
        UpdateResult result = collection.updateOne(query, update);

        // Print the number of documents updated
        System.out.println(result.getModifiedCount() + " document(s) updated.");

    }

    public List<Person> find(String name) {
        Document query = new Document("name", name);
        return getPeople(collection.find(query));
    }

    private ArrayList<Person> getPeople(FindIterable<Document> collection) {

        MongoCursor<Document> cursor = collection.iterator();

        ArrayList<Person> people = new ArrayList<>();

        while (cursor.hasNext()) {
            Document document = cursor.next();
            if (document.containsKey("customerNo")) {
                people.add(Customer.fromDoc(document));
            } else if (document.containsKey("employeeNo")) {
                people.add(Employee.fromDoc(document));
            } else {
                people.add(Person.fromDoc(document));
            }
        }
        return people;
    }

    public List<Person> findType(String type) {

        // Följande tre rader är framtagna med hjälp av chatGPT
        Pattern pattern = Pattern.compile(".*");
        Document query = new Document();
        query.put(type, new Document("$regex", pattern));
        return getPeople(collection.find(query));
    }

    public List<Person> findAll() {

        // Följande tre rader är framtagna med hjälp av chatGPT
        Pattern pattern = Pattern.compile(".*");
        Document query = new Document();
        query.put("name", new Document("$regex", pattern));
        return getPeople(collection.find(query));
    }

    private Person getPerson(Document query) {

        for (Document document : collection.find(query)) {
            if (document.containsKey("customerNo")) {
                return Customer.fromDoc(document);
            } else if (document.containsKey("employeeNo")) {
                return Employee.fromDoc(document);
            } else {
                return Person.fromDoc(document);
            }
        }
        return null;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}
