package com.codingtask.voucherredemptionmanagement.entity;

import com.codingtask.voucherredemptionmanagement.constant.VoucherStatus;
import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.dto.VoucherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue
    @Type(type="uuid-char")
    private UUID voucherId;
    private String voucherName;
    private String description;
    private VoucherType voucherType;
    private Integer quantity;
    private VoucherStatus status;
    private LocalDateTime expiryDate;

    public VoucherDTO toVoucherDTO() {
        return VoucherDTO.builder()
                .voucherId(voucherId)
                .voucherName(voucherName)
                .voucherType(voucherType)
                .description(description)
                .quantity(quantity)
                .status(status)
                .expiryDate(expiryDate)
                .build();
    }
}
