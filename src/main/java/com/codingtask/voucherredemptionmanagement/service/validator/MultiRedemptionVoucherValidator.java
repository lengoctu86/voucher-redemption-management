package com.codingtask.voucherredemptionmanagement.service.validator;

import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.exception.custom.InvalidInputException;
import com.codingtask.voucherredemptionmanagement.exception.custom.InvalidVoucherQuantityException;
import com.codingtask.voucherredemptionmanagement.exception.custom.VoucherTypeException;
import com.codingtask.voucherredemptionmanagement.service.validator.basevalidator.VoucherValidator;

public class MultiRedemptionVoucherValidator extends VoucherValidator {
    public void validateMultiRedemptionVoucher(VoucherRequestDTO dto) {
        validateVoucher(dto);
        if (dto.getVoucherType() != VoucherType.MULTI_REDEMPTION) {
            throw new VoucherTypeException("Voucher type should be " + VoucherType.MULTI_REDEMPTION);
        }
        if (dto.getExpiryDate() != null) {
            throw new InvalidInputException("Multi-redemption voucher should not have expiry date");
        }
        if (dto.getQuantity() != 1) {
            throw new InvalidVoucherQuantityException("Multiple redemption voucher quantity should be '1'");
        }
    }
}
