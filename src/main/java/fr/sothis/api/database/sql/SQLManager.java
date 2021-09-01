package fr.sothis.api.database.sql;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.util.HashMap;

public class SQLManager {

    private HashMap<String, SQLCredentials> sqlDatabases = new HashMap<>();
    private HashMap<String, SQLAccess> accessDatabases = new HashMap<>();
    private HashMap<String, Connection> connectionDatabases = new HashMap<>();

    public HashMap<String, SQLCredentials> getSqlDatabases() {
        return sqlDatabases;
    }

    public void setSqlDatabases(HashMap<String, SQLCredentials> sqlDatabases) {
        this.sqlDatabases = sqlDatabases;
    }

    public void addSQLDatabase(String key, SQLCredentials sqlCredentials) {
        this.sqlDatabases.put(key, sqlCredentials);
    }

    public HashMap<String, SQLAccess> getAccessDatabases() {
        return accessDatabases;
    }

    public void setAccessDatabases(HashMap<String, SQLAccess> accessDatabases) {
        this.accessDatabases = accessDatabases;
    }

    public void addAccessDatabase(String key, SQLAccess connection) {
        this.accessDatabases.put(key, connection);
    }

    public void removeAccessDatabase(String key, SQLAccess connection) {
        this.accessDatabases.remove(key, connection);
    }

    public HashMap<String, Connection> getConnectionDatabases() {
        return connectionDatabases;
    }

    public void setConnectionDatabases(HashMap<String, Connection> connectionDatabases) {
        this.connectionDatabases = connectionDatabases;
    }

    public void addConnectionDatabase(String key, Connection connection) {
        this.connectionDatabases.put(key, connection);
    }

    public void removeConnectionDatabase(String key, Connection connection) {
        this.connectionDatabases.remove(key, connection);
    }
}
