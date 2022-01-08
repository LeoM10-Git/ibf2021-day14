package com.example.ibf2021d13.repository;

import com.example.ibf2021d13.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    public static final String HASH_KEY = "User";

    @Autowired
    private RedisTemplate redisTemplate;

    public User saveUser(User user){
        redisTemplate.opsForHash().put(HASH_KEY, user.getId(), user);
        return user;
    }

    public List<User> findAllUsers(){
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public User findUserById(String id){
        return (User) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteUser(String id){
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "User ID: " + id + "information removed!";
    }


}
