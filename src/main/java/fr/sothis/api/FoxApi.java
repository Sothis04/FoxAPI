package fr.sothis.api;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import fr.sothis.api.database.Credentials;
import fr.sothis.api.database.Database;
import fr.sothis.api.database.DatabaseManager;
import fr.sothis.api.database.nosql.NoSQLManager;
import fr.sothis.api.database.redis.RedisManager;
import fr.sothis.api.database.sql.SQLManager;
import fr.sothis.api.database.sql.SQLMethod;
import fr.sothis.api.menus.MenuManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.sql.Connection;
import java.util.HashMap;
import java.util.function.Consumer;

public class FoxApi {

    public static FoxApi INSTANCE;
    private Server server;
    private DatabaseManager databaseManager;
    private SQLManager sqlManager;
    private NoSQLManager noSQLManager;
    private RedisManager redisManager;
    private HashMap<String, Consumer<HikariConfig>> consumerHikari = new HashMap<>();
    private HashMap<String, Consumer<Config>> consumerRedisson = new HashMap<>();
    private SQLMethod sqlMethod;

    public void enable(Server server, Plugin plugin) {
        INSTANCE = this;
        this.server = server;
        sqlManager = new SQLManager();
        noSQLManager = new NoSQLManager();
        redisManager = new RedisManager();
        databaseManager = new DatabaseManager();
        sqlMethod = new SQLMethod();
        Bukkit.getLogger().info("FoxAPI initialized");
        MenuManager.registerMenuListener(server, plugin);
        databaseManager.enable();














    }

    public void disable() {
        databaseManager.disable();
    }

    public void modifyConfigSQL(String key, Consumer<HikariConfig> consumer) {
        consumerHikari.put(key, consumer);
    }

    public void modifyConfigRedis(String key, Consumer<Config> consumer) {
        consumerRedisson.put(key, consumer);
    }

    public Connection getConnexionSQL(String key) {
        return sqlManager.getConnectionDatabases().get(key);
    }

    public MongoClient getMongoClient(String key) {
        return noSQLManager.getClientDatabases().get(key);
    }

    public MongoDatabase getMongoDatabase(String key) {
        return noSQLManager.getConnectionDatabases().get(key);
    }

    public RedissonClient getRedisClient(String key) {
        return redisManager.getConnectionDatabases().get(key);
    }

    public void addDatabase(String key, Database type, Credentials credentials) {
        switch (type) {
            case SQL:
                if(DatabaseManager.correspondToSQLCredentials(credentials)) {
                    sqlManager.addSQLDatabase(key, DatabaseManager.setupSQLCredentials(credentials));
                } else {
                    server.getLogger().info("Wrong syntax in argument for SQL (<host> <user> <pass> <dbName> <port>)");
                }
                break;
            case MONGODB:
                if(DatabaseManager.correspondToNoSQLCredentials(credentials)) {
                    noSQLManager.addNoSQLDatabase(key, DatabaseManager.setupNoSQLCredentials(credentials));
                } else {
                    server.getLogger().info("Wrong syntax in argument for MongoDB (<host> <user> <pass> <dbName> <port>)");
                }
                break;
            case REDIS:
                if(DatabaseManager.correspondToRedisCredentials(credentials)) {
                    redisManager.addRedisDatabase(key, DatabaseManager.setupRedisCredentials(credentials));
                } else {
                    server.getLogger().info("Wrong syntax in argument for Redis (<host> [pass] <port> <database> [clientName])");
                }
                break;

            default:
                server.getLogger().severe("Incorrect type of Database");
                break;
        }
    }

    public static FoxApi getINSTANCE() {
        return INSTANCE;
    }

    public Server getServer() {
        return server;
    }

    public SQLManager getSqlManager() {
        return sqlManager;
    }

    public NoSQLManager getNoSQLManager() {
        return noSQLManager;
    }

    public RedisManager getRedisManager() {
        return redisManager;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public HashMap<String, Consumer<HikariConfig>> getConsumerHikari() {
        return consumerHikari;
    }

    public HashMap<String, Consumer<Config>> getConsumerRedisson() {
        return consumerRedisson;
    }

    public SQLMethod getSqlMethod() {
        return sqlMethod;
    }
}
