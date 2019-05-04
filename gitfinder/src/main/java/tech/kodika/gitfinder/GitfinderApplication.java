package tech.kodika.gitfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"tech.kodika.gitfinder.helpers", "tech.kodika.gitfinder.controllers"})
@EnableJpaRepositories(basePackages = {"tech.kodika.gitfinder.persistence"})
@EntityScan(basePackages = {"tech.kodika.gitfinder.persistence.entities"})

public class GitfinderApplication {


    public static void main(String[] args) {
        SpringApplication.run(GitfinderApplication.class, args);

    }
}
