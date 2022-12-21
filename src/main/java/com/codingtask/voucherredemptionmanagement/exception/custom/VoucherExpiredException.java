package com.codingtask.voucherredemptionmanagement.exception.custom;

public class VoucherExpiredException extends RuntimeException {
    public VoucherExpiredException(String message) {
        super(message);
    }
}
