package com.tokiomarine.transferencias.infrastructure.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
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

}
