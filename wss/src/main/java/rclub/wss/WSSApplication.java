package rclub.wss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = {"rclub.wss.*"})
@EntityScan(basePackages = {"rclub.wss.*"})
@ComponentScan(basePackages = {"rclub.wss.*"})
@SpringBootApplication
public class WSSApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(WSSApplication.class, args);
    }

}
