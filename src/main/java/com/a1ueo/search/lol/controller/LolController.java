package com.a1ueo.search.lol.controller;

import com.a1ueo.search.lol.service.LolService;
import com.a1ueo.search.lol.vo.account.AccountVo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

  public LolController(LolService lolService) {
    this.lolService = lolService;
  }

  @GetMapping("/account")
  public ResponseEntity<AccountVo> getAccount(
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
    AccountVo account = lolService.getAccount(gameName, tagLine);

    return ResponseEntity.ok(account);
  }
}
