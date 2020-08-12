package edu.miu.lelafoods.eai.aspect;

import edu.miu.lelafoods.eai.dto.CartDto;
import edu.miu.lelafoods.eai.utils.ApplicationProperties;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class EaiAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ApplicationProperties applicationProperties;

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @After("execution(* edu.miu.lelafoods.eai.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for Received joint execution ");
        logger.info(" Allowed execution for {}", joinPoint.getSignature().getDeclaringTypeName());
    }

    public void sendCartToRestaurant(CartDto cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getRoutingkey(), cart);
        System.out.println("Sent card = " + cart.toString());
    }

    public void sendCartEmail(CartDto cart) {
        amqpTemplate.convertAndSend(applicationProperties.getExchange(), applicationProperties.getRoutingkey(), cart);
        System.out.println("Sent card = " + cart.toString());
    }
}
