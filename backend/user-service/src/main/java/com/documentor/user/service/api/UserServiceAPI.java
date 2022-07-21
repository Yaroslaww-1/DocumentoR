package com.documentor.user.service.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.documentor.user.service.api",
        "com.documentor.user.service.application",
        "com.documentor.user.service.domain"
})
public class UserServiceAPI {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceAPI.class, args);
    }

}
