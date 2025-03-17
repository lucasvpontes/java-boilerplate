package com.java.boilerplate.mock;

import com.java.boilerplate.core.domain.entity.account.AccountTransactionEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountTransactionEntityMock {
  public AccountTransactionEntity get() {
    return AccountTransactionEntity.builder()
            .transactionId("18d536ca-1c77-4a54-94e0-84dbc5a9bab6")
            .amount(BigDecimal.TEN)
            .executedTime(LocalDateTime.of(2025,3,16,1,0).toInstant(ZoneOffset.UTC))
            .id(1L)
            .senderId("5dfba1fb-3e95-4829-b9ac-f16dbe927711")
            .receiverId("3034276a-4222-40fe-9293-18a6324fd138")
            .build();
  }
}
