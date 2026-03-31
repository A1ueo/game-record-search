package com.a1ueo.search.lol.vo.summoner;

import java.util.List;

public record ChampionMasteryVo(
    String puuid,
    Long championPointsUntilNextLevel,
    Boolean chestGranted,
    Long championId,
    Long lastPlayTime,
    Integer championLevel,
    Integer championPoints,
    Long championPointsSinceLastLevel,
    Integer markRequiredForNextLevel,
    Integer championSeasonMilestone,
    Integer tokensEarned,
    List<String> milestoneGrades
) {

}
