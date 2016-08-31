package com.job.portal.exception;

import java.util.List;

public class JobPortalException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public JobPortalException() {
    super();
  }

  public JobPortalException(String message) {
    super(message);
  }

  public JobPortalException(Throwable cause) {
    super(cause);
  }

  public JobPortalException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

  public JobPortalException(List<String> messages) {

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
