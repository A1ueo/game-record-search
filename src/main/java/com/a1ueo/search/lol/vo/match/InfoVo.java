package com.a1ueo.search.lol.vo.match;


import java.util.List;

public record InfoVo(
    String endOfGameResult,
    Long gameCreation,
    Long gameDuration,
    Long gameEndTimestamp,
    Long gameId,
    String gameMode,
    String gameName,
    Long gameStartTimestamp,
    String gameType,
    Integer mapId,
    List<ParticipantVo> participants,
    String platformId,
    Integer queueId,
    List<TeamVo> teams,
    String tournamentCode
) {
}