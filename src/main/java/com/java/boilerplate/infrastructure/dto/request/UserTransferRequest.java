package com.java.boilerplate.infrastructure.dto.request;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class UserTransferRequest {
  private final String receiverId;
  private final String senderId;
  private final BigDecimal amount;
}
