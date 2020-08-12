package edu.miu.lelafoods.eai.service.Impl;

import edu.miu.lelafoods.eai.domain.Cart;
import edu.miu.lelafoods.eai.domain.Order;
import edu.miu.lelafoods.eai.service.RabbitMQReceiverService;
import edu.miu.lelafoods.eai.utils.ApplicationProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RabbitMQReceiverServiceImpl implements RabbitMQReceiverService {

    @Autowired
    private ApplicationProperties applicationProperties;
    @Autowired
    Queue queue;

    @Override
    @RabbitListener(queues = "#{queue.getName()}")
    public void receiverCart(Cart cart) {
        List<Order> orderList=cart.getOrder();
        double totalPerOrder=0;
        for (Order order: orderList) {
            //This part should contain same name with the cart model
            order.getFood().setTotal(order.getFood().getPrice()*order.getOrderAmount());
        }
        cart.setOrder(orderList);


        System.out.println("Recieved Message From RabbitMQ: " + cart.toString());
    }


}
