package com.java.boilerplate.infrastructure.controller.transactions;

import com.java.boilerplate.core.domain.service.account.UserAccountService;
import com.java.boilerplate.infrastructure.controller.transactions.dto.response.UserTransactionResponse;
import com.java.boilerplate.infrastructure.dto.request.UserTransferRequest;
import com.java.boilerplate.infrastructure.util.MapperUtils;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

  private final UserAccountService userAccountService;
  @GetMapping("/transactions/{userId}")
  public ResponseEntity<Set<UserTransactionResponse>> getUserTransactions(@PathVariable String userId) {
    final var transactionResponse = userAccountService.getUserTransactions(userId)
        .stream().map(userTransaction -> MapperUtils.map(userTransaction, UserTransactionResponse.class))
        .collect(Collectors.toSet());

      return ResponseEntity.ok().body(transactionResponse);
  }

  @GetMapping("/balance/{userId}")
  public ResponseEntity<BigDecimal> getBalance(@PathVariable String userId) {
    final var balance = userAccountService.getBalance(userId);
    return ResponseEntity.ok().body(balance);
  }

  @PostMapping("/transfer")
  public ResponseEntity<?> transfer(@RequestBody UserTransferRequest request) {
    userAccountService.transfer(request);
    return ResponseEntity.ok().build();
  }
}
