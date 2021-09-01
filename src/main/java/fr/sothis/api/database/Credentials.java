package fr.sothis.api.database;

public class Credentials {

    private String host;
    private String user;
    private String password;
    private String dbName;
    private int port;
    private boolean redisHasPassWord;
    private String clientName;
    private int database;

    private Credentials(String host, String user, String password, String dbName, int port, boolean redisHasPassWord, String clientName, int database) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.dbName = dbName;
        this.port = port;
        this.redisHasPassWord = redisHasPassWord;
        this.clientName = clientName;
        this.database = database;
    }

    public Credentials(String host, String user, String pass, String dbName, int port) {
        this(host, user, pass, dbName, port, false, null, 0);
    }

    public Credentials(String host, String pass, int port, int database) {
        this(host, null, pass, null, port, true, null, database);
    }

    public Credentials(String host, String pass, int port, int database, String clientName) {
        this(host, null, pass, null, port, true, clientName, database);
    }

    public Credentials(String host, int port, int database) {
        this(host, null, null, null, port, false, null, database);
    }

    public Credentials(String host, int port, int database, String clientName) {
        this(host, null, null, null, port, false, clientName, database);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isRedisHasPassWord() {
        return redisHasPassWord;
    }

    public void setRedisHasPassWord(boolean redisHasPassWord) {
        this.redisHasPassWord = redisHasPassWord;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getDatabase() {
        return database;
    }

    public void setDatabase(int database) {
        this.database = database;
    }
}
