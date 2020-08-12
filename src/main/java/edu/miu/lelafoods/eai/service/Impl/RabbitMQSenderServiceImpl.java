package edu.miu.lelafoods.eai.service.Impl;

import edu.miu.lelafoods.eai.dto.CartDto;
import edu.miu.lelafoods.eai.service.RabbitMQSenderService;
import edu.miu.lelafoods.eai.utils.ApplicationProperties;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RabbitMQSenderServiceImpl implements RabbitMQSenderService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ApplicationProperties applicationProperties;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public void sendCartToRestaurant(CartDto cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getEaiRoutingkey(), cart);
        System.out.println("sendCartToRestaurant = " + cart);
    }

    @Override
    public void sendCartEmail(CartDto cartDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(cartDto, headers);
        ResponseEntity<Object> response = restTemplate.exchange(applicationProperties.getEmailUrl(), HttpMethod.POST, entity, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Email sent successfully:  " + response.getBody());
        } else {
            System.err.println("Email sent failed please try again");
        }

    }
}
