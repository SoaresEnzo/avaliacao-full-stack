package com.tokiomarine.transferencias.domain.transfer.adapters;

import com.tokiomarine.transferencias.domain.transfer.Transfer;
import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;

public abstract class Converters {
    public static Transfer convertToDomainEntity(TransferEntity dbEntity) {
        return new Transfer(dbEntity.getOriginAccount(), dbEntity.getDestinationAccount(), dbEntity.getValue(), dbEntity.getFee(), dbEntity.getRequestedDate(), dbEntity.getScheduledDate());
    }

    public static TransferEntity convertToDBEntity(Transfer domainEntity) {
        return new TransferEntity(domainEntity.getOriginAccount(), domainEntity.getDestinationAccount(), domainEntity.getValue(), domainEntity.getFee(), domainEntity.getRequestedDate(), domainEntity.getScheduledDate());
    }
}
