package com.codingtask.voucherredemptionmanagement.service.validator.basevalidator;

import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.exception.custom.FieldRequiredException;
import org.springframework.util.StringUtils;

public class VoucherValidator {
    public void validateVoucher(VoucherRequestDTO dto) {
        if (StringUtils.isEmpty(dto.getVoucherName())) {
            throw new FieldRequiredException("Voucher name is required");
        }
    }
}
