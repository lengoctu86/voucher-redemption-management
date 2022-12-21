package com.codingtask.voucherredemptionmanagement.service.validator;

import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.exception.custom.FieldRequiredException;
import com.codingtask.voucherredemptionmanagement.exception.custom.InvalidVoucherQuantityException;
import com.codingtask.voucherredemptionmanagement.exception.custom.VoucherTypeException;
import com.codingtask.voucherredemptionmanagement.service.validator.basevalidator.VoucherValidator;

public class LimitedRedemptionVoucherValidator extends VoucherValidator {
    public void validateLimitedRedemptionVoucher(VoucherRequestDTO dto) {
        validateVoucher(dto);
        if (dto.getVoucherType() != VoucherType.LIMITED_REDEMPTION) {
            throw new VoucherTypeException("Voucher type should be " + VoucherType.LIMITED_REDEMPTION);
        }
        if (dto.getExpiryDate() == null) {
            throw new FieldRequiredException("Limited redemption voucher must have expiry date");
        }
        if (dto.getQuantity() < 1) {
            throw new InvalidVoucherQuantityException("Limited redemption voucher quantity should be greater than '0'");
        }
    }
}
