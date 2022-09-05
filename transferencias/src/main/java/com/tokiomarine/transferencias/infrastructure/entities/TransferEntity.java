package com.tokiomarine.transferencias.infrastructure.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID transferId;
    private String originAccount;
    private String destinationAccount;
    @Column(name = "base_value")
    private BigDecimal value;
    private BigDecimal fee;
    private LocalDate requestedDate;
    private LocalDate scheduledDate;

    public TransferEntity(String originAccount, String destinationAccount, BigDecimal value, BigDecimal fee, LocalDate requestedDate, LocalDate scheduledDate) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.fee = fee;
        this.requestedDate = requestedDate;
        this.scheduledDate = scheduledDate;
    }
}
