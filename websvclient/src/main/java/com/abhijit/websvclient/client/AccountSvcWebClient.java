package com.abhijit.websvclient.client;

import com.abhijit.websvclient.config.AppProperties;
import com.abhijit.websvclient.dto.AccountDTO;
import com.abhijit.websvclient.dto.AddAccountDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AccountSvcWebClient implements AccountSvcClient{

    private AppProperties appProperties;
    private WebClient webClient;

    public AccountSvcWebClient(AppProperties appProperties) {
        this.appProperties = appProperties;
        webClient=WebClient.builder()
                .baseUrl(appProperties.getAcsvc())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Override
    public AccountDTO add(AddAccountDTO addAccountDTO) throws JsonProcessingException {
        Mono<AccountDTO> mono= webClient.post()
                .bodyValue(new ObjectMapper().writeValueAsString(addAccountDTO))
                .exchangeToMono(
                      response ->{
                            if(response.statusCode().is2xxSuccessful()){
                                return response.bodyToMono(AccountDTO.class);
                            }else {
                                return response.createException().flatMap(Mono::error);
                            }
                        }
                );
        AccountDTO accountDTO=mono.block();
        log.info("AccountSvcWebClient. NEW AC:"+accountDTO);
        return accountDTO;
    }
}
