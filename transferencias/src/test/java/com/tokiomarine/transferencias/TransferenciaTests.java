package com.tokiomarine.transferencias;


import com.tokiomarine.transferencias.domain.Transferencia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferenciaTests {

    //A: Tranferências no mesmo dia do agendamento tem uma taxa de $3 mais 3% do valor a ser transferido;
    @Test
    void validateFeeOfTransferenciaTypeA() {
        LocalDate today = LocalDate.now();
        Transferencia transferencia = new Transferencia("XXXXXX", "YYYYYY", new BigDecimal(100), today,  today);
        Assertions.assertEquals(106L, transferencia.getFee().longValue());
    }

    // B: Tranferências até 10 dias da data de agendamento possuem uma taxa de $12.
    @Test
    void validateFeeOfTransferenciaTypeB() {
        LocalDate today = LocalDate.now();
        LocalDate futureDay = LocalDate.now().plusDays(5);
        Transferencia transferencia = new Transferencia("XXXXXX", "YYYYYY", new BigDecimal(100), today,  futureDay);
        Assertions.assertEquals(112L, transferencia.getFee().longValue());
    }

    // acima de 10 dias da data de agendamento 8.2%
    @Test
    void validateFeeOfTransferenciaTypeCWithMoreThan10Days() {
        LocalDate today = LocalDate.now();
        LocalDate futureDay = LocalDate.now().plusDays(15);
        Transferencia transferencia = new Transferencia("XXXXXX", "YYYYYY", new BigDecimal(100), today,  futureDay);
        Assertions.assertEquals(108.2, transferencia.getFee().floatValue());
    }

    // acima de 20 dias da data de agendamento 6.9%
    @Test
    void validateFeeOfTransferenciaTypeCWithMoreThan20Days() {
        LocalDate today = LocalDate.now();
        LocalDate futureDay = LocalDate.now().plusDays(25);
        Transferencia transferencia = new Transferencia("XXXXXX", "YYYYYY", new BigDecimal(100), today,  futureDay);
        Assertions.assertEquals(106.9, transferencia.getFee().floatValue());
    }

    // acima de 30 dias da data de agendamento 4.7%
    @Test
    void validateFeeOfTransferenciaTypeCWithMoreThan30Days() {
        LocalDate today = LocalDate.now();
        LocalDate futureDay = LocalDate.now().plusDays(35);
        Transferencia transferencia = new Transferencia("XXXXXX", "YYYYYY", new BigDecimal(100), today,  futureDay);
        Assertions.assertEquals(104.7, transferencia.getFee().floatValue());
    }

    // acima de 40 dias da data de agendamento 1.7%
    @Test
    void validateFeeOfTransferenciaTypeCWithMoreThan40Days() {
        LocalDate today = LocalDate.now();
        LocalDate futureDay = LocalDate.now().plusDays(45);
        Transferencia transferencia = new Transferencia("XXXXXX", "YYYYYY", new BigDecimal(100), today,  futureDay);
        Assertions.assertEquals(101.7, transferencia.getFee().floatValue());
    }
}
