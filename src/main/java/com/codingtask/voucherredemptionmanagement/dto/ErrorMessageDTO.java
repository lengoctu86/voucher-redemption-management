package com.codingtask.voucherredemptionmanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessageDTO {
    private String errorCode;
    private String message;
}
