package com.example.demo;

import com.example.demo.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class amqpTest {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void rabbit01() {
//        amqpAdmin.removeBinding(new Binding("amqp.queue",Binding.DestinationType.QUEUE,"amqp.direct","amqp.haha",null));
//        amqpAdmin.deleteExchange("amqp.direct");
//        amqpAdmin.declareExchange(new FanoutExchange("good.news"));
//        amqpAdmin.declareQueue(new Queue("good.num",true));
//        amqpAdmin.declareBinding(new Binding("good.order",Binding.DestinationType.QUEUE,"good.news","good.new",null));

//        rabbitTemplate.convertAndSend("good.news","good.new","haha");
        Object o = rabbitTemplate.receiveAndConvert("good.order");
    }
}
