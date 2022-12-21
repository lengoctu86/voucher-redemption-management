package com.codingtask.voucherredemptionmanagement.service.impl;

import com.codingtask.voucherredemptionmanagement.constant.VoucherStatus;
import com.codingtask.voucherredemptionmanagement.dto.RedemptionDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherDTO;
import com.codingtask.voucherredemptionmanagement.dto.VoucherRequestDTO;
import com.codingtask.voucherredemptionmanagement.entity.Voucher;
import com.codingtask.voucherredemptionmanagement.exception.custom.VoucherNotFoundException;
import com.codingtask.voucherredemptionmanagement.repository.VoucherRepository;
import com.codingtask.voucherredemptionmanagement.service.VoucherService;
import com.codingtask.voucherredemptionmanagement.service.validator.MultiRedemptionVoucherValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MultiRedemptionVoucherServiceImpl extends MultiRedemptionVoucherValidator implements VoucherService {

    private final VoucherRepository voucherRepository;

    @Override
    public VoucherDTO createVoucher(VoucherRequestDTO dto) {
        validateMultiRedemptionVoucher(dto);
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
        if (existingVoucher == null) {
            throw new VoucherNotFoundException("Voucher not found");
        }
        return existingVoucher.toVoucherDTO();
    }

}
