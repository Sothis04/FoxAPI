package fr.sothis.api.database.redis;

import fr.sothis.api.database.sql.SQLAccess;
import org.redisson.api.RedissonClient;

import java.sql.Connection;
import java.util.HashMap;

public class RedisManager {

    private HashMap<String, RedisCredentials> redisDatabases = new HashMap<>();
    private HashMap<String, RedisAccess> accessDatabases = new HashMap<>();
    private HashMap<String, RedissonClient> connectionDatabases = new HashMap<>();

    public HashMap<String, RedisCredentials> getRedisDatabases() {
        return redisDatabases;
    }

    public void setRedisDatabases(HashMap<String, RedisCredentials> redisDatabases) {
        this.redisDatabases = redisDatabases;
    }

    public void addRedisDatabase(String key, RedisCredentials redisCredentials) {
        this.redisDatabases.put(key, redisCredentials);
    }

    public HashMap<String, RedisAccess> getAccessDatabases() {
        return accessDatabases;
    }

    public void setAccessDatabases(HashMap<String, RedisAccess> accessDatabases) {
        this.accessDatabases = accessDatabases;
    }

    public void addAccessDatabase(String key, RedisAccess connection) {
        this.accessDatabases.put(key, connection);
    }

    public void removeAccessDatabase(String key, RedisAccess connection) {
        this.accessDatabases.remove(key, connection);
    }

    public HashMap<String, RedissonClient> getConnectionDatabases() {
        return connectionDatabases;
    }

    public void setConnectionDatabases(HashMap<String, RedissonClient> connectionDatabases) {
        this.connectionDatabases = connectionDatabases;
    }

    public void addConnectionDatabase(String key, RedissonClient connection) {
        this.connectionDatabases.put(key, connection);
    }

    public void removeConnectionDatabase(String key, RedissonClient connection) {
        this.connectionDatabases.remove(key, connection);
    }
}
