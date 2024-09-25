package com.java.boilerplate.mock;

import com.java.boilerplate.infrastructure.dto.request.UserTransferRequest;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class UserTransferRequestMock {
    public UserTransferRequest get() {
        return UserTransferRequest.builder()
                .senderId("5e5bc24c-44dc-4154-b48c-20e4cbbfcd72")
                .amount(BigDecimal.TEN)
                .receiverId("bdb46fb4-4847-4664-b643-5f5ac53f68c8")
                .build();
    }
}
