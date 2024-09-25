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
        .userId("76cb94ca-5e89-499a-8c04-4294a04eb900")
        .userTransactions(
            Set.of(
                UserTransaction.builder()
                    .transactionId("1e33d2fa-0786-4bac-b625-1863fc21a335")
                    .amount(BigDecimal.TEN)
                    .build(),
                UserTransaction.builder()
                    .transactionId("5e563fe6-0b98-4a17-9515-39b335ec86b1")
                    .amount(new BigDecimal(-1))
                    .build())).build();
  }
}
