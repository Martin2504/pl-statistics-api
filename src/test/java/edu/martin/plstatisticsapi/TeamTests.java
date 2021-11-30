package edu.martin.plstatisticsapi;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class TeamTests {
  @Test
  void contextLoads() {
    when().get("greeting").then().statusCode(200);
  }
}
