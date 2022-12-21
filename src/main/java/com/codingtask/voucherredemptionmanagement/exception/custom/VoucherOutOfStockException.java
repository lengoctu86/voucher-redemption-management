package com.codingtask.voucherredemptionmanagement.exception.custom;

public class VoucherOutOfStockException extends RuntimeException {
    public VoucherOutOfStockException(String message) {
        super(message);
    }
}
