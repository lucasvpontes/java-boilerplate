package com.java.boilerplate.infrastructure.controller.transactions.dto.response;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
  private String id;
  private Set<UserTransactionResponse> userTransactionResponse;
}
