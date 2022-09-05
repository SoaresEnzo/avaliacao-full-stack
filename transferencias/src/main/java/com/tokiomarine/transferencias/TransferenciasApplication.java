package com.tokiomarine.transferencias;

import com.tokiomarine.transferencias.infrastructure.repositories.SpringTransferRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SpringTransferRepository.class)
public class TransferenciasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransferenciasApplication.class, args);
    }

}
