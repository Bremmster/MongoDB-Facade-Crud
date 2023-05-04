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
        // handles person and the inherited classes
        Document doc = person.toDoc();
        doc.remove("_id");
        var find = collection.find(doc);
        if (find.first() == null) collection.insertOne(doc);
    }

    public Person findById(String id) {
        Document doc = new Document("_id", new ObjectId(id));
        return Person.fromDoc(collection.find(doc).first());
    }

    public Person findByAge(int age) {
        Document doc = new Document("age", age);
        return Person.fromDoc(collection.find(doc).first());
    }
    public Person findByCustomerNo(String CustomerNo) {
        Document doc = new Document("CustomerNo", CustomerNo);
        return Person.fromDoc(collection.find(doc).first());
    }
    public Person findByEmployeeNo(String EmployeeNo) {
        Document doc = new Document("EmployeeNo", EmployeeNo);
        return Person.fromDoc(collection.find(doc).first());
    }

    public void delete(ObjectId id) {
        Document doc = new Document("_id", id);
        collection.deleteOne(doc);
    }

    public void update(String id, String newName, int newAge, String newAddress, int newZipcode, String newCity) {

        // Create a query that matches the document with the given _id value
        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));

        // Create an update that sets the value of a field to the new value
        BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("name", newName)
                .append("age", newAge)
                .append("address", newAddress)
                .append("zipcode", newZipcode)
                .append("city", newCity));

        // Call the updateOne method with the query and update objects
        UpdateResult result = collection.updateOne(query, update);

        // Print the number of documents updated
        System.out.println(result.getModifiedCount() + " document(s) updated.");

    }

    public List<Person> find(String name) {
        Document query = new Document("name", name);
        MongoCursor<Document> cursor = collection.find(query).iterator();

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
        BasicDBObject query = new BasicDBObject();
        query.put(type, new BasicDBObject("$regex", pattern));


        MongoCursor<Document> cursor = collection.find(query).iterator();

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
    public List<Person> findAll() {

        // Följande tre rader är framtagna med hjälp av chatGPT
        Pattern pattern = Pattern.compile(".*");
        BasicDBObject query = new BasicDBObject();
        query.put("name", new BasicDBObject("$regex", pattern));


        MongoCursor<Document> cursor = collection.find(query).iterator();

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

    public Person findName(String name) {
        Document query = new Document("name", name);

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
