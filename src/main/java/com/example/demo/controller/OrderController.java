package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.GoodService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    GoodService goodService;
    @Autowired
    UserService userService;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{id}/{uid}")//id是商品id，UID是用户id
    public String addOrder(@PathVariable("id") Integer id,
                           @PathVariable("uid") Integer uid,
                           Model model) {
        rabbitTemplate.convertAndSend("good.news", "good.new", id + "," + uid);
        return "redirect:/goods";
    }

    @GetMapping(value = "/orders")
    public String Orders(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "list";
    }
}
