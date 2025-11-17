package com.oglcnkrty.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.oglcnkrty"})
@EntityScan(basePackages = {"com.oglcnkrty"})
@EnableJpaRepositories(basePackages = {"com.oglcnkrty"})
@SpringBootApplication
public class GaleristApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaleristApplication.class, args);
    }

}
