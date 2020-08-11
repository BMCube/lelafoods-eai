package edu.miu.lelafoods.eai.service.Impl;

import edu.miu.lelafoods.eai.domain.Order;
import edu.miu.lelafoods.eai.service.RabbitMQReceiverService;
import edu.miu.lelafoods.eai.utils.ApplicationProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
