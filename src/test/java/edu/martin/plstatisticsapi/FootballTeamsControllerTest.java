package edu.martin.plstatisticsapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.martin.plstatisticsapi.controller.FootballTeamController;
import edu.martin.plstatisticsapi.model.FootballTeam;
import edu.martin.plstatisticsapi.service.FootballTeamService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(MockitoExtension.class)
public class FootballTeamsControllerTest {

  private ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  @InjectMocks
  FootballTeamController footballTeamController;

  @Mock
  FootballTeamService footballTeamService;

  @BeforeEach
  void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(footballTeamController).build();
    objectMapper = new ObjectMapper();
  }

  /**
   * Testing getAllFootballTeams from the /api/football-teams endpoint.
   * @throws Exception
   */
  @Test
  void getAllFootballTeamsTest() throws Exception {
    // First create a List object with a single team which I would expect as a response.
    List<FootballTeam> teams = Collections.singletonList(new FootballTeam(1L, "CSKA", "Sofia"));
    // Mockito helps me fake the response from the football-teams service.
    // In this case the response should be the list of footballTeams object.
    Mockito.lenient()
      .when(footballTeamService.getAllFootballTeams())
      .thenReturn(teams);
    // Using mockMvc to perform the get request against the endpoint.
    // And return a response.
    MockHttpServletResponse mock = mockMvc.perform(get("/api/football-teams")).andReturn().getResponse();
    // Making a couple of assertions against the response status and the content of the response body.
    Assertions.assertThat(mock.getStatus()).isEqualTo(HttpStatus.OK.value());
    Assertions.assertThat(mock.getContentAsString()).isEqualTo(objectMapper.writeValueAsString(teams));
  }

  /**
   * Testing createFootballTeams from the /api/football-teams endpoint.
   * @throws Exception
   */
  @Test
  void createFootballTeam() throws Exception {
    // Create the team object which I pass to my request body.
    FootballTeam footballTeam = new FootballTeam(1L, "CSKA", "Sofia");
    // Helps fake the response from the football-teams service, saveTeam.
    Mockito.lenient()
      .when(footballTeamService.saveTeam(any()))
      .thenReturn(footballTeam);
    // Performing the post request.
    MockHttpServletResponse mock = mockMvc.perform(
        post("/api/football-teams")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(footballTeam)))
      .andReturn()
      .getResponse();
    // Making the assertions against the status and the location header.
    Assertions.assertThat(mock.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    Assertions.assertThat(mock.getHeader("Location")).isEqualTo("/api/football-teams/"+footballTeam.getId());
  }

}



