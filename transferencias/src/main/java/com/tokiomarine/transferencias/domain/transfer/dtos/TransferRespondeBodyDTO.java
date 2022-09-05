package com.tokiomarine.transferencias.domain.transfer.dtos;

import com.tokiomarine.transferencias.domain.transfer.Transfer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferRespondeBodyDTO {

    private final String originAccount;
    private final String destinationAccount;
    private final BigDecimal value;
    private BigDecimal fee;
    private final LocalDate requestedDate;
    private final LocalDate scheduledDate;

    private final BigDecimal finalValue;

    public TransferRespondeBodyDTO(Transfer transfer) {
        this.originAccount = transfer.getOriginAccount();
        this.destinationAccount = transfer.getDestinationAccount();
        this.value = transfer.getFee();
        this.fee = transfer.getFee();
        this.requestedDate = transfer.getRequestedDate();
        this.scheduledDate = transfer.getScheduledDate();
        this.finalValue = transfer.getValue().add(transfer.getFee());
    }
}
