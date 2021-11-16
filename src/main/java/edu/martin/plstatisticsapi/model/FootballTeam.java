package edu.martin.plstatisticsapi.model;

import edu.martin.plstatisticsapi.interfaces.INameableDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class FootballTeam implements INameableEntity, INameableDto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "TEAM_ID")
  private Long id;

  @Column(unique = true, nullable = false)
  @Size(min = 2, max = 30)
  @NotNull
  private String name;

  @Column(unique = false, nullable = false)
  private String teamAddress;

  public FootballTeam() {
    super();
  }

  public FootballTeam(Long id, String teamName, String teamAddress) {

    super();

    this.id = id;
    this.name = teamName;
    this.teamAddress = teamAddress;

  }

  // API

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String teamName) {
    this.name = teamName;
  }

  public String getTeamAddress() {
    return teamAddress;
  }

  public void setTeamAddress(String teamAddress) {
    this.teamAddress = teamAddress;
  }

  //

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
