package com.tokiomarine.transferencias.domain.transfer.adapters;

import com.tokiomarine.transferencias.domain.transfer.dtos.TransferRespondeBodyDTO;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferRepositoryPort;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferServicePort;

import java.util.List;

public class TransferServiceImp implements TransferServicePort {

    private final TransferRepositoryPort transferRepository;

    public TransferServiceImp(TransferRepositoryPort transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public List<TransferRespondeBodyDTO> findTransfers() {
        return null;
    }

    @Override
    public void saveTransfer() {

    }
}
