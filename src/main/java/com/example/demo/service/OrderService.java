package com.example.demo.service;

import com.example.demo.entity.Good;
import com.example.demo.entity.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order add(Order order) {
//        System.out.println("收到一条订单消息");
        return orderRepository.save(order);
    }

    @RabbitListener(queues = "good.order")
    public void saveorder(String amqp) {
        String[] split = amqp.split(",");
        Integer gid = Integer.valueOf(split[0]);
        Integer uid = Integer.valueOf(split[1]);
        Date date = new Date();
        orderRepository.saveorder(gid, uid, date);
    }

    public Order getone(Integer id) {
        return orderRepository.getOne(id);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
