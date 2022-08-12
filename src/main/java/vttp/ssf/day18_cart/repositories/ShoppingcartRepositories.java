package vttp.ssf.day18_cart.repositories;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingcartRepositories {

    @Autowired
    @Qualifier("redislab")
    private RedisTemplate<String, String> redisTemplate;

    public void saveUser(String user){
      ValueOperations<String, String> valueOp = redisTemplate.opsForValue();
      valueOp.set("users", user);
    }

    public Integer count() {
        Set<String> keys = redisTemplate.keys("users");
        return keys.size();
    }
    public List<String> keys() {
        Set<String> keys = redisTemplate.keys("users");
        List<String> result = new LinkedList<>(keys);
        return result.stream()
                .toList();
    }

    public String getUsers() {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        return valueOps.get("users");
    }
}
