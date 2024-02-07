package org.achteins81.app.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 使用Lettuce 操作redis单机版和redis集群
 *
 * @author Achteins-81
 * @see "https://blog.csdn.net/gxuehe/article/details/81942913"
 * @since 2023-01-03
 */
public class LettuceDemo {

    private static final String REDIS_URI_PREFIX = "redis://";

    public static void main(String[] args) {
        operCluster();
    }

    public static void operSingle() {
        RedisClient client = RedisClient.create(RedisURI.create("redis://127.0.0.1:7001"));
        StatefulRedisConnection<String, String> connect = client.connect();

        /**
         * 同步调用
         */
        RedisCommands<String, String> commands = connect.sync();
        commands.set("hello", "hello world, time:" + new Date());
        String str = commands.get("hello");
        System.out.println(str);

        /**
         * 异步调用
         */
        RedisAsyncCommands<String, String> asyncCommands = connect.async();
        RedisFuture<String> future = asyncCommands.get("hello");
        try {
            String str1 = future.get();
            System.out.println(str1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        connect.close();
        client.shutdown();
    }

    public static void operCluster() {
        List<RedisURI> list = new ArrayList<>();
        int startPort = 6379;
        int port;
        String ip = "127.0.0.1";
//        String ip = "192.168.76.238";
        String uri;
        RedisURI redisURI;
        for (int i = 0; i < 6; i++) {
            port = startPort + i;
            uri = REDIS_URI_PREFIX + ip + ":" + port;//"redis://127.0.0.1:6379"
            System.out.println(uri);
            list.add(RedisURI.create(uri));
        }
        RedisClusterClient client = RedisClusterClient.create(list);
        StatefulRedisClusterConnection<String, String> connect = client.connect();

        /**
         * 同步执行命令
         */
        RedisAdvancedClusterCommands<String, String> commands = connect.sync();
        commands.set("hello", "hello world, time:" + new Date());
        String str = commands.get("hello");
        System.out.println(str);

        /**
         * 异步执行命令
         */
        RedisAdvancedClusterAsyncCommands<String, String> asyncCommands = connect.async();
        RedisFuture<String> future = asyncCommands.get("hello");

        try {
            String str1 = future.get();
            System.out.println(str1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            connect.close();
            client.shutdown();
        }


    }
}
