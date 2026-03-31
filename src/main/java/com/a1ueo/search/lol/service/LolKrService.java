package com.a1ueo.search.lol.service;

import com.a1ueo.search.lol.vo.summoner.ChampionMasteryVo;
import com.a1ueo.search.lol.vo.summoner.LeagueEntryVo;
import com.a1ueo.search.lol.vo.summoner.SummonerVo;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Slf4j
public class LolKrService {

  private RestClient restClient;
  @Value("${riot.api-key}")
  String apiKey;

  @PostConstruct
  private void init() {
    restClient = RestClient.builder()
        .baseUrl("https://kr.api.riotgames.com")
        .defaultHeader("X-Riot-Token", apiKey)
        .build();
  }

  public SummonerVo getSummoner(String encryptedPUUID) {
    SummonerVo response = restClient.get()
        .uri("/lol/summoner/v4/summoners/by-puuid/{encryptedPUUID}", encryptedPUUID)
        .retrieve()
        .body(SummonerVo.class);

    return response;
  }

  public List<LeagueEntryVo> getLeagueEntries(String encryptedPUUID) {
    List<LeagueEntryVo> response = restClient.get()
        .uri("/lol/league/v4/entries/by-puuid/{encryptedPUUID}", encryptedPUUID)
        .retrieve()
        .body(List.class);

    return response;
  }

  public List<ChampionMasteryVo> getChampionMasteries(String encryptedPUUID) {
    List<ChampionMasteryVo> response = restClient.get()
        .uri("/lol/champion-mastery/v4/champion-masteries/by-puuid/{encryptedPUUID}/top?count=3",
            encryptedPUUID)
        .retrieve()
        .body(List.class);

    return response;
  }
}
