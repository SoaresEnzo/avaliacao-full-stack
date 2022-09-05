package com.tokiomarine.transferencias.domain.transfer.ports;

import com.tokiomarine.transferencias.domain.transfer.Transfer;

import java.util.List;

public interface TransferRepositoryPort {

    List<Transfer> findAll();

    void save(Transfer transfer);
}
