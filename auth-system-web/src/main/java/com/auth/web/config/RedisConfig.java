package com.auth.web.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
    private  int database;

    /*// 自定义key生成器
    @Bean
    public KeyGenerator keyGenerator(){
        return (o, method, params) ->{
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName()); // 类目
            sb.append(method.getName()); // 方法名
            for(Object param: params){
                sb.append(param.toString()); // 参数名
            }
            return sb.toString();
        };
    }*/

    @Bean
    public JedisPool redisPoolFactory() {
    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
         // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(true);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password,database);
        return jedisPool;
    }
}
