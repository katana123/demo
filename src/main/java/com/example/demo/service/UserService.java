package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "emp")
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User finduser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @CachePut(value = "user", key = "#user.id")
    public User saveUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Cacheable(value = "user", key = "#id")
    public User get(Integer id) {
        return userRepository.getOne(id);
    }

    @CacheEvict(value = "user", key = "#id")
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
