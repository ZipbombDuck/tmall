package com.hucu.tmall.tmall_springboot;


import org.junit.Test;
import redis.clients.jedis.Jedis;

public class redis {

    @Test
    public void redisTest(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("sssss"+jedis.ping());
        String s = jedis.set("address", "湖南");
        System.out.println(s);//OK是成功 NIL是失败
    }
}
