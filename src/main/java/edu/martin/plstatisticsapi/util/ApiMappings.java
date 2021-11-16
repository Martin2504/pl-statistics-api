package edu.martin.plstatisticsapi.util;

public final class ApiMappings {

  public static final String API = "api";
  public static final String USERS = "users";
  public static final String PRIVILEGES = "privileges";
  public static final String ROLES = "roles";
  public static final String TEAMS = "football-teams";

  // discoverability

  public static final class Singular {

    public static final String USER = "user";
    public static final String PRIVILEGE = "privilege";
    public static final String ROLE = "role";

  }

  public static final String AUTHENTICATION = "authentication";

  private ApiMappings() {
    throw new AssertionError();
  }

  // API
}
