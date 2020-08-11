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
    @Autowired
    private RabbitAdmin rabbitAdmin;

//    //For now not used
//    String amqpTopic = "lelafoods_order_topic";
//    //I don't think we need this but for now let's keep it
//    @Override
//    public void initializeRabbit(){
//        Queue queue = new Queue(applicationProperties.getEaiQueueName() , true, false, false);
//        Binding binding = new Binding(applicationProperties.getEaiQueueName(), Binding.DestinationType.QUEUE, applicationProperties.getEaiExchange(), applicationProperties.getEaiRoutingkey(), null);
//        rabbitAdmin.declareQueue(queue);
//        rabbitAdmin.declareBinding(binding);
//    }

    @Override
    public void sendCartToRestaurant(String cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getEaiRoutingkey(), cart);
        System.out.println("sendCartToRestaurant = " + cart);
    }

    @Override
    public void sendCartEmail(String cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getEaiRoutingkey(), cart);
        System.out.println("sendCartEmail = " + cart.toString());
    }
}
