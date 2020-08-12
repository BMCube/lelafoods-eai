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
    public void receiverCart(CartDto cart) {
        try {
            List<Order> orderList = cart.getOrder();
            //  Cart cartToBeSent = new Cart();
            double totalPrice;
            for (Order order : orderList) {
                //This part should contain same name with the cart model
                totalPrice = order.getFood().getPrice() * order.getOrderQuantity();
                BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
                double newTotalPrice = bd.doubleValue();
                order.getFood().setTotal(newTotalPrice);
            }

            System.out.println("Recieved Message From RabbitMQ: " + cart.toString());
            rabbitMQSenderService.sendCartToRestaurant(cart);
            emailJsonFormat(cart);
            rabbitMQSenderService.sendCartEmail(cart);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void emailJsonFormat(CartDto cartDto) {

    }
}
