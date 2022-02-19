package edu.martin.plstatisticsapi.model.entity;

import edu.martin.plstatisticsapi.core.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class LeagueTableRecord extends BaseEntity {


  @Column(name = "season_goals_home")
  private int seasonGoalsHome;

  @Column(name = "season_conceded")
  private int seasonConceded;

  @Column(name = "season_goals_away")
  private int seasonGoalsAway;

  @Column(name = "season_conceded_away")
  private int seasonConcededAway;

  @Column(name = "season_conceded_home")
  private int seasonConcededHome;

  @Column(name = "season_goals")
  private int seasonGoals;

  @Column(name = "points")
  private int points;

  @Column(name = "ppg_overall")
  private int ppgOverall;

  @Column(name = "season_goal_difference")
  private int seasonGoalDifference;

  @Column(name = "season_wins_home")
  private int seasonWinsHome;

  @Column(name = "season_wins_away")
  private int seasonWinsAway;

  @Column(name = "season_wins_overall")
  private int seasonWinsOverall;

  @Column(name = "season_draws_home")
  private int seasonDrawsHome;

  @Column(name = "season_draws_away")
  private int seasonDrawsAway;

  @Column(name = "season_draws_overall")
  private int seasonDrawsOverall;

  @Column(name = "season_losses_away")
  private int seasonLosses_away;

  @Column(name = "season_losses_home")
  private int seasonLosses_home;

  @Column(name = "season_losses_overall")
  private int seasonLosses_overall;

  @Column(name = "matches_played")
  private int matchesPlayed;

  /*
  consider using team ID as foreign key at this point onwards.
   */
  @Column(name = "name")
  private String name;

  @Column(name = "country")
  private String country;

  @Column(name = "cleanName")
  private String cleanName;

  @Column(name = "shortHand")
  private String shortHand;

  @Column(name = "url")
  private String url;

  @Column(name = "season_url_overall")
  private String seasonUrlOverall;

  @Column(name = "season_url_home")
  private String seasonUrlHome;

  @Column(name = "season_url_away")
  private String seasonUrlAway;

  @Column(name = "position")
  private String position;

}
