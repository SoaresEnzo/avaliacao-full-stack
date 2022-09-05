package com.tokiomarine.transferencias.infrastructure.config;

import com.tokiomarine.transferencias.domain.transfer.adapters.TransferServiceImp;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferRepositoryPort;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    TransferServicePort transferService(TransferRepositoryPort transferRepositoryPort) {
        return new TransferServiceImp(transferRepositoryPort);
    }
}
