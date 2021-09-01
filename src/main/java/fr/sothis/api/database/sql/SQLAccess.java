package fr.sothis.api.database.sql;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import fr.sothis.api.FoxApi;

import java.sql.Connection;
import java.sql.SQLException;

public class SQLAccess {

    private SQLCredentials credentials;
    private String key;
    private HikariDataSource hikariDataSource;

    public SQLAccess(SQLCredentials credentials, String key) {
        this.credentials = credentials;
        this.key = key;
    }

    public void setupHikariCP() {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setJdbcUrl(credentials.toURI());
        hikariConfig.setUsername(credentials.getUser());
        hikariConfig.setPassword(credentials.getPass());
        hikariConfig.setMaxLifetime(600000L);
        hikariConfig.setIdleTimeout(300000L);
        hikariConfig.setLeakDetectionThreshold(300000L);
        hikariConfig.setConnectionTimeout(10000L);

        FoxApi.getINSTANCE().getConsumerHikari().get(key).accept(hikariConfig);

        this.hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public void initPool() {
        setupHikariCP();
    }

    public void closePool() {
        this.hikariDataSource.close();
    }

    public Connection getConnection() throws SQLException {
        if(this.hikariDataSource == null) {
            System.out.println("Not Connected");
            setupHikariCP();
        }
        return this.hikariDataSource.getConnection();
    }
}
