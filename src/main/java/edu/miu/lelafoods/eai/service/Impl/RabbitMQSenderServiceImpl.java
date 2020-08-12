package edu.miu.lelafoods.eai.service.Impl;

import edu.miu.lelafoods.eai.domain.Cart;
import edu.miu.lelafoods.eai.domain.Order;
import edu.miu.lelafoods.eai.service.RabbitMQSenderService;
import edu.miu.lelafoods.eai.utils.ApplicationProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public void sendCartToRestaurant(Cart cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getEaiRoutingkey(), cart);
        System.out.println("sendCartToRestaurant = " + cart);
    }

    @Override
    public void sendCartEmail(String cart) {
        System.out.println("sendCartEmail = " + cart);
    }
}
