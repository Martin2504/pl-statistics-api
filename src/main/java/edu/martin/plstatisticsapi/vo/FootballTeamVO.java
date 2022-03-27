package edu.martin.plstatisticsapi.builder.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.martin.plstatisticsapi.core.vo.BaseVO;
import edu.martin.plstatisticsapi.model.entity.FootballTeam;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class FootballTeamVO extends BaseVO {

  @JsonProperty("id")
  private int externalId;

  private String name;

  private String cleanName;

  @JsonProperty("english_name")
  private String englishName;

  private String shortHand;

  private String country;

  private String continent;

  private String founded;

  private String image;

  @JsonProperty("flag_element")
  private String flagElement;

  private String season;

  private String seasonClean;

  private String url;

  @JsonProperty("stadium_name")
  private String stadiumName;

  @JsonProperty("stadium_address")
  private String stadiumAddress;

  @JsonProperty("table_position")
  private String tablePosition;

  @JsonProperty("performance_rank")
  private String performanceRank;

  private String risk;

  @JsonProperty("season_format")
  private String seasonFormat;

  @JsonProperty("competition_id")
  private String competitionId;

  @JsonProperty("full_name")
  private String fullName;

  @JsonProperty("alt_names")
  private String[] altNames;

  @JsonProperty("official_sites")
  private String[] officialSites;

  public FootballTeam getFootballTeam() {
    return new FootballTeam(
            null,
            externalId,
            name,
            cleanName,
            englishName,
            shortHand,
            country,
            continent,
            founded,
            image,
            flagElement,
            season,
            seasonClean,
            url,
            stadiumName,
            stadiumAddress,
            tablePosition,
            performanceRank,
            risk,
            seasonFormat,
            competitionId,
            fullName,
            String.join(", ",altNames),
            String.join(", ",officialSites)
    );
  }

}
