package com.java.boilerplate.infrastructure.dao.account;

import com.java.boilerplate.core.domain.UserTransaction;

import java.util.Set;

public interface UserAccountDao {
    Set<UserTransaction> getTransactionsByReceiverId(String receiverId);
}
