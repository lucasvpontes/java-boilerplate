package com.java.boilerplate.core.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import com.java.boilerplate.core.domain.account.UserTransaction;
import com.java.boilerplate.core.service.account.UserAccountServiceImpl;
import com.java.boilerplate.infrastructure.dao.account.UserAccountDao;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {
    @InjectMocks UserAccountServiceImpl accountService;

    @Mock UserAccountDao accountDao;

    @Test
    void when_getUserTransactions_should_returnSuccess() {

        Mockito.when(accountDao.getTransactionsByReceiverId(anyString())).thenReturn(Set.of(UserTransaction.builder()
            .transactionId("1e33d2fa-0786-4bac-b625-1863fc21a335")
            .amount(BigDecimal.TEN)
            .build()));

        final var output = accountService.getUserTransactions("1");

        Assertions.assertEquals("1e33d2fa-0786-4bac-b625-1863fc21a335", output.stream().toList().get(0).getTransactionId());
        Assertions.assertEquals(BigDecimal.TEN, output.stream().toList().get(0).getAmount());
    }
}
