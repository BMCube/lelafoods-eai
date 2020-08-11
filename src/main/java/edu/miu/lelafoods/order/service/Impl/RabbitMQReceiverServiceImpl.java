package edu.miu.lelafoods.order.service.Impl;

import edu.miu.lelafoods.order.domain.Order;
import edu.miu.lelafoods.order.service.RabbitMQReceiverService;
import edu.miu.lelafoods.order.service.RabbitMQSenderService;
import edu.miu.lelafoods.order.utils.ApplicationProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQReceiverServiceImpl implements RabbitMQReceiverService {

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    Queue queue;

    @Override
    @RabbitListener(queues = "#{queue.getName()}")
    public void receiverOrder(Order order) {
        System.out.println("Recieved Message From RabbitMQ: " + order);
    }


}
