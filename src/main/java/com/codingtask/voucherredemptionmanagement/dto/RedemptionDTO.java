package com.codingtask.voucherredemptionmanagement.dto;

import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RedemptionDTO {
    private VoucherType voucherType;
    private String voucherName;
}
