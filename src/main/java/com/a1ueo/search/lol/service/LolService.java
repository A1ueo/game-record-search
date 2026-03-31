package com.a1ueo.search.lol.service;

import com.a1ueo.search.lol.vo.account.AccountVo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class LolService {

  private RestClient restClient;
  @Value("${riot.api-key}")
  String apiKey;

  @PostConstruct
  private void init() {
    restClient = RestClient.builder()
            .baseUrl("https://asia.api.riotgames.com")
            .defaultHeader("X-Riot-Token", apiKey)
            .build();
  }

  public AccountVo getAccount(
      String gameName,
      String tagLine
  ) {
    AccountVo response = restClient.get()
        .uri("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}", gameName, tagLine)
        .retrieve()
        .body(AccountVo.class);

    log.info(response.toString());

    return response;
  }


}
