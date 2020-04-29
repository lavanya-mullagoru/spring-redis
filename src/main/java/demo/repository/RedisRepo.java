package demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisRepo {

    @Autowired
    private RedisTemplate redisTemplate;

    private HashOperations hashOperations;

    public RedisRepo(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    public void save(String key){
        hashOperations = redisTemplate.opsForHash();
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("statusCode","200");
        properties.put("message","testMessage");
        properties.put("processingTime","35s");
        //hashOperations.putAll(key,properties);
        hashOperations.putIfAbsent(key,"test",properties);
        redisTemplate.persist(properties);
        redisTemplate.delete("statusCode");
    }

    public List findAll(String key){
        hashOperations = redisTemplate.opsForHash();
        return hashOperations.values(key);
    }

    public String findById(String id){
        return redisTemplate.opsForHash().get(id,"DAL_DVC").toString();
    }

    public void update(String user){
        save(user);
    }

    public void delete(String key){
        hashOperations.delete(key,"DAL_DVC");

    }

}
