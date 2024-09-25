package com.java.boilerplate.core.service;

import com.java.boilerplate.core.domain.service.account.UserAccountServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class UserAccountServiceTest {
    @InjectMocks UserAccountServiceImpl accountService;

    @Test
    void when_getUserTransactions_should_returnSuccess() {
        final var output = accountService.getUserTransactions("1");

        Assertions.assertEquals("1e33d2fa-0786-4bac-b625-1863fc21a335", output.stream().findFirst().get().getTransactionId());
        Assertions.assertEquals(BigDecimal.TEN, output.stream().findFirst().get().getAmount());
    }
}
