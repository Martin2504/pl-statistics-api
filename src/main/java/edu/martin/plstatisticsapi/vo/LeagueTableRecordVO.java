package edu.martin.plstatisticsapi.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.martin.plstatisticsapi.core.vo.BaseVO;
import edu.martin.plstatisticsapi.model.entity.LeagueTableRecord;
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
public class LeagueTableRecordVO extends BaseVO {

    @JsonProperty("id")
    private int teamId;

    @JsonProperty("seasonGoals_home")
    private int seasonGoalsHome;

    private int seasonConceded;

    @JsonProperty("seasonGoals_away")
    private int seasonGoalsAway;

    @JsonProperty("seasonConceded_away")
    private int seasonConcededAway;

    @JsonProperty("seasonConceded_home")
    private int seasonConcededHome;

    private int seasonGoals;

    private int points;

    @JsonProperty("ppg_overall")
    private float ppgOverall;

    private int seasonGoalDifference;

    @JsonProperty("seasonWins_home")
    private int seasonWinsHome;

    @JsonProperty("seasonWins_away")
    private int seasonWinsAway;

    @JsonProperty("seasonWins_overall")
    private int seasonWinsOverall;

    @JsonProperty("seasonDraws_home")
    private int seasonDrawsHome;

    @JsonProperty("seasonDraws_away")
    private int seasonDrawsAway;

    @JsonProperty("seasonDraws_overall")
    private int seasonDrawsOverall;

    @JsonProperty("seasonLosses_away")
    private int seasonLossesAway;

    @JsonProperty("seasonLosses_home")
    private int seasonLossesHome;

    @JsonProperty("seasonLosses_overall")
    private int seasonLossesOverall;

    private int matchesPlayed;

    private FootballTeamVO footballTeam;

    public LeagueTableRecord getRecord() {
        return new LeagueTableRecord(
                null,
                seasonGoalsHome,
                seasonConceded,
                seasonGoalsAway,
                seasonConcededAway,
                seasonConcededHome,
                seasonGoals,
                points,
                ppgOverall,
                seasonGoalDifference,
                seasonWinsHome,
                seasonWinsAway,
                seasonWinsOverall,
                seasonDrawsHome,
                seasonDrawsAway,
                seasonDrawsOverall,
                seasonLossesAway,
                seasonLossesHome,
                seasonLossesOverall,
                matchesPlayed
        );
    }
}
