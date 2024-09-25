package com.java.boilerplate.core.domain.service.account;

import com.java.boilerplate.core.domain.UserAccount;
import com.java.boilerplate.core.domain.UserTransaction;
import com.java.boilerplate.infrastructure.dto.request.UserTransferRequest;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
  @Override
  public Set<UserTransaction> getUserTransactions(String userId) {
    // search for user

    return getUserAccount().getUserTransactions();
  }

  @Override
  public BigDecimal getBalance(String userId) {
    return getUserAccount().getBalance();
  }

  @Override
  @Transactional
  public void transfer(UserTransferRequest transferRequest) {

  }

  private static UserAccount getUserAccount() {
    return UserAccount.builder()
        .id(UUID.randomUUID().toString())
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
  }
}
