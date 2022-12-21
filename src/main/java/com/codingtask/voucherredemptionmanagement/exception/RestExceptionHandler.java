package com.codingtask.voucherredemptionmanagement.exception;

import com.codingtask.voucherredemptionmanagement.dto.ErrorMessageDTO;
import com.codingtask.voucherredemptionmanagement.exception.custom.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.codingtask.voucherredemptionmanagement.constant.ErrorCode.*;

@RestControllerAdvice
public class RestExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(VoucherNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handleApiException(VoucherNotFoundException e) {
        ErrorMessageDTO errorMessage = ErrorMessageDTO.builder()
                .errorCode(VOUCHER_NOT_FOUND.name())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(VoucherExpiredException.class)
    public ResponseEntity<ErrorMessageDTO> handleApiException(VoucherExpiredException e) {
        ErrorMessageDTO errorMessage = ErrorMessageDTO.builder()
                .errorCode(VOUCHER_EXPIRED.name())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(VoucherOutOfStockException.class)
    public ResponseEntity<ErrorMessageDTO> handleApiException(VoucherOutOfStockException e) {
        ErrorMessageDTO errorMessage = ErrorMessageDTO.builder()
                .errorCode(VOUCHER_OUT_OF_STOCK.name())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<ErrorMessageDTO> handleApiException(FieldRequiredException e) {
        ErrorMessageDTO errorMessage = ErrorMessageDTO.builder()
                .errorCode(MANDATORY_FIELD_REQUIRED.name())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorMessageDTO> handleApiException(InvalidInputException e) {
        ErrorMessageDTO errorMessage = ErrorMessageDTO.builder()
                .errorCode(INVALID_INPUT_FIELD.name())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidVoucherQuantityException.class)
    public ResponseEntity<ErrorMessageDTO> handleApiException(InvalidVoucherQuantityException e) {
        ErrorMessageDTO errorMessage = ErrorMessageDTO.builder()
                .errorCode(INVALID_VOUCHER_QUANTITY.name())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(VoucherTypeException.class)
    public ResponseEntity<ErrorMessageDTO> handleApiException(VoucherTypeException e) {
        ErrorMessageDTO errorMessage = ErrorMessageDTO.builder()
                .errorCode(INVALID_VOUCHER_TYPE.name())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}