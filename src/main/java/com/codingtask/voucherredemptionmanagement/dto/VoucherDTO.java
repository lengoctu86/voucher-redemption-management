package com.codingtask.voucherredemptionmanagement.dto;

import com.codingtask.voucherredemptionmanagement.constant.VoucherStatus;
import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.entity.Voucher;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class VoucherDTO {
    private UUID voucherId;
    private String voucherName;
    private String description;
    private VoucherType voucherType;
    private Integer quantity;
    private VoucherStatus status;
    private LocalDateTime expiryDate;
}
