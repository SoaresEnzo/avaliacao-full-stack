package com.tokiomarine.transferencias.domain;

import com.tokiomarine.transferencias.domain.fee.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
public class Transfer {
    private final String originAccount;
    private final String destinationAccount;
    private final BigDecimal value;
    private BigDecimal fee;
    private final LocalDate requestedDate;
    private final LocalDate scheduledDate;

    public Transfer(String originAccount, String destinationAccount, BigDecimal value, LocalDate requestedDate, LocalDate scheduledDate) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.requestedDate = requestedDate;
        this.scheduledDate = scheduledDate;
        calculateFee();
    }

    public BigDecimal getFee() {
        return fee;
    }

    private void calculateFee() {
        long daysBetweenRequestAndSchedule = Duration.between(this.requestedDate.atStartOfDay(), this.scheduledDate.atStartOfDay()).toDays();
        if(daysBetweenRequestAndSchedule == 0) {
            this.fee = new TypeAFee().calculateFee(this.value);
        }

        if(daysBetweenRequestAndSchedule > 0 && daysBetweenRequestAndSchedule <= 10) {
            this.fee = new TypeBFee().calculateFee(this.value);
        }

        if(daysBetweenRequestAndSchedule > 10 && daysBetweenRequestAndSchedule <= 20) {
            this.fee = new TypeCFeeGreaterThan10Days().calculateFee(this.value);
        }

        if(daysBetweenRequestAndSchedule > 20 && daysBetweenRequestAndSchedule <= 30) {
            this.fee = new TypeCFeeGreaterThan20Days().calculateFee(this.value);
        }

        if(daysBetweenRequestAndSchedule > 30 && daysBetweenRequestAndSchedule <= 40) {
            this.fee = new TypeCFeeGreaterThan30Days().calculateFee(this.value);
        }

        if(daysBetweenRequestAndSchedule > 40) {
            this.fee = new TypeCFeeGreaterThan40Days().calculateFee(this.value);
        }

        if(this.fee == null) {
            throw new NoFeeAvaliableException("Não existe taxa aplicável.");
        }
    }
}
