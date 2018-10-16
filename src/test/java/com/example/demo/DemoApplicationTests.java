package com.example.demo;

import com.example.demo.entity.Good;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.GoodService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    GoodService goodService;

    @Autowired
    OrderService orderService;

    @Test
    public void addOrder() {
//        Good g=goodService.get(1);
//        System.out.println(g.toString());
        Order o = orderService.getone(1);
        System.out.println(o.toString());
    }

    @Test
    public void contextLoads() {
        User user = userService.finduser("admin", "123456");
        if (user == null) {
            System.out.println(1);
        } else {
            System.out.println(user.toString());
        }
    }

    @Test
    public void get() {
        User u = userService.get(10);
        System.out.println(u.toString());
    }
}
