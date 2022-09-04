package com.tokiomarine.transferencias.domain.fee;

import java.math.BigDecimal;

public class TypeBFee implements FeeCalculatorStrategy {
    @Override
    public BigDecimal calculateFee(BigDecimal value) {
        return new BigDecimal("12");
    }
}
