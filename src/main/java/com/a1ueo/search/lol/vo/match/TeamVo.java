package com.a1ueo.search.lol.vo.match;

import java.util.List;

public record TeamVo(
    List<BanVo> bans,
    ObjectivesVo objectives,
    Integer teamId,
    Boolean win
) {

}
