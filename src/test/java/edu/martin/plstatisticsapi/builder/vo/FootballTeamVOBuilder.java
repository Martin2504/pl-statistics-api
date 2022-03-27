package edu.martin.plstatisticsapi.builder.vo;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.martin.plstatisticsapi.builder.VOBuilder;
import edu.martin.plstatisticsapi.builder.vo.FootballTeamVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FootballTeamVOBuilder extends VOBuilder<FootballTeamVO> {

  private int externalId;
  private String name;
  private String cleanName;
  private String englishName;
  private String shortHand;
  private String country;
  private String continent;
  private String founded;
  private String image;
  private String flagElement;
  private String season;
  private String seasonClean;
  private String url;
  private String stadiumName;
  private String stadiumAddress;
  private String tablePosition;
  private String performanceRank;
  private String risk;
  private String seasonFormat;
  private String competitionId;
  private String fullName;
  private String[] altNames;
  private String[] officialSites;

  @Override
  public FootballTeamVO vo() {
    return null;
  }

  public static FootballTeamVOBuilder createFootballTeamVOBuilder() {
    return new FootballTeamVOBuilder();
  }

  public FootballTeamVOBuilder withObjectMapper (final ObjectMapper objectMapper) {
    this.setObjectMapper(objectMapper);
    return this;
  }

  public FootballTeamVOBuilder footballTeamVOWithDefaults() {

    externalId = FootballTeamData.EXTERNAL_ID;
    name = FootballTeamData.NAME;
    cleanName = FootballTeamData.CLEAN_NAME;
    englishName = FootballTeamData.ENGLISH_NAME;
    shortHand = FootballTeamData.SHORT_HAND;
    country = FootballTeamData.COUNTRY;
    continent = FootballTeamData.CONTINENT;
    founded = FootballTeamData.FOUNDED;
    image = FootballTeamData.IMAGE;
    flagElement = FootballTeamData.FLAG_ELEMENT;
    season = FootballTeamData.SEASON;
    seasonClean = FootballTeamData.SEASON_CLEAN;
    url = FootballTeamData.URL;
    stadiumName = FootballTeamData.STADIUM_NAME;
    stadiumAddress = FootballTeamData.STADIUM_ADDRESS;
    tablePosition = FootballTeamData.TABLE_POSITION;
    performanceRank = FootballTeamData.PERFORMANCE_RANK;
    risk = FootballTeamData.RISK;
    seasonFormat = FootballTeamData.SEASON_FORMAT;
    competitionId = FootballTeamData.COMPETITION_ID;
    fullName = FootballTeamData.FULL_NAME;
    altNames = FootballTeamData.ALT_NAMES;
    officialSites = FootballTeamData.OFFICIAL_SITES;

    return this;
  }



}
