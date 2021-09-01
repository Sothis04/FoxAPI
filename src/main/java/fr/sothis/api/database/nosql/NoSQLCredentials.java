package fr.sothis.api.database.nosql;

public class NoSQLCredentials {

    private String host;
    private String user;
    private String pass;
    private String dbName;
    private int port;

    public NoSQLCredentials(String host, String user, String pass, String dbName, int port) {

        this.host = host;
        this.user = user;
        this.pass = pass;
        this.dbName = dbName;
        this.port = port;

    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getHost() {
        return host;
    }

    public String getDbName() {
        return dbName;
    }

    public int getPort() {
        return port;
    }
}
