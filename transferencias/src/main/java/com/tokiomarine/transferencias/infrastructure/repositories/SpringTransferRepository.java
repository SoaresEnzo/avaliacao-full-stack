package com.tokiomarine.transferencias.infrastructure.repositories;

import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SpringTransferRepository extends CrudRepository<TransferEntity, UUID> {
}
