package com.job.portal.exception;

import java.io.FileNotFoundException;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger EXCEPTION_HANDLER_LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(JSONException.class)
  @ResponseBody
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public String handleJsonException(JSONException ex) {

    EXCEPTION_HANDLER_LOGGER.error("Exception Handling", ex);
    JSONObject errorObj = new JSONObject();
    errorObj.put("errorMessage", "Invalid Request format");
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("errorResponse", errorObj);
    return jsonObject.toString();
  }

  @ExceptionHandler(UnAuthorizedAccessException.class)
  @ResponseBody
  @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
  public String handleRuntimeException(UnAuthorizedAccessException ex) {
    EXCEPTION_HANDLER_LOGGER.error("UnAuthorizedAccess Exception Handling", ex);
    JSONObject errorObj = new JSONObject();
    errorObj.put("errorMessage", ex.getMessage());
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("errorResponse", errorObj);
    return jsonObject.toString();
  }
  
  
  @ExceptionHandler(FileNotFoundException.class)
  @ResponseBody
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public String handleRuntimeException(FileNotFoundException ex) {
    EXCEPTION_HANDLER_LOGGER.error("File not found Handling", ex);
    JSONObject errorObj = new JSONObject();
    errorObj.put("errorMessage", ex.getMessage());
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("errorResponse", errorObj);
    return jsonObject.toString();
  }

  @ExceptionHandler(JobPortalException.class)
  @ResponseBody
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleCASException(JobPortalException ex) {
    String errorMsg = null;
    EXCEPTION_HANDLER_LOGGER.error("CAS Exception Handling", ex);
    JSONObject errorObj = new JSONObject();
    errorObj.put("errorMessage", ex.getMessage());
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("errorResponse", errorObj);
    errorMsg = jsonObject.toString();
    return errorMsg;
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseBody
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleRuntimeException(RuntimeException ex) {
    EXCEPTION_HANDLER_LOGGER.error("Exception Runtime Handling", ex);
    JSONObject errorObj = new JSONObject();
    errorObj.put("errorMessage", ex.getMessage());
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("errorResponse", errorObj);
    return jsonObject.toString();
  }
}
