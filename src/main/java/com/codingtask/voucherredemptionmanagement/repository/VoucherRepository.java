package com.codingtask.voucherredemptionmanagement.repository;

import com.codingtask.voucherredemptionmanagement.constant.VoucherStatus;
import com.codingtask.voucherredemptionmanagement.constant.VoucherType;
import com.codingtask.voucherredemptionmanagement.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;


@Repository
public interface VoucherRepository extends JpaRepository<Voucher, String> {

    @Query(value = "select v from Voucher v where v.voucherName = :voucherName " +
            "and v.voucherType = :voucherType and v.status = :voucherStatus")
    Voucher findVoucherByNameAndType(@Param("voucherName") String voucherName,
                                               @Param("voucherType") VoucherType voucherType,
                                               @Param("voucherStatus") VoucherStatus voucherStatus);
}
