package com.example.demo.service;

import com.example.demo.entity.Good;
import com.example.demo.repository.GoodRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {

    @Autowired
    GoodRepository goodRepository;

    @CachePut(value = "good", key = "#good.id")
    public Good saveGood(Good good) {
        return goodRepository.saveAndFlush(good);
    }

    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    @Cacheable(value = "good", key = "#id")
    public Good get(Integer id) {
        return goodRepository.getOne(id);
    }

    @CacheEvict(value = "good", key = "#id")
    public void delete(Integer id) {
        goodRepository.deleteById(id);
    }

    @RabbitListener(queues = "good.num")
    public void changenum(String amqp) {
        String[] split = amqp.split(",");
        Integer gid = Integer.valueOf(split[0]);
        goodRepository.num1(gid);
    }
}
