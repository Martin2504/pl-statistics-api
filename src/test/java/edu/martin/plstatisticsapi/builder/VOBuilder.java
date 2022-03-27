package edu.martin.plstatisticsapi.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentest4j.AssertionFailedError;

public abstract class VOBuilder<VO> {

  protected ObjectMapper objectMapper;

  /**
   * Construct an instance of the VO
   *
   * @return instance of type VO
   */
  public abstract VO vo();

  public String voToJson() {
    return toJSON(vo());
  }

  protected String toJSON(final Object vo) {
    if (objectMapper == null) {
      throw new AssertionFailedError("No ObjectMapper configured to serialize to JSON");
    }
    try {
      return objectMapper.writeValueAsString(vo);
    } catch (final JsonProcessingException e) {
      throw new AssertionFailedError("Unable to serialize vo to JSON " + e.getMessage(), e);
    }
  }

  public void setObjectMapper(final ObjectMapper mapper) {
    this.objectMapper = mapper;
  }

}
