package com.tokiomarine.transferencias.infrastructure.repositories;

import com.tokiomarine.transferencias.domain.transfer.Transfer;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransferRepository implements TransferRepositoryPort {
    @Override
    public List<Transfer> findAll() {
        return null;
    }

    @Override
    public void save(Transfer transfer) {

    }
}
