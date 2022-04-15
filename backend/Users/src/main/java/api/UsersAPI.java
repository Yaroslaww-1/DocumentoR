package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "application", "domain", "infrastructure", "api" })
public class UsersAPI {

    public static void main(String[] args) {
        SpringApplication.run(UsersAPI.class, args);
    }

}
