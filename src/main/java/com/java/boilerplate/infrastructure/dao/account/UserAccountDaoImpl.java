package com.java.boilerplate.infrastructure.dao.account;

import com.java.boilerplate.core.domain.UserAccount;
import com.java.boilerplate.core.domain.UserTransaction;
import com.java.boilerplate.infrastructure.repository.AccountTransactionRepository;
import com.java.boilerplate.infrastructure.util.MapperUtils;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserAccountDaoImpl implements UserAccountDao {

    private final AccountTransactionRepository accountTransactionRepository;

    @Override
    public Set<UserTransaction> getTransactionsByReceiverId(String receiverId) {
        return accountTransactionRepository.findByReceiverId(receiverId).stream()
                        .map(accountTransactionEntity -> MapperUtils.map(accountTransactionEntity, UserTransaction.class))
                        .collect(Collectors.toSet());
    }
}
