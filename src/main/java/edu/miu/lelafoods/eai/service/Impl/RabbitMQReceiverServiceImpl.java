package edu.miu.lelafoods.eai.service.Impl;

import edu.miu.lelafoods.eai.dto.CartDto;
import edu.miu.lelafoods.eai.dto.Order;
import edu.miu.lelafoods.eai.service.RabbitMQReceiverService;
import edu.miu.lelafoods.eai.service.RabbitMQSenderService;
import edu.miu.lelafoods.eai.utils.Utility;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class RabbitMQReceiverServiceImpl implements RabbitMQReceiverService {

    @Autowired
    Queue queue;

    @Autowired
    RabbitMQSenderService rabbitMQSenderService;

    private Utility utility = new Utility();

    @Override
    @RabbitListener(queues = "lelafoods-order.queue")
    public void receiverCart(CartDto cartDto) {
        try {
            System.out.println("Recieved Message From RabbitMQ: " + cartDto.toString());
            System.out.println("utility.cartToJson(cart) From RabbitMQ: " + utility.cartToJson(cartDto));
            rabbitMQSenderService.sendCartToRestaurant(cartDto);
            rabbitMQSenderService.sendCartEmail(cartDto);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
