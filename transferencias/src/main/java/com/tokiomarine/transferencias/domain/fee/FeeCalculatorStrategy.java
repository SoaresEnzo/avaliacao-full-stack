package com.tokiomarine.transferencias.domain.fee;

import java.math.BigDecimal;

public interface FeeCalculatorStrategy {
    BigDecimal calculateFee(BigDecimal value);
}
