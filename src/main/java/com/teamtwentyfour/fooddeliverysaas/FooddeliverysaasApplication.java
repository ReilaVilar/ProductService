package com.teamtwentyfour.fooddeliverysaas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@EnableMongoRepositories
public class FooddeliverysaasApplication {

    public static void main(String[] args) {
        SpringApplication.run(FooddeliverysaasApplication.class, args);
    }

}
