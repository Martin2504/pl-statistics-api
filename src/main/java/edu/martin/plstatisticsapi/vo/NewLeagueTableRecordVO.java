package edu.martin.plstatisticsapi.vo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  property = "_type"
)
public class NewLeagueTableRecordVO {

  private int seasonGoals_home;

  private int seasonConceded;

  private int seasonGoals_away;

  private int seasonConceded_away;

  private int seasonConceded_home;

  private int seasonGoals;

  private int points;

  private float ppg_overall;

  private int seasonGoalDifference;

  private int seasonWins_home;

  private int seasonWins_away;

  private int seasonWins_overall;

  private int seasonDraws_home;

  private int seasonDraws_away;

  private int seasonDraws_overall;

  private int seasonLosses_away;

  private int seasonLosses_home;

  private int seasonLosses_overall;

  private int matchesPlayed;

  /**
   * The Football Team id
   */
  @NotNull
  private Long footballTeamId;

}
