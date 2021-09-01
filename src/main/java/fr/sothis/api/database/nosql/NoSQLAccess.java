package fr.sothis.api.database.nosql;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class NoSQLAccess {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private NoSQLCredentials credentials;

    public NoSQLAccess(NoSQLCredentials credentials) {
        this.credentials = credentials;
    }

    public void initConnection() throws Exception {
        this.mongoClient = new MongoClient(
                new MongoClientURI("mongodb://" + credentials.getUser() + ":" + credentials.getPass() + "@" + credentials.getHost() + ":" + credentials.getPort())
        );
        this.database = this.mongoClient.getDatabase(credentials.getDbName());
    }

    public void endConnection() {
        this.mongoClient.close();
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}
