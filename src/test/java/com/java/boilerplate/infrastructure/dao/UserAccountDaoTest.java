package com.java.boilerplate.infrastructure.dao;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.java.boilerplate.core.domain.account.UserTransaction;
import com.java.boilerplate.core.domain.entity.account.AccountTransactionEntity;
import com.java.boilerplate.infrastructure.dao.account.UserAccountDaoImpl;
import com.java.boilerplate.infrastructure.repository.AccountTransactionRepository;
import com.java.boilerplate.mock.AccountTransactionEntityMock;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserAccountDaoTest {
  @Mock AccountTransactionRepository repository;

  @InjectMocks UserAccountDaoImpl dao;

  @Test
  void should_getAccountTransaction_with_repositoryWithSuccess() {
    when(repository.findByReceiverId(anyString())).thenReturn(List.of(AccountTransactionEntityMock.get()));

    UserTransaction response = dao.getTransactionsByReceiverId(UUID.randomUUID().toString()).stream().findAny().get();

    Assertions.assertEquals("18d536ca-1c77-4a54-94e0-84dbc5a9bab6", response.getTransactionId());
    Assertions.assertEquals(BigDecimal.TEN, response.getAmount());
    Assertions.assertEquals(LocalDateTime.of(2025,3,16,1,0).toInstant(ZoneOffset.UTC),
            response.getExecutedTime());
    Assertions.assertEquals("5dfba1fb-3e95-4829-b9ac-f16dbe927711", response.getSenderId());
    Assertions.assertEquals("3034276a-4222-40fe-9293-18a6324fd138", response.getReceiverId());
  }
}
