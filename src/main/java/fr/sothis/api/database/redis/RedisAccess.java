package fr.sothis.api.database.redis;

import fr.sothis.api.FoxApi;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedisAccess {

    private RedisCredentials redisCredentials;
    private String key;
    private RedissonClient redissonClient;

    public RedisAccess(RedisCredentials redisCredentials, String key) {
        this.redisCredentials = redisCredentials;
        this.key = key;
    }

    public RedissonClient initRedisson() {
        final Config config = new Config();

        config.setUseLinuxNativeEpoll(true);
        config.setThreads(2);
        config.setNettyThreads(2);
        config.useSingleServer()
                .setAddress(redisCredentials.toRedisURL())
                .setPassword(redisCredentials.getPassword())
                .setDatabase(1)
                .setClientName(redisCredentials.getClientName());

        FoxApi.getINSTANCE().getConsumerRedisson().get(key).accept(config);

        return Redisson.create(config);
    }

    public void init() {
        initRedisson();
    }

    public void close() {
        redissonClient.shutdown();
    }

    public RedissonClient getRedissonClient() {
        return redissonClient;
    }
}
