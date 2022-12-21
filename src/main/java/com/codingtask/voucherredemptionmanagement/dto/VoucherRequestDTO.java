package com.codingtask.voucherredemptionmanagement.dto;

import com.codingtask.voucherredemptionmanagement.constant.VoucherStatus;
import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.entity.Voucher;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class VoucherRequestDTO {
    private String voucherName;
    private String description;
    private VoucherType voucherType;
    private Integer quantity;
    private LocalDateTime expiryDate;

    public Voucher toVoucher() {
        return Voucher.builder()
                .voucherName(voucherName)
                .description(description)
                .voucherType(voucherType)
                .quantity(quantity)
                .status(VoucherStatus.ACTIVE)
                .expiryDate(expiryDate)
                .build();
    }
}
