package com.tokiomarine.transferencias.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
public class Transferencia {
    private final String originAccount;
    private final String destinationAccount;
    private final BigDecimal value;
    private BigDecimal fee;
    private final LocalDate requestedDate;
    private final LocalDate scheduledDate;

    public Transferencia(String originAccount, String destinationAccount, BigDecimal value, LocalDate requestedDate, LocalDate scheduledDate) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.requestedDate = requestedDate;
        this.scheduledDate = scheduledDate;
    }

    public BigDecimal getFee() {
        return fee;
    }
}
