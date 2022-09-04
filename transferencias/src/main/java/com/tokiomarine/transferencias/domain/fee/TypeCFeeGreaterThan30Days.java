package com.tokiomarine.transferencias.domain.fee;

import java.math.BigDecimal;

public class TypeCFeeGreaterThan30Days implements FeeCalculatorStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal value) {
        return value.multiply(new BigDecimal("0.047"));
    }
}
