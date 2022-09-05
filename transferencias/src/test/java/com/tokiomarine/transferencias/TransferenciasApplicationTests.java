package com.tokiomarine.transferencias;

import com.tokiomarine.transferencias.domain.errors.NoFeeAvaliableException;
import com.tokiomarine.transferencias.domain.errors.dto.ErrorDTO;
import com.tokiomarine.transferencias.domain.transfer.dtos.TransferRequestBodyDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class TransferenciasApplicationTests {

    @Autowired
    protected TestRestTemplate rest;

    @Test
    void scheduleTransferShouldReturn201WhenTransferIsValid() {
        TransferRequestBodyDTO body = new TransferRequestBodyDTO("XXXXXX", "YYYYYY", new BigDecimal("100"), LocalDate.now(), LocalDate.now());
        ResponseEntity response = rest.postForEntity("/transfer", body, null);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }


}
