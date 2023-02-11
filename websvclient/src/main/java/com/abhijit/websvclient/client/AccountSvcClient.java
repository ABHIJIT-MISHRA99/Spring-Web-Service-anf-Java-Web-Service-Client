package com.abhijit.websvclient.client;

import com.abhijit.websvclient.dto.AccountDTO;
import com.abhijit.websvclient.dto.AddAccountDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface AccountSvcClient {
    AccountDTO add(AddAccountDTO addAccountDTO) throws JsonProcessingException;

}
