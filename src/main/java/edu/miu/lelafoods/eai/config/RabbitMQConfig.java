package edu.miu.lelafoods.eai.config;

import edu.miu.lelafoods.eai.utils.ApplicationProperties;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Autowired
    ApplicationProperties applicationProperties;

    @Bean
    Queue queue() {
        return new Queue(applicationProperties.getQueueName(), true);
    }

//    @Bean
//    Queue queueEai() {
//        return new Queue(applicationProperties.getEaiQueueName(), true);
//    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(applicationProperties.getExchange());
    }

//    @Bean
//    DirectExchange exchangeEai() {
//        return new DirectExchange(applicationProperties.getEaiExchange());
//    }

    @Bean
    Binding binding(DirectExchange exchange) {
        return BindingBuilder.bind(queue()).to(exchange).with(applicationProperties.getRoutingkey());
    }

//    @Bean
//    Binding bindingEai(DirectExchange exchange) {
//        return BindingBuilder.bind(queueEai()).to(exchange).with(applicationProperties.getEaiRoutingkey());
//    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

//    @Bean
//    Binding binding1(TopicExchange exchange) {
//        return BindingBuilder.bind(queue1()).to(exchange).with(queue1().getName());
//    }
//
//    @Bean
//    Binding binding2(TopicExchange exchange) {
//        return BindingBuilder.bind(queue2()).to(exchange).with(queue2().getName());
//    }
}
