package edu.miu.lelafoods.eai.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class EaiAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //What kind of method calls I would intercept
    //execution(* PACKAGE.*.*(..))
    //Weaving & Weaver
    @After("execution(* edu.miu.lelafoods.eai.service.*.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        logger.info(" Check for Received joint execution ");
        logger.info(" Allowed execution for {}", joinPoint.getSignature().getDeclaringTypeName());
    }
}
