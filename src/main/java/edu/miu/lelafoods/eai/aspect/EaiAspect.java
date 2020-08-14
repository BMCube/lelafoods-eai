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

    @After("execution(* edu.miu.lelafoods.eai.service.*.*(..))")
    public void after(JoinPoint joinPoint){
        //Implicit Advice logger to display after every message received from Queue listener
        logger.info(" Check for Received joint execution ");
        logger.info(" Allowed execution for {}", joinPoint.getSignature().getDeclaringTypeName());
    }
}
