package com.a1ueo.search.lol.vo.match;


import java.util.List;

public record MetadataVo(
    String dataVersion,
    String matchId,
    List<String> participants) {
}
