package com.a1ueo.search.lol.vo.match;


public record ParticipantVo(
    int assists,
    int baronKills,
    int bountyLevel,
    int champExperience,
    int champLevel,
    int championId,
    String championName,

    int deaths,
    int kills,

    int goldEarned,
    int goldSpent,

    int item0,
    int item1,
    int item2,
    int item3,
    int item4,
    int item5,
    int item6,

    String lane,          // 수정: 실제 String
    String role,

    int participantId,
    String puuid,
    String riotIdGameName,
    String riotIdTagline,

    int teamId,
    boolean win,

    PerksVo perks
) {


}
