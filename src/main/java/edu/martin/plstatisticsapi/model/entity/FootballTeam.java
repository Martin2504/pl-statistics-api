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
public class FootballTeam extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "clean_name")
  private String cleanName;

  @Column(name = "english_name")
  private String englishName;

  @Column(name = "short_hand")
  private String shortHand;

  @Column(name = "country")
  private String country;

  @Column(name = "continent")
  private String continent;

  @Column(name = "founded")
  private String founded;

  @Column(name = "image")
  private String image;

  @Column(name = "flag_element")
  private String flagElement;

  @Column(name = "season")
  private String season;

  @Column(name = "season_clean")
  private String seasonClean;

  @Column(name = "url")
  private String url;

  @Column(name = "stadium_name")
  private String stadiumName;

  @Column(name = "stadium_address")
  private String stadiumAddress;

  @Column(name = "table_position")
  private String tablePosition;

  @Column(name = "performance_rank")
  private String performanceRank;

  @Column(name = "risk")
  private String risk;

  @Column(name = "season_format")
  private String seasonFormat;

  @Column(name = "competition_id")
  private String competitionId;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "alt_names")
  private String altNames;

  @Column(name = "official_web_site")
  private String official_web_site;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final FootballTeam other = (FootballTeam) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return getName();
  }

}
