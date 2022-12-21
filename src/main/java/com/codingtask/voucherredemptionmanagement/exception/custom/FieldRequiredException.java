package com.codingtask.voucherredemptionmanagement.exception.custom;

public class FieldRequiredException extends RuntimeException {
    public FieldRequiredException(String message) {
        super(message);
    }
}
