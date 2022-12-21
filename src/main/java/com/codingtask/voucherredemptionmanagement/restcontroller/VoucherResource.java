package com.codingtask.voucherredemptionmanagement.restcontroller;

import com.codingtask.voucherredemptionmanagement.dto.RedemptionDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import io.swagger.annotations.ApiOperation;

public interface VoucherResource {
    @ApiOperation(value ="Create a voucher", response = VoucherDTO.class)
    VoucherDTO createVoucher(VoucherRequestDTO dto);
    @ApiOperation(value ="Redeem a voucher", response = VoucherDTO.class)
    VoucherDTO redeemVoucher(RedemptionDTO dto);
}
