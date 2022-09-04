package com.tokiomarine.transferencias.domain.fee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TypeAFee implements FeeCalculatorStrategy{
    @Override
    public BigDecimal calculateFee(BigDecimal value) {
        return value.multiply(new BigDecimal("0.03")).add(new BigDecimal(3));
    }
}
