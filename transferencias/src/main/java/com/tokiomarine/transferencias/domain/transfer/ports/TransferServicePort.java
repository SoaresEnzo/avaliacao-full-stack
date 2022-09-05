package com.tokiomarine.transferencias.domain.transfer.ports;

import com.tokiomarine.transferencias.domain.transfer.dtos.TransferRespondeBodyDTO;

import java.util.List;

public interface TransferServicePort {

    List<TransferRespondeBodyDTO> findTransfers();

    void saveTransfer();
}
