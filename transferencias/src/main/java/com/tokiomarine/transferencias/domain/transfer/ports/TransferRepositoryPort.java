package com.tokiomarine.transferencias.domain.transfer.ports;

import com.tokiomarine.transferencias.domain.transfer.Transfer;
import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransferRepositoryPort {

    Page<Transfer> findAll(Pageable page);

    TransferEntity save(Transfer transfer);
}
