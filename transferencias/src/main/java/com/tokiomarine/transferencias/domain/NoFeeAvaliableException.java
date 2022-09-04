package com.tokiomarine.transferencias.domain;

public class NoFeeAvaliableException extends RuntimeException {
    public NoFeeAvaliableException(String message) {
        super(message);
    }
}
