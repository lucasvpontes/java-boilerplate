package com.java.boilerplate.core.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// TODO: fix h2
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_transactions")
public class AccountTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "receiver_id")
    private String receiverId;

    @Column(name = "amount")
    private BigDecimal amount;

    // change it to Timestamp in the future
    @Column(name = "executed_time")
    private LocalDateTime executedTime;
}
