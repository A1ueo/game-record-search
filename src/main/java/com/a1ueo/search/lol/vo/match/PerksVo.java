package com.a1ueo.search.lol.vo.match;

import java.util.List;

public record PerksVo(
    PerkStatsVo statPerks,
    List<PerkStyleVo> styles
) {

}
