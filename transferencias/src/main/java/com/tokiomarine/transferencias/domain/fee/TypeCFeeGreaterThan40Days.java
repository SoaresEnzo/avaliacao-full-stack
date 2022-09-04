package com.tokiomarine.transferencias.domain.fee;

import java.math.BigDecimal;

public class TypeCFeeGreaterThan40Days implements FeeCalculatorStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal value) {
        return value.multiply(new BigDecimal("0.017"));
    }
}
