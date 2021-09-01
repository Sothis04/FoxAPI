package fr.sothis.api.database;

import fr.sothis.api.FoxApi;
import fr.sothis.api.database.nosql.NoSQLAccess;
import fr.sothis.api.database.nosql.NoSQLCredentials;
import fr.sothis.api.database.nosql.NoSQLManager;
import fr.sothis.api.database.redis.RedisAccess;
import fr.sothis.api.database.redis.RedisCredentials;
import fr.sothis.api.database.redis.RedisManager;
import fr.sothis.api.database.sql.SQLAccess;
import fr.sothis.api.database.sql.SQLCredentials;
import fr.sothis.api.database.sql.SQLManager;

import java.sql.SQLException;

public class DatabaseManager {

    private SQLManager sqlManager = FoxApi.getINSTANCE().getSqlManager();
    private NoSQLManager noSQLManager = FoxApi.getINSTANCE().getNoSQLManager();
    private RedisManager redisManager = FoxApi.getINSTANCE().getRedisManager();

    public void enable() {
        if(!sqlManager.getSqlDatabases().isEmpty()) {
            sqlManager.getSqlDatabases().forEach((s, sqlCredentials) -> {
                SQLAccess sqlAccess = new SQLAccess(sqlCredentials, s);
                sqlAccess.initPool();
                try {
                    sqlManager.addConnectionDatabase(s, sqlAccess.getConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sqlManager.addAccessDatabase(s, sqlAccess);
            });
        }
        if(!noSQLManager.getNoSqlDatabases().isEmpty()) {
            noSQLManager.getNoSqlDatabases().forEach((s, noSQLCredentials) -> {
                NoSQLAccess noSQLAccess = new NoSQLAccess(noSQLCredentials);
                try {
                    noSQLAccess.initConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                noSQLManager.addClientDatabase(s, noSQLAccess.getMongoClient());
                noSQLManager.addConnectionDatabase(s, noSQLAccess.getDatabase());
                noSQLManager.addAccessDatabase(s, noSQLAccess);
            });
        }
        if(!redisManager.getRedisDatabases().isEmpty()) {
            redisManager.getRedisDatabases().forEach((s, redisCredentials) -> {
                RedisAccess redisAccess = new RedisAccess(redisCredentials, s);
                redisAccess.init();
                redisManager.addConnectionDatabase(s, redisAccess.getRedissonClient());
                redisManager.addAccessDatabase(s, redisAccess);
            });
        }
    }

    public void disable() {
        if(!sqlManager.getSqlDatabases().isEmpty()) {
            sqlManager.getSqlDatabases().forEach((s, sqlCredentials) -> {
                SQLAccess sqlAccess = sqlManager.getAccessDatabases().get(s);
                sqlAccess.closePool();
                try {
                    sqlManager.removeConnectionDatabase(s, sqlAccess.getConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                sqlManager.removeAccessDatabase(s, sqlAccess);
            });
        }
        if(!noSQLManager.getNoSqlDatabases().isEmpty()) {
            noSQLManager.getNoSqlDatabases().forEach((s, noSQLCredentials) -> {
                NoSQLAccess noSQLAccess = noSQLManager.getAccessDatabases().get(s);
                try {
                    noSQLAccess.endConnection();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                noSQLManager.removeClientDatabase(s, noSQLAccess.getMongoClient());
                noSQLManager.removeConnectionDatabase(s, noSQLAccess.getDatabase());
                noSQLManager.removeAccessDatabase(s, noSQLAccess);
            });
        }
        if(!redisManager.getRedisDatabases().isEmpty()) {
            redisManager.getRedisDatabases().forEach((s, redisCredentials) -> {
                RedisAccess redisAccess = redisManager.getAccessDatabases().get(s);
                redisAccess.close();
                redisManager.removeConnectionDatabase(s, redisAccess.getRedissonClient());
                redisManager.removeAccessDatabase(s, redisAccess);
            });
        }
    }

    public static NoSQLCredentials setupNoSQLCredentials(Credentials credentials) {
        return new NoSQLCredentials(credentials.getHost(),
                credentials.getUser(),
                credentials.getPassword(),
                credentials.getDbName(),
                credentials.getPort());
    }

    public static SQLCredentials setupSQLCredentials(Credentials credentials) {
        return new SQLCredentials(credentials.getHost(),
                credentials.getUser(),
                credentials.getPassword(),
                credentials.getDbName(),
                credentials.getPort());
    }

    public static RedisCredentials setupRedisCredentials(Credentials credentials) {
        String pass = "";
        String clientName = "";
        if(credentials.isRedisHasPassWord()) {
            pass = credentials.getPassword();
        }
        if(credentials.getClientName() != null) {
            clientName = credentials.getClientName();
        }
        return new RedisCredentials(credentials.getHost(), pass, credentials.getPort(), credentials.getDatabase(), clientName);
    }

    public static boolean correspondToSQLCredentials(Credentials credentials) {
        if(credentials.getHost() == null || credentials.getUser() == null || credentials.getPassword() == null) {
            FoxApi.getINSTANCE().getServer().getLogger().info("Wrong Credential");
            return false;
        }
        if(credentials.getDbName() == null) {
            FoxApi.getINSTANCE().getServer().getLogger().info("Wrong Credential");
            return false;
        }
        return true;
    }

    public static boolean correspondToNoSQLCredentials(Credentials credentials) {
        if(credentials.getHost() == null || credentials.getUser() == null || credentials.getPassword() == null) {
            FoxApi.getINSTANCE().getServer().getLogger().info("Wrong Credential");
            return false;
        }
        if(credentials.getDbName() == null) {
            FoxApi.getINSTANCE().getServer().getLogger().info("Wrong Credential");
            return false;
        }
        return true;
    }

    public static boolean correspondToRedisCredentials(Credentials credentials) {
        if(credentials.getHost() == null) {
            FoxApi.getINSTANCE().getServer().getLogger().info("Wrong Credential");
            return false;
        }
        return true;
    }
}
