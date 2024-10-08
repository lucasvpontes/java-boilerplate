package com.java.boilerplate.core.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserAccount {
  private String userId;
  private Set<UserTransaction> userTransactions;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserAccount user = (UserAccount) o;
    return Objects.equals(userId, user.userId) && Objects.equals(userTransactions, user.userTransactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, userTransactions);
  }

  public BigDecimal getBalance() {
    return this.userTransactions.stream()
        .map(UserTransaction::getAmount)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }
}
