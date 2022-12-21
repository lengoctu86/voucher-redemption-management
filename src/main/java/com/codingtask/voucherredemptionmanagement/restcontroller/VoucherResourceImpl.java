package com.codingtask.voucherredemptionmanagement.restcontroller;

import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.dto.RedemptionDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/voucher")
public class VoucherResourceImpl implements VoucherResource {
    @Autowired
    private Map<VoucherType, VoucherService> voucherServiceMap;

    @Override
    @PostMapping("/create")
    public VoucherDTO createVoucher(@RequestBody VoucherRequestDTO dto) {
        return voucherServiceMap.get(dto.getVoucherType())
                .createVoucher(dto);
    }

    @Override
    @PostMapping("/redeem")
    public VoucherDTO redeemVoucher(@RequestBody RedemptionDTO dto) {
        return voucherServiceMap.get(dto.getVoucherType())
                .redeemVoucher(dto);
    }

}
