package com.java.boilerplate.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.boilerplate.core.domain.service.account.UserAccountService;
import com.java.boilerplate.mock.UserTransactionMock;
import com.java.boilerplate.mock.UserTransactionResponseMock;
import com.java.boilerplate.mock.UserTransferRequestMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock private UserAccountService userAccountService;

    @BeforeEach
    void setup() {
        this.objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AccountController(userAccountService)).build();
    }

    @Test
    void should_executeGETTransactions_with_success() throws Exception {
        when(userAccountService.getUserTransactions(anyString())).thenReturn(UserTransactionMock.getSet());


        mockMvc.perform(get("/accounts/transactions/123"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(UserTransactionResponseMock.get())));
    }

    @Test
    void should_executeGETBalance_with_success() throws Exception {
        when(userAccountService.getBalance(anyString())).thenReturn(BigDecimal.TEN);

        mockMvc.perform(get("/accounts/balance/123"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(BigDecimal.TEN)));
    }

    @Test
    void should_executePOSTTransfer_with_success() throws Exception {
        doNothing().when(userAccountService).transfer(any());

        mockMvc.perform(post("/accounts/transfer")
                .content(objectMapper.writeValueAsString(UserTransferRequestMock.get()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
