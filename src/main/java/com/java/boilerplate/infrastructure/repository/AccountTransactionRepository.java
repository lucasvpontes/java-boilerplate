package com.java.boilerplate.infrastructure.repository;


import com.java.boilerplate.core.domain.entity.AccountTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransactionEntity, Long> {
    List<AccountTransactionEntity> findByReceiverId(String receiverId);
}
