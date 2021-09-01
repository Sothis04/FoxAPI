package fr.sothis.api.database.nosql;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import fr.sothis.api.database.sql.SQLAccess;
import fr.sothis.api.database.sql.SQLCredentials;

import java.sql.Connection;
import java.util.HashMap;

public class NoSQLManager {

    private HashMap<String, NoSQLCredentials> noSqlDatabases = new HashMap<>();
    private HashMap<String, NoSQLAccess> accessDatabases = new HashMap<>();
    private HashMap<String, MongoDatabase> connectionDatabases = new HashMap<>();
    private HashMap<String, MongoClient> clientDatabases = new HashMap<>();

    public HashMap<String, NoSQLCredentials> getNoSqlDatabases() {
        return noSqlDatabases;
    }

    public void setNoSqlDatabases(HashMap<String, NoSQLCredentials> noSqlDatabases) {
        this.noSqlDatabases = noSqlDatabases;
    }

    public void addNoSQLDatabase(String key, NoSQLCredentials noSqlCredentials) {
        this.noSqlDatabases.put(key, noSqlCredentials);
    }

    public HashMap<String, NoSQLAccess> getAccessDatabases() {
        return accessDatabases;
    }

    public void setAccessDatabases(HashMap<String, NoSQLAccess> accessDatabases) {
        this.accessDatabases = accessDatabases;
    }

    public void addAccessDatabase(String key, NoSQLAccess connection) {
        this.accessDatabases.put(key, connection);
    }

    public void removeAccessDatabase(String key, NoSQLAccess connection) {
        this.accessDatabases.remove(key, connection);
    }

    public HashMap<String, MongoDatabase> getConnectionDatabases() {
        return connectionDatabases;
    }

    public void setConnectionDatabases(HashMap<String, MongoDatabase> connectionDatabases) {
        this.connectionDatabases = connectionDatabases;
    }

    public void addConnectionDatabase(String key, MongoDatabase connection) {
        this.connectionDatabases.put(key, connection);
    }

    public void removeConnectionDatabase(String key, MongoDatabase connection) {
        this.connectionDatabases.remove(key, connection);
    }

    public HashMap<String, MongoClient> getClientDatabases() {
        return clientDatabases;
    }

    public void setClientDatabases(HashMap<String, MongoClient> clientDatabases) {
        this.clientDatabases = clientDatabases;
    }

    public void addClientDatabase(String key, MongoClient connection) {
        this.clientDatabases.put(key, connection);
    }

    public void removeClientDatabase(String key, MongoClient connection) {
        this.clientDatabases.remove(key, connection);
    }
}
