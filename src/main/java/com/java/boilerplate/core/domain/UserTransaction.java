package com.java.boilerplate.core.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserTransaction {
  private String userId;
  private BigDecimal amount;
  private Instant executedTime;
  private String transactionId;
  private String senderId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserTransaction that = (UserTransaction) o;
    return Objects.equals(transactionId, that.transactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId);
  }
}
