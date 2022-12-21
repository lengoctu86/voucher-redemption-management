package com.codingtask.voucherredemptionmanagement.exception.custom;

public class InvalidVoucherQuantityException extends RuntimeException {
    public InvalidVoucherQuantityException(String message) {
        super(message);
    }
}
