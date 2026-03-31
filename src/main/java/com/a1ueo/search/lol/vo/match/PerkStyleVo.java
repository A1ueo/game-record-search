package com.a1ueo.search.lol.vo.match;

import java.util.List;

public record PerkStyleVo(
    String decription,
    List<PerkStyleSelectionVo> selections,
    int style
) {

}
