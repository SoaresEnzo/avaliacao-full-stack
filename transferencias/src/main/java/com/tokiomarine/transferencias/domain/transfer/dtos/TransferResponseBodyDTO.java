package com.tokiomarine.transferencias.domain.transfer.dtos;

import com.tokiomarine.transferencias.domain.transfer.Transfer;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class TransferResponseBodyDTO {
    private final String originAccount;
    private final String destinationAccount;
    private final BigDecimal value;
    private final LocalDate requestedDate;
    private final LocalDate scheduledDate;
    private final BigDecimal finalValue;
    private BigDecimal fee;

    public TransferResponseBodyDTO(Transfer transfer) {
        this.originAccount = transfer.getOriginAccount();
        this.destinationAccount = transfer.getDestinationAccount();
        this.value = transfer.getFee();
        this.fee = transfer.getFee();
        this.requestedDate = transfer.getRequestedDate();
        this.scheduledDate = transfer.getScheduledDate();
        this.finalValue = transfer.getValue().add(transfer.getFee());
    }
}
