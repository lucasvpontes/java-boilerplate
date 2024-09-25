package com.java.boilerplate.infrastructure.dto.request;

import java.math.BigDecimal;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserTransferRequest {
  private String receiverId;
  private String senderId;
  private BigDecimal amount;
}
