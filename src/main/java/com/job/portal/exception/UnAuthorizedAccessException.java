package com.job.portal.exception;

import java.util.List;

public class UnAuthorizedAccessException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UnAuthorizedAccessException() {
    super();
  }

  public UnAuthorizedAccessException(String message) {
    super(message);
  }

  public UnAuthorizedAccessException(Throwable cause) {
    super(cause);
  }

  public UnAuthorizedAccessException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

  public UnAuthorizedAccessException(List<String> messages) {

    super(extractMsg(messages));
  }

  private static String extractMsg(List<String> messages) {
    String msg = null;
    if (messages != null) {
      msg = messages.toString().replace("[", "").replace("]", "");
    }
    return msg;
  }

}
