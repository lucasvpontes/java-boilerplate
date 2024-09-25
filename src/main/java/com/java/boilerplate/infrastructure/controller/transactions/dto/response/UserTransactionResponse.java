package com.java.boilerplate.infrastructure.controller.transactions.dto.response;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class UserTransactionResponse {
  private String userId;
  private BigDecimal amount;
  private Instant executedTime;
  private String transactionId;
  private String senderId;
}
