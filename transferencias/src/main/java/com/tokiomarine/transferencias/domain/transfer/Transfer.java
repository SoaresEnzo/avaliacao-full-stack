package com.tokiomarine.transferencias.domain.transfer;

import com.tokiomarine.transferencias.domain.errors.NoFeeAvaliableException;
import com.tokiomarine.transferencias.domain.fee.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

@Getter
public class Transfer {
    private String originAccount;
    private String destinationAccount;
    private BigDecimal value;
    private BigDecimal fee;
    private LocalDate requestedDate;
    private LocalDate scheduledDate;

    public Transfer(String originAccount, String destinationAccount, BigDecimal value, LocalDate requestedDate, LocalDate scheduledDate) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.requestedDate = requestedDate;
        this.scheduledDate = scheduledDate;
        calculateFee();
    }

    public Transfer(String originAccount, String destinationAccount, BigDecimal value, BigDecimal fee, LocalDate requestedDate, LocalDate scheduledDate) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.fee = fee;
        this.requestedDate = requestedDate;
        this.scheduledDate = scheduledDate;
    }

    private void calculateFee() {
        long daysBetweenRequestAndSchedule = Duration.between(this.requestedDate.atStartOfDay(), this.scheduledDate.atStartOfDay()).toDays();
        if (daysBetweenRequestAndSchedule == 0) {
            this.fee = new TypeAFee().calculateFee(this.value);
        }

        if (daysBetweenRequestAndSchedule > 0 && daysBetweenRequestAndSchedule <= 10) {
            this.fee = new TypeBFee().calculateFee(this.value);
        }

        if (daysBetweenRequestAndSchedule > 10 && daysBetweenRequestAndSchedule <= 20) {
            this.fee = new TypeCFeeGreaterThan10Days().calculateFee(this.value);
        }

        if (daysBetweenRequestAndSchedule > 20 && daysBetweenRequestAndSchedule <= 30) {
            this.fee = new TypeCFeeGreaterThan20Days().calculateFee(this.value);
        }

        if (daysBetweenRequestAndSchedule > 30 && daysBetweenRequestAndSchedule <= 40) {
            this.fee = new TypeCFeeGreaterThan30Days().calculateFee(this.value);
        }

        if (daysBetweenRequestAndSchedule > 40) {
            this.fee = new TypeCFeeGreaterThan40Days().calculateFee(this.value);
        }

        if (this.fee == null) {
            throw new NoFeeAvaliableException("Não existe taxa aplicável.");
        }
    }
}
