package com.abhijit.websvclient;

import com.abhijit.websvclient.client.AccountSvcClient;
import com.abhijit.websvclient.dto.AccountDTO;
import com.abhijit.websvclient.dto.AccountStatus;
import com.abhijit.websvclient.dto.AccountType;
import com.abhijit.websvclient.dto.AddAccountDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class TestWebClient {
    @Autowired
    private AccountSvcClient accountSvcClient;

    private AddAccountDTO addAccountDTO;

    @BeforeAll
    public void setup() {
        List<String> notes = new ArrayList<>();
        notes.add("automation test note 1");
        addAccountDTO = new AddAccountDTO(AccountType.SAVING, "Cust 1", notes, AccountStatus.ACTIVE, "NA");
    }
    @Test
    @DisplayName("Add account test")
    void addAcTest() throws JsonProcessingException {
             AccountDTO addAc=accountSvcClient.add(addAccountDTO);
            Assertions.assertTrue(addAc.getAccountId()!=null);
        }
    }
