package com.a1ueo.search.lol.vo.match;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MetadataVo {
  private String dataVersion;
  private String matchId;
  private List<String> prticipants;
}
