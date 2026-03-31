package com.a1ueo.search.lol.controller;

import com.a1ueo.search.lol.service.LolKrService;
import com.a1ueo.search.lol.service.LolService;
import com.a1ueo.search.lol.vo.match.MatchVo;
import com.a1ueo.search.lol.vo.summoner.AccountVo;
import com.a1ueo.search.lol.vo.summoner.ChampionMasteryVo;
import com.a1ueo.search.lol.vo.summoner.LeagueEntryVo;
import com.a1ueo.search.lol.vo.summoner.SummonerVo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lol")
@Validated
@Slf4j
public class LolController {

  private LolService lolService;
  private LolKrService lolKrService;

  public LolController(LolService lolService, LolKrService lolKrService) {
    this.lolService = lolService;
    this.lolKrService = lolKrService;
  }

  @GetMapping("/info")
  public ResponseEntity<Map<String, Object>> getInfo(
      @RequestParam
      @NotBlank
      @Size(min = 2, max = 16)
      String gameName,

      @RequestParam
      @NotBlank
      @Size(min = 2, max = 16)
      String tagLine
  ) {
    log.info("닉네임: {}, 태그: {}", gameName, tagLine);

    Map<String, Object> response = new HashMap<>();

    AccountVo account = lolService.getAccount(gameName, tagLine);
    SummonerVo summoner = lolKrService.getSummoner(account.puuid());
    List<LeagueEntryVo> leagueEntries = lolKrService.getLeagueEntries(account.puuid());
    List<ChampionMasteryVo> championMasteries = lolKrService.getChampionMasteries(account.puuid());

    response.put("account", account);
    response.put("summoner", summoner);
    response.put("leagueEntries", leagueEntries);
    response.put("championMasteries", championMasteries);

    return ResponseEntity.ok(response);
  }

  @GetMapping("/matches")
  public ResponseEntity<List<MatchVo>> getMatches(
      @RequestParam
      @NotBlank
      String puuid
  ) {
    log.info("고유 아이디: {}", puuid);
    List<MatchVo> matches = lolService.getMatches(puuid);

    return ResponseEntity.ok(matches);
  }
}
