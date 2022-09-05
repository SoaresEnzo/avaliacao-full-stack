package com.tokiomarine.transferencias.domain.transfer;

public class NoFeeAvaliableException extends RuntimeException {
    public NoFeeAvaliableException(String message) {
        super(message);
    }
}
