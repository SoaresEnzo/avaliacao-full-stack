package com.tokiomarine.transferencias.domain.transfer.ports;

import com.tokiomarine.transferencias.domain.transfer.dtos.TransferRequestBodyDTO;
import com.tokiomarine.transferencias.domain.transfer.dtos.TransferResponseBodyDTO;
import com.tokiomarine.transferencias.infrastructure.entities.TransferEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface TransferServicePort {

    Page<TransferResponseBodyDTO> findTransfers(Pageable page);

    TransferEntity saveTransfer(TransferRequestBodyDTO request);

    BigDecimal calculateFee(BigDecimal value, LocalDate scheduledDate);
}
