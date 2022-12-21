package com.codingtask.voucherredemptionmanagement.service.impl;

import com.codingtask.voucherredemptionmanagement.constant.VoucherStatus;
import com.codingtask.voucherredemptionmanagement.dto.RedemptionDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.entity.Voucher;
import com.codingtask.voucherredemptionmanagement.exception.custom.VoucherNotFoundException;
import com.codingtask.voucherredemptionmanagement.exception.custom.VoucherOutOfStockException;
import com.codingtask.voucherredemptionmanagement.repository.VoucherRepository;
import com.codingtask.voucherredemptionmanagement.service.VoucherService;
import com.codingtask.voucherredemptionmanagement.service.validator.XTimesRedemptionVoucherValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@AllArgsConstructor
@Transactional
public class XTimesRedemptionVoucherServiceImpl extends XTimesRedemptionVoucherValidator implements VoucherService {
    private final VoucherRepository voucherRepository;

    @Override
    public VoucherDTO createVoucher(VoucherRequestDTO dto) {
        validateXTimesRedemptionVoucher(dto);
        Voucher existingVoucher = voucherRepository.findVoucherByNameAndType(dto.getVoucherName(), dto.getVoucherType(), VoucherStatus.ACTIVE);
        if (existingVoucher == null) {
            return voucherRepository.save(dto.toVoucher())
                    .toVoucherDTO();
        }
        existingVoucher.setDescription(dto.getDescription());
        existingVoucher.setExpiryDate(dto.getExpiryDate());
        existingVoucher.setQuantity(existingVoucher.getQuantity() + dto.getQuantity());
        return voucherRepository.save(existingVoucher)
                .toVoucherDTO();
    }

    @Override
    public VoucherDTO redeemVoucher(RedemptionDTO dto) {
        Voucher existingVoucher = voucherRepository.findVoucherByNameAndType(dto.getVoucherName(), dto.getVoucherType(), VoucherStatus.ACTIVE);
        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        if (existingVoucher == null) {
            throw new VoucherNotFoundException("Voucher not found");
        }
        if (existingVoucher.getQuantity() == 0) {
            throw new VoucherOutOfStockException("Voucher is out of stock");
        }
        Integer updatedQuantity = existingVoucher.getQuantity() - 1;
        if (updatedQuantity == 0) {
            existingVoucher.setStatus(VoucherStatus.OUT_OF_STOCK);
        }
        existingVoucher.setQuantity(updatedQuantity);
        return voucherRepository.save(existingVoucher)
                .toVoucherDTO();
    }
}
