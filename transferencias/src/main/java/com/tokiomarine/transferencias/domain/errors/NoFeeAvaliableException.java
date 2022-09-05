package com.tokiomarine.transferencias.domain.errors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseStatus;
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoFeeAvaliableException extends RuntimeException {
    private String message;

    public NoFeeAvaliableException() {
        super();
    }

    public NoFeeAvaliableException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
