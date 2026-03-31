package com.a1ueo.search.lol.vo.summoner;

public record LeagueEntryVo(
    String leagueId,
    String puuid,
    String queueType,
    String tier,
    String rank,
    Integer leaguePoints,
    Integer wins,
    Integer losses,
    MiniSeriesVo miniSeries
) {

}
