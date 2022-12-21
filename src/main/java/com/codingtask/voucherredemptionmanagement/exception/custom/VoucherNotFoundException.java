package com.codingtask.voucherredemptionmanagement.exception.custom;

public class VoucherNotFoundException extends RuntimeException {
    public VoucherNotFoundException(String message) {
        super(message);
    }
}
