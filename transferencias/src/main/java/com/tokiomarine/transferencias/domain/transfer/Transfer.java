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
        this.fee = Transfer.calculateFee(this.value, this.requestedDate, this.scheduledDate);
    }

    public Transfer(String originAccount, String destinationAccount, BigDecimal value, BigDecimal fee, LocalDate requestedDate, LocalDate scheduledDate) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
        this.fee = fee;
        this.requestedDate = requestedDate;
        this.scheduledDate = scheduledDate;
    }

    public static BigDecimal calculateFee(BigDecimal value, LocalDate requestedDate, LocalDate scheduledDate) {
        BigDecimal fee = new BigDecimal("0");
        long daysBetweenRequestAndSchedule = Duration.between(requestedDate.atStartOfDay(), scheduledDate.atStartOfDay()).toDays();
        if (daysBetweenRequestAndSchedule == 0) {
            fee = new TypeAFee().calculateFee(value);
        }

        if (daysBetweenRequestAndSchedule > 0 && daysBetweenRequestAndSchedule <= 10) {
            fee = new TypeBFee().calculateFee(value);
        }

        if (daysBetweenRequestAndSchedule > 10 && daysBetweenRequestAndSchedule <= 20) {
            fee = new TypeCFeeGreaterThan10Days().calculateFee(value);
        }

        if (daysBetweenRequestAndSchedule > 20 && daysBetweenRequestAndSchedule <= 30) {
            fee = new TypeCFeeGreaterThan20Days().calculateFee(value);
        }

        if (daysBetweenRequestAndSchedule > 30 && daysBetweenRequestAndSchedule <= 40) {
            fee = new TypeCFeeGreaterThan30Days().calculateFee(value);
        }

        if (daysBetweenRequestAndSchedule > 40) {
             fee= new TypeCFeeGreaterThan40Days().calculateFee(value);
        }

        if (fee.doubleValue() == 0) {
            throw new NoFeeAvaliableException("Não existe taxa aplicável.");
        }

        return fee;
    }
}
