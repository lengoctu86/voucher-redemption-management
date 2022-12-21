package com.codingtask.voucherredemptionmanagement.service;

import com.codingtask.voucherredemptionmanagement.constant.VoucherStatus;
import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.dto.RedemptionDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.entity.Voucher;
import com.codingtask.voucherredemptionmanagement.repository.VoucherRepository;
import com.codingtask.voucherredemptionmanagement.service.impl.LimitedRedemptionVoucherServiceImpl;
import com.codingtask.voucherredemptionmanagement.service.impl.MultiRedemptionVoucherServiceImpl;
import com.codingtask.voucherredemptionmanagement.service.impl.SingleRedemptionVoucherServiceImpl;
import com.codingtask.voucherredemptionmanagement.service.impl.XTimesRedemptionVoucherServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
class VoucherServiceTest {

    @Autowired
    private VoucherRepository voucherRepository;

    private VoucherService voucherService;


    @Test
    void createLimitedRedemptionVoucherTest() {
        voucherService = new LimitedRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.LIMITED_REDEMPTION)
                .expiryDate(LocalDateTime.now())
                .quantity(1)
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        Assert.assertEquals(voucherDTO.getVoucherName(), "some_voucher");
        Assert.assertEquals(voucherDTO.getVoucherType(), VoucherType.LIMITED_REDEMPTION);
    }

    @Test
    void createSingleRedemptionVoucherTest() {
        voucherService = new SingleRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.SINGLE_REDEMPTION)
                .quantity(1)
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        Assert.assertEquals(voucherDTO.getVoucherName(), "some_voucher");
        Assert.assertEquals(voucherDTO.getVoucherType(), VoucherType.SINGLE_REDEMPTION);

    }

    @Test
    void createMultiRedemptionVoucherTest() {
        voucherService = new MultiRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.MULTI_REDEMPTION)
                .quantity(1)
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        Assert.assertEquals(voucherDTO.getVoucherName(), "some_voucher");
        Assert.assertEquals(voucherDTO.getVoucherType(), VoucherType.MULTI_REDEMPTION);
    }

    @Test
    void createXTimesRedemptionVoucherTest() {
        voucherService = new XTimesRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.X_TIMES_REDEMPTION)
                .quantity(1)
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        Assert.assertEquals(voucherDTO.getVoucherName(), "some_voucher");
        Assert.assertEquals(voucherDTO.getVoucherType(), VoucherType.X_TIMES_REDEMPTION);
    }

    @Test
    void redeemXTimesRedemptionVoucherVoucherTest() {
        voucherService = new XTimesRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.X_TIMES_REDEMPTION)
                .quantity(1)
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        RedemptionDTO redemptionDTO = RedemptionDTO.builder()
                .voucherName(voucherDTO.getVoucherName())
                .voucherType(voucherDTO.getVoucherType())
                .build();
        VoucherDTO inStockVoucherDTO = voucherService.redeemVoucher(redemptionDTO);
        Assert.assertEquals(inStockVoucherDTO.getVoucherName(), voucherDTO.getVoucherName());
        Assert.assertEquals(inStockVoucherDTO.getVoucherType(), VoucherType.X_TIMES_REDEMPTION);
        Assert.assertEquals(inStockVoucherDTO.getQuantity(), (Integer) (voucherDTO.getQuantity() - 1));
        Assert.assertEquals(inStockVoucherDTO.getStatus(), VoucherStatus.OUT_OF_STOCK);
    }

    @Test
    void redeemMultiRedemptionVoucherTest() {
        voucherService = new MultiRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.MULTI_REDEMPTION)
                .quantity(1)
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        RedemptionDTO redemptionDTO = RedemptionDTO.builder()
                .voucherName(voucherDTO.getVoucherName())
                .voucherType(voucherDTO.getVoucherType())
                .build();
        VoucherDTO inStockVoucherDTO = voucherService.redeemVoucher(redemptionDTO);
        Assert.assertEquals(inStockVoucherDTO.getVoucherName(), voucherDTO.getVoucherName());
        Assert.assertEquals(inStockVoucherDTO.getVoucherType(), VoucherType.MULTI_REDEMPTION);
        Assert.assertEquals(inStockVoucherDTO.getQuantity(), voucherDTO.getQuantity());
        Assert.assertEquals(inStockVoucherDTO.getStatus(), VoucherStatus.ACTIVE);
    }

    @Test
    void redeemSingleRedemptionVoucherTest() {
        voucherService = new SingleRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.SINGLE_REDEMPTION)
                .quantity(1)
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        RedemptionDTO redemptionDTO = RedemptionDTO.builder()
                .voucherName(voucherDTO.getVoucherName())
                .voucherType(voucherDTO.getVoucherType())
                .build();
        VoucherDTO inStockVoucherDTO = voucherService.redeemVoucher(redemptionDTO);
        Assert.assertEquals(inStockVoucherDTO.getVoucherName(), voucherDTO.getVoucherName());
        Assert.assertEquals(inStockVoucherDTO.getVoucherType(), VoucherType.SINGLE_REDEMPTION);
        Assert.assertEquals(inStockVoucherDTO.getQuantity(), (Integer) (voucherDTO.getQuantity() - 1));
        Assert.assertEquals(inStockVoucherDTO.getStatus(), VoucherStatus.OUT_OF_STOCK);
    }

    @Test
    void redeemLimitedRedemptionVoucherTest() {
        voucherService = new LimitedRedemptionVoucherServiceImpl(voucherRepository);
        VoucherRequestDTO voucherRequestDTO = VoucherRequestDTO.builder()
                .voucherName("some_voucher")
                .description("some_description")
                .voucherType(VoucherType.LIMITED_REDEMPTION)
                .quantity(1)
                .expiryDate(LocalDateTime.now().plusDays(1))
                .build();
        VoucherDTO voucherDTO = voucherService.createVoucher(voucherRequestDTO);
        RedemptionDTO redemptionDTO = RedemptionDTO.builder()
                .voucherName(voucherDTO.getVoucherName())
                .voucherType(voucherDTO.getVoucherType())
                .build();
        VoucherDTO inStockVoucherDTO = voucherService.redeemVoucher(redemptionDTO);
        Assert.assertEquals(inStockVoucherDTO.getVoucherName(), voucherDTO.getVoucherName());
        Assert.assertEquals(inStockVoucherDTO.getVoucherType(), VoucherType.LIMITED_REDEMPTION);
        Assert.assertEquals(inStockVoucherDTO.getQuantity(), (Integer) (voucherDTO.getQuantity() - 1));
        Assert.assertEquals(inStockVoucherDTO.getStatus(), VoucherStatus.OUT_OF_STOCK);
    }
}