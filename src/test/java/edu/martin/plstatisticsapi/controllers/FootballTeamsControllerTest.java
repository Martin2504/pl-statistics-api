package edu.martin.plstatisticsapi.controllers;

import edu.martin.plstatisticsapi.config.JwtAuthenticationEntryPoint;
import edu.martin.plstatisticsapi.config.JwtTokenUtil;
import edu.martin.plstatisticsapi.controller.FootballTeamController;
import edu.martin.plstatisticsapi.model.entity.FootballTeam;
import edu.martin.plstatisticsapi.service.FootballTeamService;
import edu.martin.plstatisticsapi.service.JwtUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


// due to using the security layer to test the authorization header as well, these unit tests
// are called integration tests (not unit tests). You may mention this in your paper.

@WebMvcTest(
  value = FootballTeamController.class,
  includeFilters = @ComponentScan.Filter(
    type = FilterType.ASSIGNABLE_TYPE,
    classes = {
      JwtTokenUtil.class,
      JwtAuthenticationEntryPoint.class
    }
    )
)
public class FootballTeamsControllerTest extends ControllerTest{

  //Autowire or mock all the modules, used by the controller in order to execute the test.

  @Autowired
  private WebApplicationContext context;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private JwtUserDetailsService jwtUserDetailsService;

  @MockBean
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @MockBean
  private FootballTeamService service;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  private String token;

  // setting up the context and applying the spring security before each test.
  @BeforeEach
  public void setup() {
    this.mockMvc = MockMvcBuilders
      .webAppContextSetup(this.context)
      .apply(springSecurity())
      .build();

    when(jwtUserDetailsService.loadUserByUsername("test")).thenReturn(new org.springframework.security.core.userdetails.User(
      "test",
      "test",
      new ArrayList<>()
    ));

    this.token = jwtTokenUtil.generateToken(jwtUserDetailsService.loadUserByUsername("test"));
  }

  // assert that mockMvc is created
  @Test
  public void shouldCreateWebMvc() {
    assertNotNull(mockMvc);
  }

  @Test
  void shouldReturnUnauthorized() throws Exception {
    List<FootballTeam> teams = Collections.singletonList(new FootballTeam());
    Mockito.lenient()
      .when(service.getAllFootballTeams())
      .thenReturn(teams);

    mockMvc
      .perform(get("/api/football-teams")) // do not send authorisation header
      .andExpect(status().isUnauthorized());
  }

  @Test
  void shouldReturnNotFound() throws Exception {
    List<FootballTeam> teams = Collections.singletonList(new FootballTeam());
    Mockito.lenient()
      .when(service.getAllFootballTeams())
      .thenReturn(teams);

    mockMvc
      .perform(get("/foo/bar") // Attempt wrong URL
        .header(HttpHeaders.AUTHORIZATION, "Bearer " + this.token))
      .andExpect(status().isNotFound());
  }

  @Test
  void getAllFootballTeamsTest() throws Exception {
    List<FootballTeam> teams = Collections.singletonList(new FootballTeam());
    Mockito.lenient()
      .when(service.getAllFootballTeams())
      .thenReturn(teams);

    mockMvc
      .perform(get("/api/football-teams")
        .header(HttpHeaders.AUTHORIZATION,"Bearer " + this.token))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.size()").value(teams.size()))
      .andExpect(jsonPath("$[0].name").value(teams.get(0).getName()));
  }

}



