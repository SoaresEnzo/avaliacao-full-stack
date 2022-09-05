package com.tokiomarine.transferencias.infrastructure.repositories;

import com.tokiomarine.transferencias.domain.transfer.Transfer;
import com.tokiomarine.transferencias.domain.transfer.adapters.Converters;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferRepositoryPort;
import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class TransferRepository implements TransferRepositoryPort {
    private final SpringTransferRepository transferRepository;

    public TransferRepository(SpringTransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public Page<Transfer> findAll(Pageable pageable) {
        return this.transferRepository.findAll(pageable).map(Converters::convertToDomainEntity);
    }

    @Override
    public TransferEntity save(Transfer transfer) {
        return this.transferRepository.save(Converters.convertToDBEntity(transfer));
    }
}
