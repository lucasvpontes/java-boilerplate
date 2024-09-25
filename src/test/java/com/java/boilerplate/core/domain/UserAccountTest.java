package com.java.boilerplate.core.domain;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserAccountTest {

  @Test
  public void when_transactionsAreEmpty_should_returnZero() {
    final var user = UserAccount.builder().userTransactions(Set.of()).build();

    Assertions.assertEquals(BigDecimal.ZERO, user.getBalance());
  }

  @Test
  public void when_transactionsArePositive_should_returnPositiveValue() {
    final var user =
        UserAccount.builder()
            .userTransactions(
                Set.of(
                    UserTransaction.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .amount(BigDecimal.TEN)
                        .build(),
                    UserTransaction.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .amount(new BigDecimal(-1))
                        .build())).build();

    Assertions.assertEquals(new BigDecimal(9), user.getBalance());
  }

  @Test
  public void when_transactionsArePositive_should_returnNegativeValue() {
    final var user =
        UserAccount.builder()
            .userTransactions(
                Set.of(
                    UserTransaction.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .amount(BigDecimal.ONE)
                        .build(),
                    UserTransaction.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .amount(new BigDecimal(-10))
                        .build())).build();

    Assertions.assertEquals(new BigDecimal(-9), user.getBalance());
  }
}
