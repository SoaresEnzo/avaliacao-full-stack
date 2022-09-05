package com.tokiomarine.transferencias.infrastructure.repositories;

import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SpringTransferRepository extends CrudRepository<TransferEntity, UUID> {

    Page<TransferEntity> findAll(Pageable pageable);
}
