package com.a1ueo.search.lol.vo.match;


public record ParticipantVo(
    Integer assists,
    Integer baronKills,
//    Integer bountyLevel,
    Integer champExperience,
    Integer champLevel,
    Integer championId,
    String championName,

    Integer deaths,
    Integer kills,

    Integer goldEarned,
    Integer goldSpent,

    Integer item0,
    Integer item1,
    Integer item2,
    Integer item3,
    Integer item4,
    Integer item5,
    Integer item6,

    String lane,          // 수정: 실제 String
    String role,

    Integer participantId,
    String puuid,
    String riotIdGameName,
    String riotIdTagline,

    Integer teamId,
    Boolean win,

    PerksVo perks
) {


}
