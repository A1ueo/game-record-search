package com.a1ueo.search.lol.service;

import com.a1ueo.search.lol.vo.match.MatchVo;
import com.a1ueo.search.lol.vo.summoner.AccountVo;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
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

  public AccountVo getAccount(String gameName, String tagLine) {
    AccountVo response = restClient.get()
        .uri("/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}", gameName, tagLine)
        .retrieve()
        .body(AccountVo.class);

    return response;
  }

  private List<String> getMatchIds(String puuid) {
    List<String> response = restClient.get()
        .uri("/lol/match/v5/matches/by-puuid/{puuid}/ids?count=5", puuid)
        .retrieve()
        .body(List.class);

    return response;
  }

  public List<MatchVo> getMatches(String puuid) {
    List<String> matchIds = getMatchIds(puuid);

    List<MatchVo> response = new ArrayList<>();

    for (String matchId : matchIds) {
      MatchVo match = restClient.get()
          .uri("/lol/match/v5/matches/{matchId}", matchId)
          .retrieve()
          .body(MatchVo.class);

      response.add(match);
    }

    return response;
  }
}
