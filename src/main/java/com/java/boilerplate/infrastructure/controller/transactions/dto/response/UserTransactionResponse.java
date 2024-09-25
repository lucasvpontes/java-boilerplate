package com.java.boilerplate.infrastructure.controller.transactions.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserTransactionResponse {
  private String userId;
  private BigDecimal amount;
  private String executedTime;
  private String transactionId;
  private String senderId;
}







