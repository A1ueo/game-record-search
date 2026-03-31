package com.a1ueo.search.lol.vo.match;


import java.util.List;

public record InfoVo(
    String endOfGameResult,
    long gameCreation,
    long gameDuration,
    long gameEndTimestamp,
    long gameId,
    String gameMode,
    String gameName,
    long gameStartTimestamp,
    String gameType,
    int madId,
    List<ParticipantVo> participants,
    String platformId,
    int queueId,
    List<TeamVo> teams,
    String tournamentCode
) {
}