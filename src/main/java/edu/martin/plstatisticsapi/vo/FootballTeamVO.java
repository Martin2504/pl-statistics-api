package edu.martin.plstatisticsapi.vo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import edu.martin.plstatisticsapi.core.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  property = "_type"
)
public class FootballTeamVO extends BaseVO {

  private String name;

  private String cleanName;

  private String english_name;

  private String shortHand;

  private String country;

  private String continent;

  private String founded;

  private String image;

  private String flag_element;

  private String season;

  private String seasonClean;

  private String url;

  private String stadium_name;

  private String stadium_address;

  private String table_position;

  private String performance_rank;

  private String risk;

  private String season_format;

  private String competition_id;

  private String full_name;

  private String alt_names;

  private String official_sites;

}
