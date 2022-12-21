package com.codingtask.voucherredemptionmanagement.service;

import com.codingtask.voucherredemptionmanagement.dto.RedemptionDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;

import java.util.List;

public interface VoucherService {
    VoucherDTO createVoucher(VoucherRequestDTO dto);
    VoucherDTO redeemVoucher(RedemptionDTO dto);
}
