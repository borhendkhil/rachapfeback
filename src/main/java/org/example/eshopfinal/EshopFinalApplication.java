package org.example.eshopfinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.example.eshopfinal.repository.RefreshableCRUDRepositoryImpl;

@EnableJpaRepositories(repositoryBaseClass = RefreshableCRUDRepositoryImpl.class)
@SpringBootApplication
public class EshopFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopFinalApplication.class, args);
    }

}
