package com.tokiomarine.transferencias.domain.transfer.adapters;

import com.tokiomarine.transferencias.domain.transfer.Transfer;
import com.tokiomarine.transferencias.domain.transfer.dtos.TransferRequestBodyDTO;
import com.tokiomarine.transferencias.domain.transfer.dtos.TransferResponseBodyDTO;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferRepositoryPort;
import com.tokiomarine.transferencias.domain.transfer.ports.TransferServicePort;
import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferServiceImp implements TransferServicePort {
    private final TransferRepositoryPort transferRepository;

    public TransferServiceImp(TransferRepositoryPort transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public Page<TransferResponseBodyDTO> findTransfers(Pageable page) {
        return this.transferRepository.findAll(page).map(TransferResponseBodyDTO::new);
    }

    @Override
    public TransferEntity saveTransfer(TransferRequestBodyDTO request) {
        return this.transferRepository.save(request.getTransfer());
    }

    @Override
    public BigDecimal calculateFee(BigDecimal value, LocalDate scheduledDate) {
        return Transfer.calculateFee(value, LocalDate.now(), scheduledDate);
    }
}
