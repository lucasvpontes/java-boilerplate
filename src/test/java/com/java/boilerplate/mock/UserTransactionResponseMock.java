package com.java.boilerplate.mock;

import com.java.boilerplate.infrastructure.controller.dto.response.UserTransactionResponse;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.util.Set;

@UtilityClass
public class UserTransactionResponseMock {
    public Set<UserTransactionResponse> get() {
        return Set.of(
                UserTransactionResponse.builder()
                        .transactionId("71879e60-a86e-4657-b906-17d27f647872")
                        .amount(BigDecimal.TEN)
                        .build(),
                UserTransactionResponse.builder()
                        .transactionId("71eeaa09-80fe-4073-85b1-d9e8b85e2446")
                        .amount(new BigDecimal(-1))
                        .build());
    }
}
