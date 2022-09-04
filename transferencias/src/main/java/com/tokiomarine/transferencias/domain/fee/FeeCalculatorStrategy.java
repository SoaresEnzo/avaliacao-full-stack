package com.tokiomarine.transferencias.domain.fee;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FeeCalculatorStrategy {
    BigDecimal calculateFee(BigDecimal value);
}
