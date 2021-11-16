package edu.martin.plstatisticsapi.exceptions;

public final class MyEntityNotFoundException extends RuntimeException {

  public MyEntityNotFoundException() {
    super();
  }

  public MyEntityNotFoundException(final String message) {
    super(message);
  }

  public MyEntityNotFoundException(final String message, Throwable cause) {
    super(message, cause);
  }

  public MyEntityNotFoundException(final Throwable cause) {
    super(cause);
  }

}
