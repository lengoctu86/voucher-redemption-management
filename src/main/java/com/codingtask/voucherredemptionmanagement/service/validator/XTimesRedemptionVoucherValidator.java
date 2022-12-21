package com.codingtask.voucherredemptionmanagement.service.validator;

import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.exception.custom.InvalidInputException;
import com.codingtask.voucherredemptionmanagement.exception.custom.InvalidVoucherQuantityException;
import com.codingtask.voucherredemptionmanagement.exception.custom.VoucherTypeException;
import com.codingtask.voucherredemptionmanagement.service.validator.basevalidator.VoucherValidator;

public class XTimesRedemptionVoucherValidator extends VoucherValidator {
    public void validateXTimesRedemptionVoucher(VoucherRequestDTO dto) {
        validateVoucher(dto);
        if (dto.getVoucherType() != VoucherType.X_TIMES_REDEMPTION) {
            throw new VoucherTypeException("Voucher type should be " + VoucherType.X_TIMES_REDEMPTION);
        }
        if (dto.getExpiryDate() != null) {
            throw new InvalidInputException("X-times redemption voucher should not have expiry date");
        }
        if (dto.getQuantity() < 1) {
            throw new InvalidVoucherQuantityException("X-times redemption voucher quantity should be greater than '0'");
        }
    }
}
