package fr.sothis.api.database.redis;

public class RedisCredentials {

    private String ip;
    private String password;
    private int port;
    private String clientName;
    private int database;

    public RedisCredentials(String ip, String password, int port, int database, String clientName) {
        this.ip = ip;
        this.password = password;
        this.port = port;
        this.database = database;
        this.clientName = clientName;
    }

    public String getIp() {
        return ip;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String getClientName() {
        return clientName;
    }

    public String toRedisURL() {
        return ip + ":" + port;
    }

    public int getDatabase() {
        return database;
    }
}
