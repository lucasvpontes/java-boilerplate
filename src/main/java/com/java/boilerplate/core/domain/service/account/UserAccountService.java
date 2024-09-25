package com.java.boilerplate.core.domain.service.account;

import com.java.boilerplate.core.domain.UserTransaction;
import com.java.boilerplate.infrastructure.dto.request.UserTransferRequest;
import java.math.BigDecimal;
import java.util.Set;
public interface UserAccountService {
  Set<UserTransaction> getUserTransactions(String userId);

  BigDecimal getBalance(String userId);

  void transfer(UserTransferRequest transferRequest);
}
