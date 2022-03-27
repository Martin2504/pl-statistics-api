package edu.martin.plstatisticsapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ControllerTest {

  @Autowired
  private ObjectMapper objectMapper;

  protected ObjectMapper getObjectMapper() {
    return objectMapper;
  }

}
