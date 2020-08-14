package edu.miu.lelafoods.eai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                EaiApplication.class, args);
    }

}
