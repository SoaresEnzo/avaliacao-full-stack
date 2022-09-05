package com.tokiomarine.transferencias.application.adapters.config;

import com.tokiomarine.transferencias.domain.errors.NoFeeAvaliableException;
import com.tokiomarine.transferencias.domain.errors.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    private ResponseEntity<ErrorDTO> handleNoFeeAvailable(Exception ex) {
        return ResponseEntity.badRequest().body(new ErrorDTO("400", ex.getMessage()));
    }
}
