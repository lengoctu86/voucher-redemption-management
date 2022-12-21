package com.codingtask.voucherredemptionmanagement.config;

import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.repository.VoucherRepository;
import com.codingtask.voucherredemptionmanagement.service.VoucherService;
import com.codingtask.voucherredemptionmanagement.service.impl.LimitedRedemptionVoucherServiceImpl;
import com.codingtask.voucherredemptionmanagement.service.impl.MultiRedemptionVoucherServiceImpl;
import com.codingtask.voucherredemptionmanagement.service.impl.SingleRedemptionVoucherServiceImpl;
import com.codingtask.voucherredemptionmanagement.service.impl.XTimesRedemptionVoucherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class VoucherConfig {

    @Autowired
    private VoucherRepository voucherRepository;

    @Bean("voucherServiceMap")
    public Map<VoucherType, VoucherService> voucherServiceMap() {
        Map<VoucherType, VoucherService> voucherServiceMap = new HashMap<>();
        voucherServiceMap.put(VoucherType.SINGLE_REDEMPTION, new SingleRedemptionVoucherServiceImpl(voucherRepository));
        voucherServiceMap.put(VoucherType.MULTI_REDEMPTION, new MultiRedemptionVoucherServiceImpl(voucherRepository));
        voucherServiceMap.put(VoucherType.X_TIMES_REDEMPTION, new XTimesRedemptionVoucherServiceImpl(voucherRepository));
        voucherServiceMap.put(VoucherType.LIMITED_REDEMPTION, new LimitedRedemptionVoucherServiceImpl(voucherRepository));
        return voucherServiceMap;
    }
}
