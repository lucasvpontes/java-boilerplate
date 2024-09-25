package com.java.boilerplate.infrastructure.controller.dto.response;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {
  private String id;
  private Set<UserTransactionResponse> userTransactionResponse;
}
