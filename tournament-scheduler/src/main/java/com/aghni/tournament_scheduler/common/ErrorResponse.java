package com.aghni.tournament_scheduler.common;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime dateTime;
    private String message;
    private Integer errorCode;

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public Integer getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    public ErrorResponse() {

    }
    public ErrorResponse(LocalDateTime dateTime, String message, Integer errorCode) {
        this.dateTime = dateTime;
        this.message = message;
        this.errorCode = errorCode;
    }
}
